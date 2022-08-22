package expansebiomeresource.mod.world.biome;

import net.minecraft.block.BlockSand;
import net.minecraft.block.BlockSand.EnumType;
import net.minecraft.init.Blocks;
import net.minecraft.world.biome.Biome;

public class BiomeMarsValley extends Biome {

	public BiomeMarsValley() {
		
		super(new BiomeProperties("Dead Ocean").setBaseHeight(-1.7f).setHeightVariation(0.02f).setRainfall(0.0f).setRainDisabled().setTemperature(0.3f).setWaterColor(14837760));
		
		topBlock = Blocks.SAND.getDefaultState().withProperty(BlockSand.VARIANT, EnumType.RED_SAND); 
		fillerBlock = Blocks.RED_SANDSTONE.getDefaultState();
		
	}
	

}

