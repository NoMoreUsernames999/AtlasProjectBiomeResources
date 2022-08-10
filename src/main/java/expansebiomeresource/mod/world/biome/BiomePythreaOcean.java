package expansebiomeresource.mod.world.biome;

import net.minecraft.init.Blocks;
import net.minecraft.world.biome.Biome;

public class BiomePythreaOcean extends Biome {

    public BiomePythreaOcean() {

        super(new BiomeProperties("Pythrea Ocean").setBaseHeight(-0.08f).setHeightVariation(0.05f).setRainfall(0.5f).setTemperature(0.8f));

        topBlock = Blocks.GRAVEL.getDefaultState();
        fillerBlock = Blocks.SAND.getDefaultState();
    }
}
