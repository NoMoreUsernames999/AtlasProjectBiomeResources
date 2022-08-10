package expansebiomeresource.mod.world.biome;

import net.minecraft.init.Blocks;
import net.minecraft.world.biome.Biome;

public class BiomePythreaTrench extends Biome {

    public BiomePythreaTrench() {

        super(new BiomeProperties("Pyhrea Trench").setBaseHeight(-1.7f).setHeightVariation(0.01f).setRainfall(0.5f).setTemperature(0.8f));

        topBlock = Blocks.DIRT.getDefaultState();
        fillerBlock = Blocks.STONE.getDefaultState();
    }
}
