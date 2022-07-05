package expansebiomeresource.mod.world.biome;

import net.minecraft.init.Blocks;
import net.minecraft.world.biome.Biome;

public class BiomeTitanOcean extends Biome {

    public BiomeTitanOcean() {

        super(new BiomeProperties("Titan Ocean").setBaseHeight(-0.55f).setHeightVariation(0.1f).setRainfall(0.5f).setTemperature(0.5f).setWaterColor(000000));

        topBlock = Blocks.GRAVEL.getDefaultState();
        fillerBlock = Blocks.COBBLESTONE.getDefaultState();

    }
}
