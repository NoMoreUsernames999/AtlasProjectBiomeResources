package expansebiomeresource.mod.world.biome;

import net.minecraft.init.Blocks;
import net.minecraft.world.biome.Biome;

public class BiomeTorusShallows extends Biome {

    public BiomeTorusShallows() {

        super(new BiomeProperties("Safe Shallows").setBaseHeight(6.51f).setHeightVariation(0.0f).setRainfall(0.4f).setTemperature(1.0f));

        topBlock = Blocks.SAND.getDefaultState();
        fillerBlock = Blocks.GRAVEL.getDefaultState();

    }


}
