package expansebiomeresource.mod.world.biome;

import net.minecraft.init.Blocks;
import net.minecraft.world.biome.Biome;

public class BiomeTorusGrandReef extends Biome {

    public BiomeTorusGrandReef() {

        super(new BiomeProperties("Grand Reef").setBaseHeight(2.0f).setHeightVariation(0.255f).setRainfall(0.4f).setTemperature(0.7f));

        topBlock = Blocks.GRAVEL.getDefaultState();
        fillerBlock = Blocks.GRAVEL.getDefaultState();

    }


}
