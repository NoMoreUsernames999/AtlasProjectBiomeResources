package expansebiomeresource.mod.init;

import expansebiomeresource.mod.ExpanseBiomeResource;
import expansebiomeresource.mod.world.biome.*;
import net.minecraft.world.biome.Biome;
import net.minecraftforge.common.BiomeDictionary;
import net.minecraftforge.common.BiomeDictionary.Type;
import net.minecraftforge.common.BiomeManager;
import net.minecraftforge.common.BiomeManager.BiomeEntry;
import net.minecraftforge.common.BiomeManager.BiomeType;
import net.minecraftforge.fml.common.registry.ForgeRegistries;

import java.util.*;

@SuppressWarnings("SameParameterValue")
public class BiomeInit {
	public static final HashMap<String, BiomeEntry> biomeMap = new HashMap<>();
	public static final HashMap<String, BiomeType> typeMap = new HashMap<>();
	public static final HashMap<Biome, List<Biome>> biomeEdgeMap = new HashMap<>();
	public static final HashMap<Biome, List<Biome>> biomeHillMap = new HashMap<>();
	
	public static final Biome MARSFLATS = new BiomeMarsFlats(); 
	public static final Biome MARSCANYON = new BiomeMarsCanyon(); 
	public static final Biome MARSHILLS = new BiomeMarsHills(); 
	public static final Biome MARSMOUNTAIN = new BiomeMarsMountain(); 
	public static final Biome MARSVALLEY = new BiomeMarsValley();
	public static final Biome MARSBARREN = new BiomeMarsBarren();
	
	public static void registerBiomes() {
		initBiome(MARSFLATS, "marsflats", 30, false, new ArrayList<>(), Arrays.asList(MARSHILLS, MARSMOUNTAIN), BiomeType.DESERT, Type.DEAD, Type.DRY, Type.PLAINS, Type.HOT, Type.SANDY);
		initBiome(MARSCANYON, "marscanyon", 20, false, new ArrayList<>(), new ArrayList<>(), BiomeType.WARM, Type.DRY, Type.RIVER, Type.SANDY);
		initBiome(MARSHILLS, "marshills", 15, false, new ArrayList<>(), new ArrayList<>(), BiomeType.WARM, Type.DEAD, Type.DRY, Type.HILLS, Type.SANDY);
		initBiome(MARSMOUNTAIN, "marsmountain", 15, false, new ArrayList<>(), new ArrayList<>(), BiomeType.COOL, Type.DEAD, Type.DRY, Type.MOUNTAIN, Type.SANDY);
		initBiome(MARSVALLEY, "marsvalley", 5, true, new ArrayList<>(), new ArrayList<>(), BiomeType.COOL, Type.DEAD, Type.DRY, Type.RARE, Type.OCEAN, Type.SANDY);
		initBiome(MARSBARREN, "marsbarren", 25, false, new ArrayList<>(), new ArrayList<>(), BiomeType.WARM, Type.DEAD, Type.DRY, Type.PLAINS, Type.SANDY);
	}

	private static void initBiome(Biome biome, String name, int weight, boolean isOceanic, List<Biome> edges, List<Biome> hills, BiomeType biometype, Type... types) {
		biome.setRegistryName(name);
		ForgeRegistries.BIOMES.register(biome);
		BiomeDictionary.addTypes(biome, types);
		BiomeEntry entry = new BiomeEntry(biome, weight);
		BiomeManager.addBiome(biometype, entry);
		BiomeManager.addSpawnBiome(biome);
		if(isOceanic) BiomeManager.oceanBiomes.add(biome);
		biomeMap.put(name,entry);
		typeMap.put(name,biometype);
		biomeEdgeMap.put(biome,edges);
		biomeHillMap.put(biome,hills);
		ExpanseBiomeResource.LOGGER.info("Expanse biomes registered");
	}

}
