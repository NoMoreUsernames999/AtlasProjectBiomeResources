package expansebiomeresource.mod.world.biome;

import net.minecraft.block.BlockStone;
import net.minecraft.init.Blocks;
import net.minecraft.world.biome.Biome;

public class BiomeVenusRidge extends Biome {

    public BiomeVenusRidge() {

        super(new BiomeProperties("Mountain Range").setBaseHeight(1.35f).setHeightVariation(0.85f).setRainfall(0.95f).setTemperature(2.0f));

        topBlock = Blocks.STONE.getDefaultState().withProperty(BlockStone.VARIANT, BlockStone.EnumType.GRANITE);
        fillerBlock = Blocks.SANDSTONE.getDefaultState();

    }


}