package expansebiomeresource.mod.world.biome;

import net.minecraft.block.BlockColored;
import net.minecraft.init.Blocks;
import net.minecraft.item.EnumDyeColor;
import net.minecraft.world.biome.Biome;

public class BiomeIoWastes extends Biome {

    public BiomeIoWastes() {

        super(new BiomeProperties("Volcanic Flats").setBaseHeight(0.01f).setHeightVariation(0.1f).setRainfall(0.0f).setRainDisabled().setTemperature(0.5f));

        topBlock = Blocks.STAINED_HARDENED_CLAY.getDefaultState().withProperty(BlockColored.COLOR, EnumDyeColor.WHITE);
        fillerBlock = Blocks.STAINED_HARDENED_CLAY.getDefaultState().withProperty(BlockColored.COLOR, EnumDyeColor.BROWN);
    }
}
