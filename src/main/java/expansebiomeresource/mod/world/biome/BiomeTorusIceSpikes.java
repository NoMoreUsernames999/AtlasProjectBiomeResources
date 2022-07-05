package expansebiomeresource.mod.world.biome;

import net.minecraft.block.BlockStone;
import net.minecraft.init.Blocks;
import net.minecraft.world.biome.Biome;

public class BiomeTorusIceSpikes extends Biome {

    public BiomeTorusIceSpikes() {

        super(new BiomeProperties("Ice Rock Valley").setBaseHeight(-0.055f).setHeightVariation(0.017f).setRainfall(0.0f).setTemperature(0.2f));

        topBlock = Blocks.STONE.getDefaultState().withProperty(BlockStone.VARIANT, BlockStone.EnumType.ANDESITE);
        fillerBlock = Blocks.PACKED_ICE.getDefaultState();

    }


}
