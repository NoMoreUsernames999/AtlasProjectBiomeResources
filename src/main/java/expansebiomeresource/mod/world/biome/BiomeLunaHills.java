package expansebiomeresource.mod.world.biome;

import net.minecraft.init.Blocks;
import net.minecraft.world.biome.Biome;

public class BiomeLunaHills extends Biome {

    public BiomeLunaHills() {

        super(new BiomeProperties("Lunar Hills").setBaseHeight(0.48f).setHeightVariation(0.33f).setRainfall(0.0f).setRainDisabled().setTemperature(1.0f));

        topBlock = Blocks.GRAVEL.getDefaultState();
        fillerBlock = Blocks.CLAY.getDefaultState();

    }


}
