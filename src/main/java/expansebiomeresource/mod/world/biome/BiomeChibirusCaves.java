package expansebiomeresource.mod.world.biome;

import net.minecraft.init.Blocks;
import net.minecraft.world.biome.Biome;

public class BiomeChibirusCaves extends Biome {

    public BiomeChibirusCaves() {

        super(new BiomeProperties("Shattered Crag").setBaseHeight(-1.1f).setHeightVariation(0.57f).setRainfall(0.5f).setTemperature(0.7f));

        topBlock = Blocks.GRAVEL.getDefaultState();
        fillerBlock = Blocks.COBBLESTONE.getDefaultState();
    }
}
