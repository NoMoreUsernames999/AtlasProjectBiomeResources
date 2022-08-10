package expansebiomeresource.mod.world.biome;

import net.minecraft.init.Blocks;
import net.minecraft.world.biome.Biome;

public class BiomePythreaIslands extends Biome {

    public BiomePythreaIslands() {

        super(new BiomeProperties("Archipelago").setBaseHeight(0.82F).setHeightVariation(0.05F).setTemperature(0.8F).setRainfall(0.5F).setWaterColor(65535));

        topBlock = Blocks.SAND.getDefaultState();
        fillerBlock = Blocks.DIRT.getDefaultState();
       // decorator.deadBushPerChunk = 3;
       // spawnableCreatureList.clear();
    }
}
