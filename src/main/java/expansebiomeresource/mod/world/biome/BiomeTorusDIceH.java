package expansebiomeresource.mod.world.biome;

import net.minecraft.init.Blocks;
import net.minecraft.world.biome.Biome;

public class BiomeTorusDIceH extends Biome {

    public BiomeTorusDIceH() {

        super(new BiomeProperties("Rocky Ice Wastes").setBaseHeight(-0.25f).setHeightVariation(0.35f).setRainfall(0.0f).setTemperature(0.2f));

        topBlock = Blocks.ICE.getDefaultState();
        fillerBlock = Blocks.PACKED_ICE.getDefaultState();

    }


}