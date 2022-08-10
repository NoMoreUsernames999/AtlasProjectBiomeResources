package expansebiomeresource.mod.world.biome;

import net.minecraft.init.Blocks;
import net.minecraft.world.biome.Biome;

public class BiomeTitanHills extends Biome {

    public BiomeTitanHills() {

        super(new BiomeProperties("Titan Islands").setBaseHeight(0.5f).setHeightVariation(0.35f).setRainfall(0.0f).setRainDisabled().setTemperature(0.5f).setWaterColor(000000));

        topBlock = Blocks.GRAVEL.getDefaultState();
        fillerBlock = Blocks.GRAVEL.getDefaultState();

    }
}
