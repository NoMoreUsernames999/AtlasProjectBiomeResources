package expansebiomeresource.mod.world.biome;

import biomesoplenty.api.block.BOPBlocks;
import biomesoplenty.api.config.IConfigObj;
import biomesoplenty.api.enums.BOPPlants;
import biomesoplenty.api.enums.BOPTrees;
import biomesoplenty.api.enums.BOPWoods;
import biomesoplenty.api.generation.GeneratorStage;
import biomesoplenty.common.biome.BOPBiome;
import biomesoplenty.common.biome.overworld.BOPOverworldBiome;
import biomesoplenty.common.block.BlockBOPDirt;
import biomesoplenty.common.block.BlockBOPGrass;
import biomesoplenty.common.world.generator.*;
import biomesoplenty.common.world.generator.tree.GeneratorBasicTree;
import biomesoplenty.common.world.generator.tree.GeneratorBigTree;
import biomesoplenty.common.world.generator.tree.GeneratorTwigletTree;
import net.minecraft.block.BlockPlanks;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.init.Blocks;
import net.minecraft.world.World;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.chunk.ChunkPrimer;

import java.util.Random;

public class BiomePlocuryBrush extends BOPOverworldBiome {

    public IBlockState usualTopBlock;
    public IBlockState alternateTopBlock;
    public BiomePlocuryBrush() {

        super("plocurybrush", (new BOPBiome.PropsBuilder("Plocury Brush")).withGuiColour(14193503).withTemperature(2.0F).withRainfall(0.5F).withRainDisabled().withWaterColor(12386198));
        this.terrainSettings.avgHeight(67.0).heightVariation(3.5, 15.5);
        this.topBlock = BOPBlocks.grass.getDefaultState().withProperty(BlockBOPGrass.VARIANT, BlockBOPGrass.BOPGrassType.SANDY);
        this.fillerBlock = BOPBlocks.dirt.getDefaultState().withProperty(BlockBOPDirt.VARIANT, BlockBOPDirt.BOPDirtType.SANDY);
        //this.topBlock = Blocks.GRASS.getDefaultState();
        //this.fillerBlock = Blocks.DIRT.getDefaultState();
        this.usualTopBlock = this.topBlock;
        this.alternateTopBlock = Blocks.SAND.getDefaultState();
        this.canGenerateRivers = false;
        this.canGenerateVillages = false;
        this.addGenerator("sand", GeneratorStage.SAND_PASS2, (new GeneratorWaterside.Builder()).amountPerChunk(4.0F).maxRadius(7).with(Blocks.SAND.getDefaultState()).create());
        this.addGenerator("quicksand", GeneratorStage.SAND, (new GeneratorLakes.Builder()).amountPerChunk(0.2F).liquid(BOPBlocks.sand).frozenLiquid((IBlockState)null).create());
        GeneratorWeighted treeGenerator = new GeneratorWeighted(6.0F);
        this.addGenerator("trees", GeneratorStage.TREE, treeGenerator);
        treeGenerator.add("brush", 1, (new GeneratorBasicTree.Builder()).log(BlockPlanks.EnumType.ACACIA).leaves(BlockPlanks.EnumType.ACACIA).minHeight(3).maxHeight(5).leafLayers(2).create());
        treeGenerator.add("brush_twiglet", 2, (new GeneratorTwigletTree.Builder()).minHeight(1).maxHeight(2).log(BOPWoods.EBONY).leaves(BOPTrees.EBONY).create());
        treeGenerator.add("jungle_twiglet", 1, (new GeneratorTwigletTree.Builder()).minHeight(2).maxHeight(2).log(BlockPlanks.EnumType.JUNGLE).leaves(BlockPlanks.EnumType.JUNGLE).trunkFruit(Blocks.COCOA.getDefaultState()).create());
        treeGenerator.add("brush_bush", 3, (new GeneratorFlora.Builder()).placeOn(this.topBlock).replace(new Material[]{Material.AIR}).withNonDecayingLeaf(BlockPlanks.EnumType.OAK).generationAttempts(8).create());
        treeGenerator.add("decaying_tree", 2, (new GeneratorBigTree.Builder()).amountPerChunk(1.0F).log(BOPWoods.EBONY).leaves(BOPTrees.EBONY).minHeight(4).maxHeight(10).foliageHeight(1).create());
        GeneratorWeighted grassGenerator = new GeneratorWeighted(9.0F);
        this.addGenerator("grass", GeneratorStage.GRASS, grassGenerator);
        grassGenerator.add("shortgrass", 1, (new GeneratorGrass.Builder()).with(BOPPlants.SHORTGRASS).create());
        grassGenerator.add("mediumgrass", 1, (new GeneratorGrass.Builder()).with(BOPPlants.MEDIUMGRASS).create());
        grassGenerator.add("tallgrass", 2, (new GeneratorGrass.Builder()).with(net.minecraft.block.BlockTallGrass.EnumType.GRASS).create());
        this.addGenerator("thorns", GeneratorStage.FLOWERS, (new GeneratorFlora.Builder()).amountPerChunk(0.25F).with(BOPPlants.THORN).create());

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
        double d0 = GRASS_COLOR_NOISE.getValue((double)x * 0.25, (double)z * 0.25);
        if (d0 > 0.0) {
            int i = x & 15;
            int j = z & 15;

            for(int k = 255; k >= 0; --k) {
                if (primer.getBlockState(j, k, i).getMaterial() != Material.AIR) {
                    if (k == 62 && primer.getBlockState(j, k, i).getBlock() != Blocks.WATER) {
                        primer.setBlockState(j, k, i, WATER);
                    }
                    break;
                }
            }
        }

        super.genTerrainBlocks(world, rand, primer, x, z, noise);
    }
}
