package expansebiomeresource.mod.world.biome;

import biomesoplenty.api.generation.GeneratorStage;
import biomesoplenty.common.biome.BOPBiome;
import biomesoplenty.common.biome.overworld.BOPOverworldBiome;
import biomesoplenty.common.util.biome.GeneratorUtils;
import biomesoplenty.common.world.generator.GeneratorLakes;
import biomesoplenty.common.world.generator.GeneratorSpike;
import net.minecraft.init.Blocks;
import net.minecraft.world.biome.Biome;

public class BiomePlocuryXeric extends BOPOverworldBiome {

    public BiomePlocuryXeric() {

        super("plocuryxeric", (new BOPBiome.PropsBuilder("Plocury Xeric").withRainfall(0.5f).withTemperature(2.0f).withWaterColor(0)));
        this.terrainSettings.avgHeight(62.0).heightVariation(5.0, 1.0);
        this.canSpawnInBiome = true;
        this.canGenerateVillages = false;
        this.canGenerateRivers = true;
        this.hasBiomeEssence = false;
        this.topBlock = Blocks.SAND.getDefaultState();
        this.fillerBlock = Blocks.SANDSTONE.getDefaultState();
        this.spawnableCreatureList.clear();

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

        this.addGenerator("spires", GeneratorStage.TREE, (new GeneratorSpike.Builder()).minRadius(2).maxRadius(5).minHeight(5).maxHeight(8).amountPerChunk(2).with(Blocks.STONE.getDefaultState()).scatterYMethod(GeneratorUtils.ScatterYMethod.AT_SURFACE).create());
    }
}
