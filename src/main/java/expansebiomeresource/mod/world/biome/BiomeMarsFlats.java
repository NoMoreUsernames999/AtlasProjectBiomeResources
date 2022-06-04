package expansebiomeresource.mod.world.biome;

import net.minecraft.block.BlockSand;
import net.minecraft.block.BlockSand.EnumType;
import net.minecraft.init.Blocks;
import net.minecraft.world.biome.Biome;

public class BiomeMarsFlats extends Biome {

	public BiomeMarsFlats() {
		
		super(new BiomeProperties("marsflats").setBaseHeight(0.125f).setHeightVariation(0.03f).setRainfall(0.0f).setRainDisabled().setTemperature(2.0f).setWaterColor(14837760)); 
		
		topBlock = Blocks.SAND.getDefaultState().withProperty(BlockSand.VARIANT, EnumType.RED_SAND); 
		fillerBlock = Blocks.RED_SANDSTONE.getDefaultState();
		
	}
	
	 public static enum TempCategory{
	        WARM
	    }
}
