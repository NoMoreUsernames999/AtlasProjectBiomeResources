package expansebiomeresource.mod.world.biome;

import net.minecraft.init.Blocks;
import net.minecraft.world.biome.Biome;

public class BiomePlocuryRiver extends Biome {

    public BiomePlocuryRiver() {

        super(new BiomeProperties("Dry River").setBaseHeight(-0.5f).setHeightVariation(0.0f).setRainfall(0.5f).setTemperature(1.5f).setWaterColor(0));

        topBlock = Blocks.SAND.getDefaultState();
        fillerBlock = Blocks.CLAY.getDefaultState();
        this.decorator.generateFalls = false;
        this.decorator.deadBushPerChunk = 0;
        this.decorator.cactiPerChunk = 0;
        this.decorator.treesPerChunk = 0;
        this.decorator.extraTreeChance = 0.0f;
        this.decorator.flowersPerChunk = 0;
        this.decorator.grassPerChunk = 0;
        this.decorator.gravelPatchesPerChunk = 0;
        this.decorator.mushroomsPerChunk = 0;
        this.decorator.reedsPerChunk = 0;
        this.decorator.waterlilyPerChunk = 0;
    }
}
