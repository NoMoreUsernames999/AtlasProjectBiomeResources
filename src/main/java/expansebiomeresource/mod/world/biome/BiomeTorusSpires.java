package expansebiomeresource.mod.world.biome;

import net.minecraft.block.BlockColored;
import net.minecraft.init.Blocks;
import net.minecraft.item.EnumDyeColor;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.BiomeMesa;

public class BiomeTorusSpires extends BiomeMesa {

    public BiomeTorusSpires() {

        super(true, false, new Biome.BiomeProperties("Eroded Spires").setBaseHeight(0.05f).setHeightVariation(0.05f).setTemperature(0.8f).setRainfall(0.0f).setRainDisabled());

        topBlock = Blocks.STAINED_HARDENED_CLAY.getDefaultState().withProperty(BlockColored.COLOR, EnumDyeColor.BROWN);
    }
}
