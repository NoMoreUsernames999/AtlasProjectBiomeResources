package expansebiomeresource.mod.world.biome;

import net.minecraft.block.BlockSand;
import net.minecraft.block.BlockSand.EnumType;
import net.minecraft.init.Blocks;
import net.minecraft.world.biome.Biome;

public class BiomeMarsHills extends Biome {

	public BiomeMarsHills() {
		
		super(new BiomeProperties("Martian Hills").setBaseHeight(1.7f).setHeightVariation(0.2f).setRainfall(0.0f).setRainDisabled().setTemperature(1.0f).setWaterColor(14837760));

		topBlock = Blocks.SAND.getDefaultState().withProperty(BlockSand.VARIANT, EnumType.RED_SAND); 
		fillerBlock = Blocks.RED_SANDSTONE.getDefaultState();
	}
	

}

