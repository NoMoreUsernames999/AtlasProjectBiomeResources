package expansebiomeresource.mod.world.biome;

import net.minecraft.block.BlockColored;
import net.minecraft.init.Blocks;
import net.minecraft.item.EnumDyeColor;
import net.minecraft.world.biome.BiomeDesert;

public class BiomeTorusDesert extends BiomeDesert {

    public BiomeTorusDesert() {

        super(new BiomeProperties("Torus Desert").setBaseHeight(0.001f).setHeightVariation(0.04f).setRainfall(0.0f).setRainDisabled().setTemperature(1.0f));

        fillerBlock = Blocks.STAINED_HARDENED_CLAY.getDefaultState().withProperty(BlockColored.COLOR, EnumDyeColor.BROWN);
    }
}
