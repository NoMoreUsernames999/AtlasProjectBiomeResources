package expansebiomeresource.mod.world.biome;

import net.minecraft.block.BlockSandStone;
import net.minecraft.block.BlockStone;
import net.minecraft.init.Blocks;
import net.minecraft.world.biome.Biome;

public class BiomeVenusCraters extends Biome {

    public BiomeVenusCraters() {

        super(new BiomeProperties("Venus Basin").setBaseHeight(-0.9f).setHeightVariation(0.1f).setRainfall(0.95f).setTemperature(2.0f));

        topBlock = Blocks.STONE.getDefaultState().withProperty(BlockStone.VARIANT, BlockStone.EnumType.ANDESITE);
        fillerBlock = Blocks.SANDSTONE.getDefaultState();

    }


}