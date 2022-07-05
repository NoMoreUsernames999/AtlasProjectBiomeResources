package expansebiomeresource.mod.world.biome;

import net.minecraft.init.Blocks;
import net.minecraft.world.biome.Biome;

public class BiomeTorusIslandFloat extends Biome {

    public BiomeTorusIslandFloat() {

        super(new BiomeProperties("Floating Islands").setBaseHeight(1.0f).setHeightVariation(0.38f).setRainfall(0.4f).setTemperature(0.7f));

        topBlock = Blocks.SANDSTONE.getDefaultState();
        fillerBlock = Blocks.GRAVEL.getDefaultState();

    }


}
