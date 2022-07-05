package expansebiomeresource.mod.world.biome;

import net.minecraft.block.BlockStone;
import net.minecraft.init.Blocks;
import net.minecraft.world.biome.Biome;

public class BiomeTorusCrag extends Biome {

    public BiomeTorusCrag() {

        super(new BiomeProperties("Crag").setBaseHeight(3.9f).setHeightVariation(0.3f).setRainfall(0.4f).setTemperature(0.4f));

        topBlock = Blocks.STONE.getDefaultState().withProperty(BlockStone.VARIANT, BlockStone.EnumType.ANDESITE);
        fillerBlock = Blocks.STONE.getDefaultState();

    }


}
