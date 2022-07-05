package expansebiomeresource.mod.world.biome;

import net.minecraft.init.Blocks;
import net.minecraft.world.biome.Biome;

public class BiomeTorusKelp extends Biome {

    public BiomeTorusKelp() {

        super(new BiomeProperties("Creepvine Forest").setBaseHeight(6.7f).setHeightVariation(0.018f).setRainfall(0.4f).setTemperature(0.8f));

        topBlock = Blocks.SAND.getDefaultState();
        fillerBlock = Blocks.DIRT.getDefaultState();

    }


}
