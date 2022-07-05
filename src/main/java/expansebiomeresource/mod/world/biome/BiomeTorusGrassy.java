package expansebiomeresource.mod.world.biome;

import net.minecraft.init.Blocks;
import net.minecraft.world.biome.Biome;

public class BiomeTorusGrassy extends Biome {

    public BiomeTorusGrassy() {

        super(new BiomeProperties("Grassy Plateaus").setBaseHeight(6.1f).setHeightVariation(0.007f).setRainfall(0.4f).setTemperature(0.7f));

        topBlock = Blocks.SAND.getDefaultState();
        fillerBlock = Blocks.GRAVEL.getDefaultState();

    }


}
