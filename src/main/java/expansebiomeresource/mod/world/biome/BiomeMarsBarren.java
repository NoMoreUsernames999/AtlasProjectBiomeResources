package expansebiomeresource.mod.world.biome;

import net.minecraft.block.BlockColored;
import net.minecraft.init.Blocks;
import net.minecraft.item.EnumDyeColor;
import net.minecraft.world.biome.Biome;

public class BiomeMarsBarren extends Biome {

    public BiomeMarsBarren() {

        super(new BiomeProperties("Red Barrens").setBaseHeight(0.135f).setHeightVariation(0.2f).setRainfall(0.0f).setRainDisabled().setTemperature(1.0f).setWaterColor(14837760));

        topBlock = Blocks.HARDENED_CLAY.getDefaultState();
        fillerBlock = Blocks.STAINED_HARDENED_CLAY.getDefaultState().withProperty(BlockColored.COLOR, EnumDyeColor.BROWN);

    }


}