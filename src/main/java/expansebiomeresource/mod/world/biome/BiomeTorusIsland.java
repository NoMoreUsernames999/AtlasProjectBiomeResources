package expansebiomeresource.mod.world.biome;

import net.minecraft.block.BlockStone;
import net.minecraft.init.Blocks;
import net.minecraft.world.biome.Biome;

public class BiomeTorusIsland extends Biome {

    public BiomeTorusIsland() {

        super(new BiomeProperties("Island").setBaseHeight(7.85f).setHeightVariation(0.18f).setRainfall(0.4f).setTemperature(0.8f));

        topBlock = Blocks.GRASS.getDefaultState();
        fillerBlock = Blocks.DIRT.getDefaultState();

    }


}
