package expansebiomeresource.mod.world.biome;

import net.minecraft.init.Blocks;
import net.minecraft.world.biome.Biome;

public class BiomeTorusGrandPit extends Biome {

    public BiomeTorusGrandPit() {

        super(new BiomeProperties("Sinkhole").setBaseHeight(-1.0f).setHeightVariation(0.075f).setRainfall(0.4f).setTemperature(0.7f));

        topBlock = Blocks.GRAVEL.getDefaultState();
        fillerBlock = Blocks.GRAVEL.getDefaultState();

    }


}
