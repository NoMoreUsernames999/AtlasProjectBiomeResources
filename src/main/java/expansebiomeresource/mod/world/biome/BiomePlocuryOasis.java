package expansebiomeresource.mod.world.biome;

import biomesoplenty.api.block.BlockQueries;
import biomesoplenty.api.enums.BOPFlowers;
import biomesoplenty.api.enums.BOPPlants;
import biomesoplenty.api.enums.BOPTrees;
import biomesoplenty.api.enums.BOPWoods;
import biomesoplenty.api.generation.GeneratorStage;
import biomesoplenty.common.biome.BOPBiome;
import biomesoplenty.common.biome.overworld.BOPOverworldBiome;
import biomesoplenty.common.block.BlockBOPLeaves;
import biomesoplenty.common.world.generator.GeneratorColumns;
import biomesoplenty.common.world.generator.GeneratorFlora;
import biomesoplenty.common.world.generator.GeneratorGrass;
import biomesoplenty.common.world.generator.GeneratorWeighted;
import biomesoplenty.common.world.generator.tree.GeneratorBasicTree;
import biomesoplenty.common.world.generator.tree.GeneratorBulbTree;
import biomesoplenty.common.world.generator.tree.GeneratorPalmTree;
import biomesoplenty.common.world.generator.tree.GeneratorTwigletTree;
import net.minecraft.block.BlockDoublePlant;
import net.minecraft.block.BlockOldLeaf;
import net.minecraft.block.BlockPlanks;
import net.minecraft.block.BlockTallGrass;
import net.minecraft.init.Blocks;

import static net.minecraft.block.BlockDoublePlant.EnumPlantType.SUNFLOWER;

public class BiomePlocuryOasis extends BOPOverworldBiome {

    public BiomePlocuryOasis() {

        super("plocuryoasis", (new BOPBiome.PropsBuilder("Oasis")).withGuiColour(7712283).withTemperature(2.0F).withRainfall(0.5F).withWaterColor(0));
        this.terrainSettings.avgHeight(62.0).heightVariation(2.5, 2.0);
        this.canSpawnInBiome = false;
        this.canGenerateVillages = false;
        this.canGenerateRivers = true;
        this.hasBiomeEssence = false;
        this.topBlock = Blocks.GRASS.getDefaultState();
        this.fillerBlock = Blocks.SAND.getDefaultState();
        this.spawnableCreatureList.clear();
        this.clearWeights();
        GeneratorWeighted treeGenerator = new GeneratorWeighted(6.0F);
        this.decorator.sandPatchesPerChunk = 1;
        this.addGenerator("trees", GeneratorStage.TREE, treeGenerator);
        treeGenerator.add("palm", 3, (new GeneratorPalmTree.Builder()).placeOn(BlockQueries.litFertileOrDry).log(BOPWoods.PALM).leaves(BlockBOPLeaves.paging.getVariantState(BOPTrees.PALM).withProperty(BlockOldLeaf.DECAYABLE, false)).create());
        treeGenerator.add("tall_eucalyptus", 2, (new GeneratorBulbTree.Builder()).placeOn(BlockQueries.litFertileOrDry).minHeight(15).maxHeight(20).log(BOPWoods.EUCALYPTUS).leaves(BOPTrees.EUCALYPTUS).create());
        treeGenerator.add("jungle_twiglet", 2, (new GeneratorTwigletTree.Builder()).placeOn(BlockQueries.litFertileOrDry).minHeight(2).maxHeight(2).log(BlockPlanks.EnumType.JUNGLE).leaves(BlockPlanks.EnumType.JUNGLE).trunkFruit(Blocks.COCOA.getDefaultState()).create());
        treeGenerator.add("jungle", 3, (new GeneratorBasicTree.Builder()).placeOn(BlockQueries.litFertileOrDry).minHeight(8).maxHeight(12).log(BlockPlanks.EnumType.JUNGLE).leaves(BlockPlanks.EnumType.JUNGLE).trunkFruit(Blocks.COCOA.getDefaultState()).create());
        GeneratorWeighted grassGenerator = new GeneratorWeighted(12.0F);
        this.addGenerator("grass", GeneratorStage.GRASS, grassGenerator);
        grassGenerator.add("tallgrass", 1, (new GeneratorGrass.Builder()).with(BlockTallGrass.EnumType.GRASS).create());
        //this.addGenerator("grass", GeneratorStage.GRASS, (new GeneratorGrass.Builder()).amountPerChunk(12.0F).with(net.minecraft.block.BlockTallGrass.EnumType.GRASS).placeOn(BlockQueries.litDry).generationAttempts(8).create());
        this.addGenerator("desert_sprouts", GeneratorStage.FLOWERS, (new GeneratorFlora.Builder()).amountPerChunk(5.0F).with(BOPPlants.DESERTSPROUTS).generationAttempts(8).create());
        this.addGenerator("desertgrass", GeneratorStage.GRASS, (new GeneratorGrass.Builder()).amountPerChunk(1.0F).with(BOPPlants.DESERTGRASS).generationAttempts(8).create());
        this.addGenerator("bromeliad", GeneratorStage.FLOWERS, (new GeneratorFlora.Builder()).amountPerChunk(0.2F).with(BOPFlowers.BROMELIAD).generationAttempts(8).create());
        this.addGenerator("tiny_cacti", GeneratorStage.FLOWERS, (new GeneratorFlora.Builder()).amountPerChunk(0.2F).with(BOPPlants.TINYCACTUS).generationAttempts(8).create());
        this.addGenerator("sugar_cane", GeneratorStage.FLOWERS, (new GeneratorColumns.Builder()).amountPerChunk(2.0F).generationAttempts(24).placeOn(BlockQueries.litDryWaterside).with(Blocks.REEDS.getDefaultState()).minHeight(1).maxHeight(3).create());

        this.decorator.generateFalls = false;
        this.decorator.deadBushPerChunk = 0;
        this.decorator.cactiPerChunk = 0;
        this.decorator.treesPerChunk = 2;
        this.decorator.extraTreeChance = 0.3f;
        this.decorator.flowersPerChunk = 0;
        this.decorator.grassPerChunk = 0;
        this.decorator.gravelPatchesPerChunk = 0;
        this.decorator.mushroomsPerChunk = 0;
        this.decorator.reedsPerChunk = 0;
        this.decorator.waterlilyPerChunk = 0;
    }
}