package expansebiomeresource.mod.world;

import expansebiomeresource.mod.ExpanseBiomeResource;
import expansebiomeresource.mod.init.BiomeInit;
import expansebiomeresource.mod.world.layer.*;
import net.minecraft.init.Biomes;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.World;
import net.minecraft.world.WorldType;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.BiomeProvider;
import net.minecraft.world.gen.ChunkGeneratorSettings;
import net.minecraft.world.gen.layer.*;
import net.minecraft.world.storage.WorldInfo;
import net.minecraftforge.common.BiomeDictionary;
import net.minecraftforge.common.BiomeManager;
import net.minecraftforge.fml.common.registry.ForgeRegistries;

import javax.annotation.Nonnull;
import java.util.*;

public class WorldTypes {
    public static final HashMap<String, WorldType> WORLD_TYPE_BUNDLES = new HashMap<>();

    public static void init() {
        //Note that through JED you can reference world types by their names. It would just be mars in this case
        WORLD_TYPE_BUNDLES.put("mars",new WorldTypeBundle("mars", Arrays.asList("marsflats","marscanyon","marsmountain","marsedge","marshills"),false));
    }

    public static class WorldTypeBundle extends WorldType {
        private final HashMap<BiomeManager.BiomeEntry, BiomeManager.BiomeType> biomes = new HashMap<>();
        private final boolean allowGlitchedBiomeTypes;

        public WorldTypeBundle(String name, List<String> biomes, boolean allowGlitchedBiomeTypes) {
            super(name);
            for(String biome : biomes) {
                if(BiomeInit.biomeMap.containsKey(biome)) this.biomes.put(BiomeInit.biomeMap.get(biome),BiomeInit.typeMap.get(biome));
                else {
                    ResourceLocation forgeBiome = new ResourceLocation(biome);
                    if(ForgeRegistries.BIOMES.containsKey(forgeBiome)) {
                        BiomeManager.BiomeEntry entry = new BiomeManager.BiomeEntry(ForgeRegistries.BIOMES.getValue(forgeBiome),10);
                        for(BiomeManager.BiomeType type : BiomeManager.BiomeType.values()) {
                            if(BiomeManager.getBiomes(type)!=null) {
                                for (BiomeManager.BiomeEntry entries : Objects.requireNonNull(BiomeManager.getBiomes(type))) {
                                    if (entries.biome == entry.biome) this.biomes.put(entry, type);
                                }
                            }
                        }
                    }
                    else ExpanseBiomeResource.LOGGER.error("Biome "+biome+" does not exist and cannot be added to the biome provider!");
                }
            }
            if(this.biomes.isEmpty()) {
                ExpanseBiomeResource.LOGGER.error("Biome list for world type "+this.getName()+" was empty! Defaulting to the vanilla plains biome.");
                for(BiomeManager.BiomeType type : BiomeManager.BiomeType.values()) {
                    this.biomes.put(new BiomeManager.BiomeEntry(Biomes.PLAINS, 10),type);
                }
            }
            this.allowGlitchedBiomeTypes = allowGlitchedBiomeTypes;
        }

        @Override
        public @Nonnull BiomeProvider getBiomeProvider(@Nonnull World world) {
            return new CustomBiomeProvider(this.biomes,world.getSeed(),world.getWorldInfo(),this,this.allowGlitchedBiomeTypes);
        }

        @Override
        public boolean canBeCreated() {
            return true;
        }
    }

    private static class CustomBiomeProvider extends BiomeProvider {
        private final HashMap<BiomeManager.BiomeEntry, BiomeManager.BiomeType> biomeMap;
        private final List<Biome> biomes = new ArrayList<>();
        private final Random random;

        private CustomBiomeProvider(HashMap<BiomeManager.BiomeEntry, BiomeManager.BiomeType> biomes, long seed, WorldInfo info, WorldType worldType, boolean allowGlitchedBiomeTypes) {
            this.biomeMap = biomes;
            for(BiomeManager.BiomeEntry entry : biomes.keySet()) this.biomes.add(entry.biome);
            this.random = new Random(seed);
            if(!info.getGeneratorOptions().isEmpty()) this.settings = ChunkGeneratorSettings.Factory.jsonToFactory(info.getGeneratorOptions()).build();
            GenLayer[] genlayer = customBiomeGenerators(seed,this.settings,worldType,allowGlitchedBiomeTypes);
            this.genBiomes = genlayer[0];
            this.biomeIndexLayer = genlayer[1];
        }

