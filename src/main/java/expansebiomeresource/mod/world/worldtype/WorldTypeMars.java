package expansebiomeresource.mod.world.worldtype;

import expansebiomeresource.mod.init.BiomeInit;
import expansebiomeresource.mod.world.layer.GenLayerMars;
import net.minecraft.init.Biomes;
import net.minecraft.world.World;
import net.minecraft.world.WorldType;
import net.minecraft.world.biome.BiomeProvider;
import net.minecraft.world.gen.ChunkGeneratorSettings;
import net.minecraft.world.gen.layer.GenLayer;
import net.minecraftforge.common.BiomeManager.BiomeEntry;
import net.minecraftforge.common.BiomeManager.BiomeType;

public class WorldTypeMars extends WorldType {

	public WorldTypeMars(String name) {
		
		super("Mars");

	}

	@Override
	public GenLayer getBiomeLayer(long worldSeed, GenLayer parentLayer, ChunkGeneratorSettings chunkSettings) {
		
		 
		return new GenLayerMars(worldSeed, parentLayer, this, chunkSettings); 
	}
	
}
