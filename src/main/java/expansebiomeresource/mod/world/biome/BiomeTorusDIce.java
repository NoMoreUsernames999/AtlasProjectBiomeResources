package expansebiomeresource.mod.world.biome;

import net.minecraft.init.Blocks;
import net.minecraft.world.biome.Biome;

public class BiomeTorusDIce extends Biome {

    public BiomeTorusDIce() {

        super(new BiomeProperties("Ice Wastes").setBaseHeight(0.001f).setHeightVariation(0.1f).setRainfall(0.0f).setTemperature(0.2f));

        topBlock = Blocks.ICE.getDefaultState();
        fillerBlock = Blocks.PACKED_ICE.getDefaultState();

    }


}
