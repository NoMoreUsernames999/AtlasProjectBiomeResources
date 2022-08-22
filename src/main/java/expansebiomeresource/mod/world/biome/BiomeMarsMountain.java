package expansebiomeresource.mod.world.biome;

import net.minecraft.block.BlockSand;
import net.minecraft.block.BlockSand.EnumType;
import net.minecraft.init.Blocks;
import net.minecraft.world.biome.Biome;

public class BiomeMarsMountain extends Biome {

	public BiomeMarsMountain() {
		
		super(new BiomeProperties("Olympus Mons").setBaseHeight(6.26f).setHeightVariation(0.8f).setRainfall(0.0f).setRainDisabled().setTemperature(0.8f).setWaterColor(14837760));
		
		topBlock = Blocks.SAND.getDefaultState().withProperty(BlockSand.VARIANT, EnumType.RED_SAND); 
		fillerBlock = Blocks.RED_SANDSTONE.getDefaultState();
		
	}
	

}

