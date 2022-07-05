package expansebiomeresource.mod.world.biome;

import net.minecraft.init.Blocks;
import net.minecraft.world.biome.Biome;

public class BiomeTorusDunesH extends Biome {

    public BiomeTorusDunesH() {

        super(new BiomeProperties("Dune Hills").setBaseHeight(5.0f).setHeightVariation(0.2f).setRainfall(0.4f).setTemperature(0.7f));

        topBlock = Blocks.SAND.getDefaultState();
        fillerBlock = Blocks.GRAVEL.getDefaultState();

    }


}
