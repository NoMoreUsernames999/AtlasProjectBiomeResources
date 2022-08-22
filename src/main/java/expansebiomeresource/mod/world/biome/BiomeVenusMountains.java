package expansebiomeresource.mod.world.biome;

import net.minecraft.block.BlockStone;
import net.minecraft.init.Blocks;
import net.minecraft.world.biome.Biome;

public class BiomeVenusMountains extends Biome {

    public BiomeVenusMountains() {

        super(new BiomeProperties("Gula Mons").setBaseHeight(5.8f).setHeightVariation(0.377f).setRainfall(0.95f).setTemperature(2.0f));

        topBlock = Blocks.STONE.getDefaultState().withProperty(BlockStone.VARIANT, BlockStone.EnumType.ANDESITE);
        fillerBlock = Blocks.SANDSTONE.getDefaultState();

    }


}