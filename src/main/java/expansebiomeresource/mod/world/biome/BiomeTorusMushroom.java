package expansebiomeresource.mod.world.biome;

import net.minecraft.init.Blocks;
import net.minecraft.world.biome.Biome;

public class BiomeTorusMushroom extends Biome {

    public BiomeTorusMushroom() {

        super(new BiomeProperties("Aquatic Mushroom Forest").setBaseHeight(3.93f).setHeightVariation(0.015f).setRainfall(0.4f).setTemperature(0.7f));

        topBlock = Blocks.DIRT.getDefaultState();
        fillerBlock = Blocks.GRAVEL.getDefaultState();

    }


}
