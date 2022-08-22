package expansebiomeresource.mod.world.biome;

import net.minecraft.init.Blocks;
import net.minecraft.world.biome.Biome;

public class BiomeTorusBulbs extends Biome {

    public BiomeTorusBulbs() {

        super(new BiomeProperties("Bulb Zone").setBaseHeight(1.5f).setHeightVariation(0.15f).setRainfall(0.4f).setTemperature(0.7f));

        topBlock = Blocks.CLAY.getDefaultState();
        fillerBlock = Blocks.GRAVEL.getDefaultState();

    }


}
