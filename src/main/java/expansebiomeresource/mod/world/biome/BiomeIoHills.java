package expansebiomeresource.mod.world.biome;

import net.minecraft.block.BlockColored;
import net.minecraft.init.Blocks;
import net.minecraft.item.EnumDyeColor;
import net.minecraft.world.biome.Biome;

public class BiomeIoHills extends Biome {

    public BiomeIoHills() {

        super(new BiomeProperties("Volcanic Plateau").setBaseHeight(1.67f).setHeightVariation(0.001f).setRainfall(0.0f).setRainDisabled().setTemperature(0.2f));

        topBlock = Blocks.STAINED_HARDENED_CLAY.getDefaultState().withProperty(BlockColored.COLOR, EnumDyeColor.BROWN);
        fillerBlock = Blocks.STAINED_HARDENED_CLAY.getDefaultState().withProperty(BlockColored.COLOR, EnumDyeColor.WHITE);
    }
}
