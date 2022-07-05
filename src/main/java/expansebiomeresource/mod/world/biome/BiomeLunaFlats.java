package expansebiomeresource.mod.world.biome;

import net.minecraft.init.Blocks;
import net.minecraft.world.biome.Biome;

public class BiomeLunaFlats extends Biome {

    public BiomeLunaFlats() {

        super(new BiomeProperties("Lunar Flats").setBaseHeight(0.01f).setHeightVariation(0.145f).setRainfall(0.0f).setRainDisabled().setTemperature(1.0f));

        topBlock = Blocks.GRAVEL.getDefaultState();
        fillerBlock = Blocks.CLAY.getDefaultState();

    }


}
