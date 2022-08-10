package expansebiomeresource.mod.world.biome;

import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.init.Blocks;
import net.minecraft.world.World;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.chunk.ChunkPrimer;
import net.minecraft.world.gen.NoiseGeneratorPerlin;

import java.util.Random;

public class BiomeTorusDIceH extends Biome {

    private long worldSeed;
    private NoiseGeneratorPerlin pillarNoise;
    private NoiseGeneratorPerlin pillarRoofNoise;

    public BiomeTorusDIceH() {

        super(new BiomeProperties("Rocky Ice Wastes").setBaseHeight(-0.25f).setHeightVariation(0.35f).setRainfall(0.0f).setRainDisabled().setTemperature(0.2f));

        topBlock = Blocks.ICE.getDefaultState();
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

    public void genTerrainBlocks(World worldIn, Random rand, ChunkPrimer chunkPrimerIn, int x, int z, double noiseVal) {
        if (this.pillarNoise == null || this.pillarRoofNoise == null || this.worldSeed != worldIn.getSeed()) {
            Random random = new Random(this.worldSeed);
            this.pillarNoise = new NoiseGeneratorPerlin(random, 7);
            this.pillarRoofNoise = new NoiseGeneratorPerlin(random, 1);
        }

        this.worldSeed = worldIn.getSeed();
        double d4 = 0.0;
        int i = (x & -16) + (z & 15);
        int j = (z & -16) + (x & 15);
        double d0 = Math.min(Math.abs(noiseVal), this.pillarNoise.getValue((double)i * 0.25, (double)j * 0.25));
        if (d0 > 0.0) {
            double d2 = Math.abs(this.pillarRoofNoise.getValue((double)i * 0.001953125, (double)j * 0.001953125));
            d4 = d0 * d0 * 2.5;
            double d3 = Math.ceil(d2 * 50.0) + 14.0;
            if (d4 > d3) {
                d4 = d3;
            }

            d4 += 64.0;
        }

        int k1 = x & 15;
        int l1 = z & 15;
        int i2 = worldIn.getSeaLevel();
        IBlockState iblockstate = this.fillerBlock;
        int k = (int)(noiseVal / 3.0 + 3.0 + rand.nextDouble() * 0.25);
        int l = -1;

        for(int j1 = 255; j1 >= 0; --j1) {
            if (chunkPrimerIn.getBlockState(l1, j1, k1).getMaterial() == Material.AIR && j1 < (int)d4) {
                chunkPrimerIn.setBlockState(l1, j1, k1, STONE);
            }

            if (j1 <= rand.nextInt(5)) {
                chunkPrimerIn.setBlockState(l1, j1, k1, BEDROCK);
            } else {
                IBlockState iblockstate1 = chunkPrimerIn.getBlockState(l1, j1, k1);
                if (iblockstate1.getMaterial() == Material.AIR) {
                    l = -1;
                } else if (iblockstate1.getBlock() == Blocks.STONE) {
                    if (l == -1) {
                        if (k <= 0) {
                            iblockstate = AIR;
                        } else if (j1 >= i2 - 4 && j1 <= i2 + 1) {
                            iblockstate = this.fillerBlock;
                        }

                        if (j1 < i2 && (iblockstate == null || iblockstate.getMaterial() == Material.AIR)) {
                            iblockstate = WATER;
                        }

                        l = k + Math.max(0, j1 - i2);
                        if (j1 >= i2 - 1) {
                            chunkPrimerIn.setBlockState(l1, j1, k1, this.topBlock);
                        } else {
                            chunkPrimerIn.setBlockState(l1, j1, k1, this.fillerBlock);
                        }
                    } else if (l > 0) {
                        --l;
                        chunkPrimerIn.setBlockState(l1, j1, k1, STONE);
                    }
                }
            }
        }

    }

}