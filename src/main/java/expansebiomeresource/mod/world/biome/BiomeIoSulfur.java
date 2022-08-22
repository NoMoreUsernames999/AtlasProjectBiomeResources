package expansebiomeresource.mod.world.biome;

import biomesoplenty.api.generation.GeneratorStage;
import biomesoplenty.common.biome.BOPBiome;
import biomesoplenty.common.biome.overworld.BOPOverworldBiome;
import biomesoplenty.common.util.biome.GeneratorUtils;
import biomesoplenty.common.world.generator.GeneratorLakes;
import net.minecraft.block.BlockColored;
import net.minecraft.init.Blocks;
import net.minecraft.item.EnumDyeColor;
import net.minecraft.world.biome.Biome;

public class BiomeIoSulfur extends BOPOverworldBiome {

    public BiomeIoSulfur() {

        super("iosulfur", (new BOPBiome.PropsBuilder("Sulfur Flats")).withGuiColour(14193503).withTemperature(1.5F).withRainfall(0.0F).withRainDisabled().withWaterColor(214198139));
        this.terrainSettings.avgHeight(64.0).heightVariation(1.5, 1.5);
        this.topBlock = Blocks.STAINED_HARDENED_CLAY.getDefaultState().withProperty(BlockColored.COLOR, EnumDyeColor.YELLOW);
        this.fillerBlock = Blocks.STAINED_HARDENED_CLAY.getDefaultState().withProperty(BlockColored.COLOR, EnumDyeColor.WHITE);
        this.canGenerateRivers = false;
        this.canGenerateVillages = false;
        this.canSpawnInBiome = false;
        this.hasBiomeEssence = false;
        this.spawnableCreatureList.clear();
        this.clearWeights();

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

        this.addGenerator("lakes", GeneratorStage.SAND, (new GeneratorLakes.Builder()).amountPerChunk(0.4F).liquid(Blocks.LAVA.getDefaultState()).lineWith(Blocks.STAINED_HARDENED_CLAY.getDefaultState().withProperty(BlockColored.COLOR, EnumDyeColor.RED)).grassBorderWith(Blocks.SAND.getDefaultState()).grassReplace(Blocks.STAINED_HARDENED_CLAY.getDefaultState().withProperty(BlockColored.COLOR, EnumDyeColor.SILVER)).scatterYMethod(GeneratorUtils.ScatterYMethod.AT_SURFACE).create());
    }
}
