package expansebiomeresource.mod.world.biome;

import net.minecraft.block.BlockStone;
import net.minecraft.init.Blocks;
import net.minecraft.world.biome.Biome;

public class BiomeVenusHills extends Biome {

    public BiomeVenusHills() {

        super(new BiomeProperties("Venus Mountains").setBaseHeight(1.0f).setHeightVariation(0.35f).setRainfall(0.95f).setTemperature(2.0f));

        topBlock = Blocks.STONE.getDefaultState().withProperty(BlockStone.VARIANT, BlockStone.EnumType.GRANITE);
        fillerBlock = Blocks.SANDSTONE.getDefaultState();

    }


}