        public GenLayer[] customBiomeGenerators(long seed, ChunkGeneratorSettings settings, WorldType worldType, boolean allowGlitchedBiomeTypes) {
            ArrayList<BiomeManager.BiomeEntry> oceans = new ArrayList<>();
            for(BiomeManager.BiomeEntry entry : this.biomeMap.keySet()) {
                if(BiomeDictionary.getTypes(entry.biome).contains(BiomeDictionary.Type.OCEAN)) oceans.add(entry);
            }

            ArrayList<BiomeManager.BiomeEntry> mushrooms = new ArrayList<>();
            for(BiomeManager.BiomeEntry entry : this.biomeMap.keySet()) {
                if(BiomeDictionary.getTypes(entry.biome).contains(BiomeDictionary.Type.MUSHROOM)) mushrooms.add(entry);
            }

            ArrayList<BiomeManager.BiomeEntry> rivers = new ArrayList<>();
            for(BiomeManager.BiomeEntry entry : this.biomeMap.keySet()) {
                if(BiomeDictionary.getTypes(entry.biome).contains(BiomeDictionary.Type.RIVER)) rivers.add(entry);
            }
            for(BiomeManager.BiomeEntry entry : rivers) biomeMap.remove(entry);
            if(this.biomeMap.isEmpty()) for(BiomeManager.BiomeType type : BiomeManager.BiomeType.values()) this.biomeMap.put(new BiomeManager.BiomeEntry(Biomes.PLAINS, 10),type);

            GenLayer genlayer = new GenLayerIsland(1L);
            genlayer = new GenLayerFuzzyZoom(2000L, genlayer);
            GenLayer genlayeraddisland = new GenLayerAddIsland(1L, genlayer);
            GenLayer genlayerzoom = new GenLayerZoom(2001L, genlayeraddisland);
            GenLayer genlayeraddisland1 = new GenLayerAddIsland(2L, genlayerzoom);
            genlayeraddisland1 = new GenLayerAddIsland(50L, genlayeraddisland1);
            genlayeraddisland1 = new GenLayerAddIsland(70L, genlayeraddisland1);
            GenLayer genlayerremovetoomuchocean = new GenLayerRemoveTooMuchOcean(2L, genlayeraddisland1);
            GenLayer genlayeraddsnow = new GenLayerAddSnow(2L, genlayerremovetoomuchocean);
            GenLayer genlayeraddisland2 = new GenLayerAddIsland(3L, genlayeraddsnow);
            GenLayer genlayeredge = new GenLayerEdge(2L, genlayeraddisland2, GenLayerEdge.Mode.COOL_WARM);
            genlayeredge = new GenLayerEdge(2L, genlayeredge, GenLayerEdge.Mode.HEAT_ICE);
            genlayeredge = new GenLayerEdge(3L, genlayeredge, GenLayerEdge.Mode.SPECIAL);
            GenLayer genlayerzoom1 = new GenLayerZoom(2002L, genlayeredge);
            genlayerzoom1 = new GenLayerZoom(2003L, genlayerzoom1);
            GenLayer genlayeraddisland3 = new GenLayerAddIsland(4L, genlayerzoom1);
            GenLayer genlayeraddmushroomisland = genlayeraddisland3;
            if(!mushrooms.isEmpty()) genlayeraddmushroomisland = new GenLayerMushroomOverride(5L, genlayeraddisland3,mushrooms.get(this.random.nextInt(mushrooms.size())).biome);
            GenLayer genlayerdeepocean = genlayeraddmushroomisland;
            if(!oceans.isEmpty()) genlayerdeepocean = new GenLayerOceanOverride(4L, genlayeraddmushroomisland, oceans.get(this.random.nextInt(oceans.size())).biome);
            GenLayer genlayer4 = GenLayerZoom.magnify(1000L, genlayerdeepocean, 0);
            int i = 4;
            int j = i;

            if (settings != null) {
                i = settings.biomeSize;
                j = settings.riverSize;
            }

            i = GenLayer.getModdedBiomeSize(worldType, i);
            ArrayList<Biome> actualOceans = new ArrayList<>();
            for(BiomeManager.BiomeEntry entry : oceans) actualOceans.add(entry.biome);
            ArrayList<Biome> actualRivers = new ArrayList<>();
            for(BiomeManager.BiomeEntry entry : rivers) actualRivers.add(entry.biome);

            GenLayer lvt_7_1_ = GenLayerZoom.magnify(1000L, genlayer4, 0);
            GenLayer genlayerriverinit = lvt_7_1_;
            if(!rivers.isEmpty()) genlayerriverinit = new GenLayerRiverInit(100L, lvt_7_1_);
            GenLayer genlayerbiomeedge = this.getBiomeLayer(genlayer4, settings,actualOceans,allowGlitchedBiomeTypes);
            GenLayer lvt_9_1_ = GenLayerZoom.magnify(1000L, genlayerriverinit, 2);
            GenLayer genlayerhills = new GenLayerHillsOverride(1000L, genlayerbiomeedge, lvt_9_1_, pairRandomHillVariant());
            GenLayer genlayer5 = GenLayerZoom.magnify(1000L, genlayerriverinit, 2);
            genlayer5 = GenLayerZoom.magnify(1000L, genlayer5, j);
            GenLayer genlayerriver = genlayer5;
            if(!rivers.isEmpty())  genlayerriver = new GenLayerRiverOverride(1L, genlayer5, rivers.get(this.random.nextInt(rivers.size())).biome);
            GenLayer genlayersmooth = new GenLayerSmooth(1000L, genlayerriver);
            for (int k = 0; k < i; ++k) {
                genlayerhills = new GenLayerZoom(1000 + k, genlayerhills);
                if (k == 0) {
                    genlayerhills = new GenLayerAddIsland(3L, genlayerhills);
                }
            }
            GenLayer genlayersmooth1 = new GenLayerSmooth(1000L, genlayerhills);
            GenLayer genlayerrivermix = new GenLayerRiverMixOverride(100L, genlayersmooth1, genlayersmooth,actualOceans,actualRivers);
            GenLayer genlayer3 = new GenLayerVoronoiZoom(10L, genlayerrivermix);
            genlayerrivermix.initWorldGenSeed(seed);
            genlayer3.initWorldGenSeed(seed);
            return new GenLayer[] {genlayerrivermix, genlayer3, genlayerrivermix};
        }

