package expansebiomeresource.mod.world.biome;

import net.minecraft.init.Blocks;
import net.minecraft.world.biome.Biome;

public class BiomeTorusDunes extends Biome {

    public BiomeTorusDunes() {

        super(new BiomeProperties("Dunes").setBaseHeight(4.8f).setHeightVariation(0.15f).setRainfall(0.4f).setTemperature(0.7f));

        topBlock = Blocks.SAND.getDefaultState();
        fillerBlock = Blocks.GRAVEL.getDefaultState();

    }


}
