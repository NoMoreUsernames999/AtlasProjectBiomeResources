package expansebiomeresource.mod.world.biome;

import net.minecraft.block.BlockColored;
import net.minecraft.init.Blocks;
import net.minecraft.item.EnumDyeColor;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.BiomeMesa;

public class BiomeIoSpires extends BiomeMesa {

    public BiomeIoSpires() {

        super(true, false, new Biome.BiomeProperties("Io Spires").setBaseHeight(-0.75f).setHeightVariation(0.015f).setTemperature(0.5f).setRainfall(0.0f).setRainDisabled());

        topBlock = Blocks.NETHERRACK.getDefaultState();
        fillerBlock = Blocks.COAL_BLOCK.getDefaultState();
    }
}
