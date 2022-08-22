package expansebiomeresource.mod.world.biome;

import net.minecraft.block.BlockStone;
import net.minecraft.init.Blocks;
import net.minecraft.world.biome.Biome;

public class BiomeTitanFlats extends Biome {

    public BiomeTitanFlats() {

        super(new BiomeProperties("Titan Hills").setBaseHeight(0.25f).setHeightVariation(0.20f).setRainfall(0.0f).setRainDisabled().setTemperature(0.5f).setWaterColor(000000));

        topBlock = Blocks.COBBLESTONE.getDefaultState();
        fillerBlock = Blocks.GRAVEL.getDefaultState();

    }
}
