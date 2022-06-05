package expansebiomeresource.mod.world.biome;

import net.minecraft.block.BlockSand;
import net.minecraft.block.BlockSand.EnumType;
import net.minecraft.init.Blocks;
import net.minecraft.world.biome.Biome;

public class BiomeMarsCanyon extends Biome {

	public BiomeMarsCanyon() {
		
		super(new BiomeProperties("Mars_Canyon").setBaseHeight(-1.5f).setHeightVariation(0.1f).setTemperature(0.5f).setRainfall(0.0f).setRainDisabled().setWaterColor(14837760));
		
		topBlock = Blocks.SAND.getDefaultState().withProperty(BlockSand.VARIANT, EnumType.RED_SAND); 
		fillerBlock = Blocks.RED_SANDSTONE.getDefaultState();
		
	}
	

}
