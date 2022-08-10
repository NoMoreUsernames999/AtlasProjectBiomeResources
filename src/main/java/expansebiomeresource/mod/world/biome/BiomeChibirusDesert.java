package expansebiomeresource.mod.world.biome;

import net.minecraft.init.Blocks;
import net.minecraft.world.biome.Biome;

public class BiomeChibirusDesert extends Biome {

    public BiomeChibirusDesert() {

        super(new BiomeProperties("Violet Sands").setBaseHeight(0.001f).setHeightVariation(0.02f).setRainfall(0.0f).setRainDisabled().setTemperature(2.0f));

        topBlock = Blocks.SAND.getDefaultState();
        fillerBlock = Blocks.SAND.getDefaultState();
    }
}
