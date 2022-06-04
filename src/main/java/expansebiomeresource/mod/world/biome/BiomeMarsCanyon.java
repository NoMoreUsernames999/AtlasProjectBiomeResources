package expansebiomeresource.mod.world.biome;

import net.minecraft.block.BlockSand;
import net.minecraft.block.BlockSand.EnumType;
import net.minecraft.init.Blocks;
import net.minecraft.world.biome.Biome;

public class BiomeMarsCanyon extends Biome {

	public BiomeMarsCanyon() {
		
		super(new BiomeProperties("marscanyon").setBaseHeight(-1.5f).setHeightVariation(0.1f).setRainfall(0.0f).setRainDisabled().setTemperature(0.7f).setWaterColor(14837760)); 
		
		topBlock = Blocks.SAND.getDefaultState().withProperty(BlockSand.VARIANT, EnumType.RED_SAND); 
		fillerBlock = Blocks.RED_SANDSTONE.getDefaultState();
		
	}
	
	 public static enum TempCategory{
	        OCEAN
	    }
}
