package expansebiomeresource.mod.world.biome;

import biomesoplenty.api.block.BOPBlocks;
import biomesoplenty.api.block.BlockQueries;
import biomesoplenty.api.config.IConfigObj;
import biomesoplenty.api.enums.BOPFlowers;
import biomesoplenty.api.enums.BOPPlants;
import biomesoplenty.api.generation.GeneratorStage;
import biomesoplenty.common.biome.BOPBiome;
import biomesoplenty.common.biome.overworld.BOPOverworldBiome;
import biomesoplenty.common.block.BlockBOPDirt;
import biomesoplenty.common.util.biome.GeneratorUtils;
import biomesoplenty.common.world.generator.*;
import biomesoplenty.common.world.generator.tree.GeneratorTwigletTree;
import net.minecraft.block.BlockPlanks;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.init.Blocks;
import net.minecraft.world.World;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.chunk.ChunkPrimer;

import java.util.Random;

public class BiomePlocuryXeric extends BOPOverworldBiome {

    public IBlockState usualTopBlock;
    public IBlockState alternateTopBlock;

    public BiomePlocuryXeric() {

        super("plocuryxeric", (new BOPBiome.PropsBuilder("Plocury Xeric").withRainfall(0.5f).withTemperature(2.0f).withWaterColor(142184230)));
        this.terrainSettings.avgHeight(64.0).heightVariation(1.0, 5.0);
        this.topBlock = Blocks.SAND.getDefaultState();
        this.fillerBlock = Blocks.SAND.getDefaultState();
        this.usualTopBlock = this.topBlock;
        this.alternateTopBlock = BOPBlocks.dirt.getDefaultState().withProperty(BlockBOPDirt.VARIANT, BlockBOPDirt.BOPDirtType.SANDY).withProperty(BlockBOPDirt.COARSE, true);
        this.canSpawnInBiome = true;
        this.canGenerateVillages = false;
        this.canGenerateRivers = true;
        this.hasBiomeEssence = false;
        this.spawnableCreatureList.clear();

        GeneratorWeighted treeGenerator = new GeneratorWeighted(1.0F);
        this.addGenerator("trees", GeneratorStage.TREE, treeGenerator);
        treeGenerator.add("brush_twiglet", 2, ((GeneratorTwigletTree.Builder)((GeneratorTwigletTree.Builder)((GeneratorTwigletTree.Builder)((GeneratorTwigletTree.Builder)((GeneratorTwigletTree.Builder)(new GeneratorTwigletTree.Builder()).placeOn(BlockQueries.litDry)).minHeight(1)).maxHeight(2)).log(BlockPlanks.EnumType.ACACIA)).leaves(BlockPlanks.EnumType.ACACIA)).create());
        treeGenerator.add("brush_bush", 3, ((GeneratorFlora.Builder)((GeneratorFlora.Builder)((GeneratorFlora.Builder)(new GeneratorFlora.Builder()).placeOn(BlockQueries.litDry)).replace(new Material[]{Material.AIR})).withNonDecayingLeaf(BlockPlanks.EnumType.ACACIA)).create());
        this.addGenerator("dunegrass", GeneratorStage.GRASS, ((GeneratorGrass.Builder)((GeneratorGrass.Builder)((GeneratorGrass.Builder)((GeneratorGrass.Builder)(new GeneratorGrass.Builder()).amountPerChunk(10.0F)).with(BOPPlants.DUNEGRASS)).placeOn(this.topBlock)).generationAttempts(8)).create());
        this.addGenerator("desertgrass", GeneratorStage.GRASS, ((GeneratorGrass.Builder)((GeneratorGrass.Builder)((GeneratorGrass.Builder)(new GeneratorGrass.Builder()).amountPerChunk(2.0F)).with(BOPPlants.DESERTGRASS)).generationAttempts(8)).create());
        this.addGenerator("desert_sprouts", GeneratorStage.FLOWERS, ((GeneratorFlora.Builder)((GeneratorFlora.Builder)((GeneratorFlora.Builder)(new GeneratorFlora.Builder()).amountPerChunk(4.0F)).with(BOPPlants.DESERTSPROUTS)).generationAttempts(8)).create());
        this.addGenerator("bromeliad", GeneratorStage.FLOWERS, ((GeneratorFlora.Builder)((GeneratorFlora.Builder)((GeneratorFlora.Builder)(new GeneratorFlora.Builder()).amountPerChunk(0.2F)).with(BOPFlowers.BROMELIAD)).generationAttempts(8)).create());
        this.addGenerator("dead_bushes", GeneratorStage.FLOWERS, ((GeneratorFlora.Builder)((GeneratorFlora.Builder)(new GeneratorFlora.Builder()).amountPerChunk(1.0F)).with(Blocks.DEADBUSH.getDefaultState())).create());
        GeneratorWeighted grassGenerator = new GeneratorWeighted(1.0F);
        this.addGenerator("grass", GeneratorStage.GRASS, grassGenerator);
        grassGenerator.add("shortgrass", 7, ((GeneratorGrass.Builder)(new GeneratorGrass.Builder()).with(BOPPlants.SHORTGRASS)).create());
        grassGenerator.add("mediumgrass", 3, ((GeneratorGrass.Builder)(new GeneratorGrass.Builder()).with(BOPPlants.MEDIUMGRASS)).create());
        grassGenerator.add("tallgrass", 1, ((GeneratorGrass.Builder)(new GeneratorGrass.Builder()).with(net.minecraft.block.BlockTallGrass.EnumType.GRASS)).create());

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

    public void configure(IConfigObj conf) {
        super.configure(conf);
        this.usualTopBlock = this.topBlock;
        this.alternateTopBlock = conf.getBlockState("alternateTopBlock", this.alternateTopBlock);
    }

    public void genTerrainBlocks(World world, Random rand, ChunkPrimer primer, int x, int z, double noise) {
        this.topBlock = noise + rand.nextDouble() * 1.0 > 1.9 ? this.alternateTopBlock : this.usualTopBlock;
        super.genTerrainBlocks(world, rand, primer, x, z, noise);
    }
}
