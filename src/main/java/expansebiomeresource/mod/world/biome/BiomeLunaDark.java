package expansebiomeresource.mod.world.biome;

import net.minecraft.init.Blocks;
import net.minecraft.world.biome.Biome;

public class BiomeLunaDark extends Biome {

    public BiomeLunaDark() {

        super(new BiomeProperties("Lunar Craters").setBaseHeight(-1.2f).setHeightVariation(0.12f).setRainfall(0.0f).setRainDisabled().setTemperature(0.7f));

        topBlock = Blocks.STONE.getDefaultState();
        fillerBlock = Blocks.CLAY.getDefaultState();

    }


}