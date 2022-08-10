package expansebiomeresource.mod.world.biome;

import net.minecraft.init.Blocks;
import net.minecraft.world.biome.Biome;

public class BiomePythreaShallows extends Biome {

    public BiomePythreaShallows() {

        super(new BiomeProperties("Pythrea Lagoon").setBaseHeight(0.215f).setHeightVariation(0.01f).setRainfall(0.5f).setTemperature(0.8f));

        topBlock = Blocks.SAND.getDefaultState();
        fillerBlock = Blocks.SAND.getDefaultState();
    }
}
