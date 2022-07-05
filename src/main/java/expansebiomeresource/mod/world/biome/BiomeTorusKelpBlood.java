package expansebiomeresource.mod.world.biome;

import net.minecraft.init.Blocks;
import net.minecraft.world.biome.Biome;

public class BiomeTorusKelpBlood extends Biome {

    public BiomeTorusKelpBlood() {

        super(new BiomeProperties("Blood Kelp Forest").setBaseHeight(-0.3f).setHeightVariation(0.2f).setRainfall(0.4f).setTemperature(0.4f));

        topBlock = Blocks.GRAVEL.getDefaultState();
        fillerBlock = Blocks.STONE.getDefaultState();

    }


}
