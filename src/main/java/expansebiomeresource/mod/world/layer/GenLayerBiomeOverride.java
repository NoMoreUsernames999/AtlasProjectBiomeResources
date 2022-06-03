package expansebiomeresource.mod.world.layer;

import net.minecraft.util.WeightedRandom;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.gen.ChunkGeneratorSettings;
import net.minecraft.world.gen.layer.GenLayer;
import net.minecraft.world.gen.layer.IntCache;
import net.minecraftforge.common.BiomeManager;

import javax.annotation.Nonnull;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Random;

public class GenLayerBiomeOverride extends GenLayer
{
    private final HashMap<BiomeManager.BiomeType, List<BiomeManager.BiomeEntry>> biomeTypeMap = new HashMap<>();
    private final List<Biome> oceans;
    private final ChunkGeneratorSettings settings;
    private final Random fallback;

    public GenLayerBiomeOverride(long seed, GenLayer genLayer, ChunkGeneratorSettings settings, HashMap<BiomeManager.BiomeEntry, BiomeManager.BiomeType> biomes, List<Biome> oceans) {
        super(seed);
        this.parent = genLayer;
        for (BiomeManager.BiomeType type : BiomeManager.BiomeType.values()) biomeTypeMap.put(type,new ArrayList<>());
        for(BiomeManager.BiomeEntry entry : biomes.keySet()) biomeTypeMap.get(biomes.get(entry)).add(entry);
        List<BiomeManager.BiomeType> toRemove = new ArrayList<>();
        for(BiomeManager.BiomeType type : this.biomeTypeMap.keySet()) if(biomeTypeMap.get(type).isEmpty()) toRemove.add(type);
        for(BiomeManager.BiomeType type : toRemove) this.biomeTypeMap.remove(type);
        this.settings = settings;
        this.fallback = new Random(seed);
        this.oceans = oceans;
    }

    @Override
    public @Nonnull int[] getInts(int areaX, int areaY, int areaWidth, int areaHeight) {
        int[] aint = this.parent.getInts(areaX, areaY, areaWidth, areaHeight);
        int[] aint1 = IntCache.getIntCache(areaWidth * areaHeight);
        for (int i = 0; i < areaHeight; ++i) {
            for (int j = 0; j < areaWidth; ++j) {
                this.initChunkSeed(j + areaX, i + areaY);
                int k = aint[j + i * areaWidth];
                k = k & -3841;
                if (this.settings != null && this.settings.fixedBiome >= 0) aint1[j + i * areaWidth] = this.settings.fixedBiome;
                else if (isBiomeOceanic(k) && this.oceans.contains(Biome.getBiome(k))) aint1[j + i * areaWidth] = k;
                else if (k == 1 && this.biomeTypeMap.containsKey(BiomeManager.BiomeType.DESERT) && !this.biomeTypeMap.get(BiomeManager.BiomeType.DESERT).isEmpty()) {
                    aint1[j + i * areaWidth] = Biome.getIdForBiome(getWeightedBiomeEntry(BiomeManager.BiomeType.DESERT).biome);
                }
                else if (k == 2 && this.biomeTypeMap.containsKey(BiomeManager.BiomeType.WARM) && !this.biomeTypeMap.get(BiomeManager.BiomeType.WARM).isEmpty()) {
                    aint1[j + i * areaWidth] = Biome.getIdForBiome(getWeightedBiomeEntry(BiomeManager.BiomeType.WARM).biome);
                }
                else if (k == 3 && this.biomeTypeMap.containsKey(BiomeManager.BiomeType.COOL) && !this.biomeTypeMap.get(BiomeManager.BiomeType.COOL).isEmpty()) {
                    aint1[j + i * areaWidth] = Biome.getIdForBiome(getWeightedBiomeEntry(BiomeManager.BiomeType.COOL).biome);
                }
                else if (k == 4 && this.biomeTypeMap.containsKey(BiomeManager.BiomeType.ICY) && !this.biomeTypeMap.get(BiomeManager.BiomeType.ICY).isEmpty()) {
                    aint1[j + i * areaWidth] = Biome.getIdForBiome(getWeightedBiomeEntry(BiomeManager.BiomeType.ICY).biome);
                }
                else aint1[j + i * areaWidth] = Biome.getIdForBiome(getWeightedBiomeEntry(new ArrayList<>(this.biomeTypeMap.keySet()).get(this.fallback.nextInt(this.biomeTypeMap.keySet().size()))).biome);
            }
        }
        return aint1;
    }

    protected BiomeManager.BiomeEntry getWeightedBiomeEntry(BiomeManager.BiomeType type) {
        List<BiomeManager.BiomeEntry> biomeList = this.biomeTypeMap.get(type);
        int totalWeight = WeightedRandom.getTotalWeight(biomeList);
        int weight = BiomeManager.isTypeListModded(type)?nextInt(totalWeight):nextInt(totalWeight / 10) * 10;
        return WeightedRandom.getRandomItem(biomeList, weight);
    }
}
