package expansebiomeresource.mod.world.biome;

import biomesoplenty.api.generation.GeneratorStage;
import biomesoplenty.common.biome.BOPBiome;
import biomesoplenty.common.biome.overworld.BOPOverworldBiome;
import biomesoplenty.common.util.biome.GeneratorUtils;
import biomesoplenty.common.world.generator.GeneratorSpike;
import net.minecraft.block.BlockStone;
import net.minecraft.init.Blocks;
import net.minecraft.world.biome.Biome;

import java.util.Random;

public class BiomeTorusIceSpikes extends BOPOverworldBiome {

    public BiomeTorusIceSpikes() {

        super("torusdicespikes", (new BOPBiome.PropsBuilder("Ice Rock Valley")).withGuiColour(14193503).withTemperature(0.2F).withRainfall(0.0F).withRainDisabled());
        this.terrainSettings.avgHeight(58.0).heightVariation(0.2, 1.0).octaves(1.0, 0.0, 0.0, 1.0, 0.0, 0.0);
        this.topBlock = Blocks.STONE.getDefaultState().withProperty(BlockStone.VARIANT, BlockStone.EnumType.ANDESITE);
        this.fillerBlock = Blocks.PACKED_ICE.getDefaultState();
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

        this.clearWeights();
        this.addGenerator("spires", GeneratorStage.TREE, (new GeneratorSpike.Builder()).minRadius(2).maxRadius(3).minHeight(6).maxHeight(9).amountPerChunk(4).with(Blocks.STONE.getDefaultState()).scatterYMethod(GeneratorUtils.ScatterYMethod.AT_SURFACE).create());
    }
}
