package expansebiomeresource.mod.world.biome;

import net.minecraft.block.BlockSand;
import net.minecraft.block.BlockSand.EnumType;
import net.minecraft.init.Blocks;
import net.minecraft.world.biome.Biome;

public class BiomeMarsMountain extends Biome {

	public BiomeMarsMountain() {
		
		super(new BiomeProperties("marsmountain").setBaseHeight(2.5f).setHeightVariation(1.0f).setRainfall(0.0f).setRainDisabled().setTemperature(2.0f).setWaterColor(14837760));
		
		topBlock = Blocks.SAND.getDefaultState().withProperty(BlockSand.VARIANT, EnumType.RED_SAND); 
		fillerBlock = Blocks.RED_SANDSTONE.getDefaultState();
		
	}
	
	 public enum TempCategory {
	        MEDIUM
	}
}

