package expansebiomeresource.mod.world.biome;

import net.minecraft.block.BlockColored;
import net.minecraft.init.Blocks;
import net.minecraft.item.EnumDyeColor;
import net.minecraft.world.biome.Biome;

public class BiomeChibirusMountain extends Biome {

    public BiomeChibirusMountain() {

        super(new BiomeProperties("Chibirus Hills").setBaseHeight(1.67f).setHeightVariation(0.57f).setRainfall(0.8f).setTemperature(0.8f));

        topBlock = Blocks.COBBLESTONE.getDefaultState();
        fillerBlock = Blocks.STAINED_HARDENED_CLAY.getDefaultState().withProperty(BlockColored.COLOR, EnumDyeColor.MAGENTA);
    }
}
