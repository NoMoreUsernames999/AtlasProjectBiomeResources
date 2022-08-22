package expansebiomeresource.mod.world.biome;

import net.minecraft.init.Blocks;
import net.minecraft.world.biome.Biome;

public class BiomePythreaRidge extends Biome {

    public BiomePythreaRidge() {

        super(new BiomeProperties("Archipelago").setBaseHeight(2.6f).setHeightVariation(0.0f).setRainfall(0.5f).setTemperature(0.8f));

        topBlock = Blocks.GRASS.getDefaultState();
        fillerBlock = Blocks.DIRT.getDefaultState();
    }
}