        public GenLayer getBiomeLayer(GenLayer parentLayer, ChunkGeneratorSettings chunkSettings, List<Biome> oceans, boolean allowGlitchedBiomeTypes) {
            GenLayer ret = new GenLayerBiomeOverride(200L, parentLayer, chunkSettings, this.biomeMap, oceans, allowGlitchedBiomeTypes);
            ret = GenLayerZoom.magnify(1000L, ret, 2);
            HashMap<Biome, Biome> edges = pairRandomEdgeVariant();
            //if(edges!=null) ret = new GenLayerBiomeEdgeOverride(1000L, ret,pairRandomEdgeVariant());
            return ret;
        }

        private HashMap<Biome, Biome> pairRandomHillVariant() {
            HashMap<Biome, Biome> ret = new HashMap<>();
            for(Biome biome : this.biomes) ret.put(biome,returnRandomPossible(BiomeInit.biomeHillMap.get(biome)));
            int i = 0;
            for(Biome biome : ret.values()) if(biome!=null) i++;
            if(i!=0) return ret;
            return null;
        }

        private HashMap<Biome, Biome> pairRandomEdgeVariant() {
            HashMap<Biome, Biome> ret = new HashMap<>();
            for(Biome biome : this.biomes) ret.put(biome,returnRandomPossible(BiomeInit.biomeEdgeMap.get(biome)));
            int i = 0;
            for(Biome biome : ret.values()) if(biome!=null) i++;
            if(i!=0) return ret;
            return null;
        }

        private Biome returnRandomPossible(List<Biome> check) {
            List<Biome> possible = new ArrayList<>();
            for(Biome b : check) if(this.biomes.contains(b)) possible.add(b);
            if(!possible.isEmpty()) return possible.get(this.random.nextInt(possible.size()));
            return null;
        }
    }
}
