package expansebiomeresource.mod.world.biome;

import net.minecraft.init.Blocks;
import net.minecraft.world.biome.Biome;

public class BiomePlocuryBrush extends Biome {

    public BiomePlocuryBrush() {

        super(new Biome.BiomeProperties("Plocury Brush").setBaseHeight(0.5f).setHeightVariation(0.1f).setRainfall(0.5f).setTemperature(2.0f).setWaterColor(0));

        topBlock = Blocks.SAND.getDefaultState();
        fillerBlock = Blocks.SANDSTONE.getDefaultState();
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
