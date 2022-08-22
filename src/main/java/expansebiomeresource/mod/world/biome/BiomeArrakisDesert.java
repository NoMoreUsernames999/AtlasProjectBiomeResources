package expansebiomeresource.mod.world.biome;

import net.minecraft.init.Blocks;
import net.minecraft.world.biome.Biome;

public class BiomeArrakisDesert extends Biome {

    public BiomeArrakisDesert() {

        super(new BiomeProperties("Arrakis Desert").setBaseHeight(0.001f).setHeightVariation(0.1f).setRainfall(0.0f).setRainDisabled().setTemperature(2.0f));

        this.topBlock = Blocks.SAND.getDefaultState();
        this.fillerBlock = Blocks.SAND.getDefaultState();
        this.decorator.generateFalls = false;
        this.decorator.deadBushPerChunk = 2;
        this.decorator.cactiPerChunk = 1;
        this.decorator.treesPerChunk = 0;
        this.decorator.extraTreeChance = 0.0f;
        this.decorator.flowersPerChunk = 0;
        this.decorator.grassPerChunk = 0;
        this.decorator.gravelPatchesPerChunk = 1;
        this.decorator.mushroomsPerChunk = 0;
        this.decorator.reedsPerChunk = 0;
        this.decorator.waterlilyPerChunk = 0;
    }
}
