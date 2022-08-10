package expansebiomeresource.mod.world.biome;

import net.minecraft.block.BlockColored;
import net.minecraft.init.Blocks;
import net.minecraft.item.EnumDyeColor;
import net.minecraft.world.biome.Biome;

public class BiomeIoSulfur extends Biome {

    public BiomeIoSulfur() {

        super(new BiomeProperties("Sulfur flats").setBaseHeight(0.02f).setHeightVariation(0.17f).setRainfall(0.0f).setRainDisabled().setTemperature(1.5f));

        topBlock = Blocks.STAINED_HARDENED_CLAY.getDefaultState().withProperty(BlockColored.COLOR, EnumDyeColor.YELLOW);
        fillerBlock = Blocks.STAINED_HARDENED_CLAY.getDefaultState().withProperty(BlockColored.COLOR, EnumDyeColor.WHITE);
    }
}
