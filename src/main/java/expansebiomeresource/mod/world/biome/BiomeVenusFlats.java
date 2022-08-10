package expansebiomeresource.mod.world.biome;

import net.minecraft.block.BlockStone;
import net.minecraft.init.Blocks;
import net.minecraft.world.biome.Biome;

public class BiomeVenusFlats extends Biome {

    public BiomeVenusFlats() {

        super(new BiomeProperties("Venus Valley").setBaseHeight(-0.13f).setHeightVariation(0.05f).setRainfall(0.95f).setTemperature(2.0f));

        topBlock = Blocks.STONE.getDefaultState().withProperty(BlockStone.VARIANT, BlockStone.EnumType.GRANITE);
        fillerBlock = Blocks.SANDSTONE.getDefaultState();

    }


}