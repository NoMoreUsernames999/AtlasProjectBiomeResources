package expansebiomeresource.mod.world.biome;

import net.minecraft.block.BlockSand;
import net.minecraft.init.Blocks;
import net.minecraft.world.biome.Biome;

public class BiomeEnceladusPlateau extends Biome {

    public BiomeEnceladusPlateau() {

        super(new BiomeProperties("Enceladus Shelf").setBaseHeight(3.0f).setHeightVariation(0.03f).setRainfall(0.0f).setRainDisabled().setTemperature(0.7f));

        topBlock = Blocks.PACKED_ICE.getDefaultState();
        fillerBlock = Blocks.PACKED_ICE.getDefaultState();
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
