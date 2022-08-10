package expansebiomeresource.mod.world.biome;

import net.minecraft.block.BlockStone;
import net.minecraft.init.Blocks;
import net.minecraft.world.biome.Biome;
import static net.minecraft.block.BlockStone.VARIANT;

public class BiomeChibirusRidge extends Biome {

    public BiomeChibirusRidge() {

        super(new BiomeProperties("Mountain Range").setBaseHeight(8.0f).setHeightVariation(0.0f).setRainfall(0.8f).setTemperature(0.7f));

        topBlock = Blocks.GRAVEL.getDefaultState();
        fillerBlock = Blocks.STONE.getDefaultState().withProperty(VARIANT, BlockStone.EnumType.ANDESITE);
    }
}
