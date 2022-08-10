package expansebiomeresource.mod.world.biome;

import biomesoplenty.api.generation.GeneratorStage;
import biomesoplenty.common.biome.BOPBiome;
import biomesoplenty.common.biome.overworld.BOPOverworldBiome;
import biomesoplenty.common.util.biome.GeneratorUtils;
import biomesoplenty.common.world.generator.GeneratorLakes;
import net.minecraft.block.BlockColored;
import net.minecraft.init.Blocks;
import net.minecraft.item.EnumDyeColor;

public class BiomePlocuryDesert extends BOPOverworldBiome {

    public BiomePlocuryDesert() {

        super("plocurydesert", (new BOPBiome.PropsBuilder("Plocury Desert")).withGuiColour(7712283).withTemperature(2.0F).withRainfall(0.5F).withWaterColor(0));
        this.terrainSettings.avgHeight(62.0).heightVariation(1.0, 3.0);
        this.canSpawnInBiome = false;
        this.canGenerateVillages = false;
        this.canGenerateRivers = false;
        this.hasBiomeEssence = false;
        this.topBlock = Blocks.SAND.getDefaultState();
        this.fillerBlock = Blocks.SANDSTONE.getDefaultState();
        this.spawnableCreatureList.clear();
        this.clearWeights();

        this.decorator.generateFalls = false;

        this.addGenerator("lakes", GeneratorStage.SAND, (new GeneratorLakes.Builder()).amountPerChunk(6.0F).liquid(Blocks.LAVA.getDefaultState()).lineWith(Blocks.STAINED_HARDENED_CLAY.getDefaultState().withProperty(BlockColored.COLOR, EnumDyeColor.YELLOW)).grassBorderWith(Blocks.STAINED_HARDENED_CLAY.getDefaultState().withProperty(BlockColored.COLOR, EnumDyeColor.SILVER)).scatterYMethod(GeneratorUtils.ScatterYMethod.ABOVE_SURFACE).create());
    }
}
