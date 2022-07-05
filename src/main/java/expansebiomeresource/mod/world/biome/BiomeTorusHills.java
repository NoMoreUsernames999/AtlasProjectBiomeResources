package expansebiomeresource.mod.world.biome;

import net.minecraft.init.Blocks;
import net.minecraft.world.biome.Biome;

public class BiomeTorusHills extends Biome {

    public BiomeTorusHills() {

        super(new BiomeProperties("Icy Hills").setBaseHeight(1.6f).setHeightVariation(0.28f).setRainfall(0.0f).setTemperature(0.5f));

        topBlock = Blocks.PACKED_ICE.getDefaultState();
        fillerBlock = Blocks.STONE.getDefaultState();

    }


}