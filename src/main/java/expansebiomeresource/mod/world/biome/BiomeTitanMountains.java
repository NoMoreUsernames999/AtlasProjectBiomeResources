package expansebiomeresource.mod.world.biome;

import net.minecraft.init.Blocks;
import net.minecraft.world.biome.Biome;

public class BiomeTitanMountains extends Biome {

    public BiomeTitanMountains() {

        super(new BiomeProperties("Titan Mountains").setBaseHeight(1.3f).setHeightVariation(0.46f).setRainfall(0.0f).setRainDisabled().setTemperature(0.7f).setWaterColor(000000));

        topBlock = Blocks.COBBLESTONE.getDefaultState();
        fillerBlock = Blocks.GRAVEL.getDefaultState();

    }
}
