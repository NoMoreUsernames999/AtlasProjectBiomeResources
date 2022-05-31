package expansebiomeresource.mod.init;

import expansebiomeresource.mod.world.biome.BiomeMarsCanyon;
import expansebiomeresource.mod.world.biome.BiomeMarsFlats;
import expansebiomeresource.mod.world.biome.BiomeMarsHills;
import net.minecraft.world.biome.Biome;
import net.minecraftforge.common.BiomeDictionary;
import net.minecraftforge.common.BiomeDictionary.Type;
import net.minecraftforge.common.BiomeManager;
import net.minecraftforge.common.BiomeManager.BiomeEntry;
import net.minecraftforge.common.BiomeManager.BiomeType;
import net.minecraftforge.fml.common.registry.ForgeRegistries;

public class BiomeInit {
	
	public static final Biome MARSFLATS = new BiomeMarsFlats(); 
	public static final Biome MARSCANYON = new BiomeMarsCanyon(); 
	public static final Biome MARSHILLS = new BiomeMarsHills(); 

	
	public static void registerBiomes() {
	
		initBiome(MARSFLATS, "MarsFlats", BiomeType.DESERT, Type.DEAD, Type.DRY, Type.PLAINS, Type.HOT, Type.SANDY);
		initBiome(MARSCANYON, "MarsCanyon", BiomeType.DESERT, Type.DEAD, Type.DRY, Type.BEACH, Type.OCEAN, Type.RIVER, Type.SANDY);
		initBiome(MARSHILLS, "MarsHills", BiomeType.DESERT, Type.DEAD, Type.DRY, Type.HILLS, Type.MOUNTAIN, Type.SANDY);

	}

	private static Biome initBiome(Biome biome, String name, BiomeType biometype, Type... types) {
		
		biome.setRegistryName(name);
		ForgeRegistries.BIOMES.register(biome);
		System.out.println("Expanse biomes registered"); 
		BiomeDictionary.addTypes(biome, types);
		BiomeManager.addBiome(biometype, new BiomeEntry(biome, 10));
		BiomeManager.addSpawnBiome(biome);
		System.out.println("Expanse biomes added"); 
		return biome; 
	}

}
