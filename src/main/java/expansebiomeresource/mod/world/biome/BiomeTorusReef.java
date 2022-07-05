package expansebiomeresource.mod.world.biome;

import net.minecraft.init.Blocks;
import net.minecraft.world.biome.Biome;

public class BiomeTorusReef extends Biome {

    public BiomeTorusReef() {

        super(new BiomeProperties("Reef").setBaseHeight(5.0f).setHeightVariation(0.05f).setRainfall(0.0f).setTemperature(0.8f));

        topBlock = Blocks.RED_SANDSTONE.getDefaultState();
        fillerBlock = Blocks.CLAY.getDefaultState();

    }


}
