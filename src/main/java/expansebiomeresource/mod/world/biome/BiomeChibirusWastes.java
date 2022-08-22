package expansebiomeresource.mod.world.biome;

import net.minecraft.init.Blocks;
import net.minecraft.world.biome.Biome;

public class BiomeChibirusWastes extends Biome {

    public BiomeChibirusWastes() {

        super(new BiomeProperties("Chibirus Wastes").setBaseHeight(-0.315f).setHeightVariation(0.13f).setRainfall(0.8f).setTemperature(0.8f));

        topBlock = Blocks.GRAVEL.getDefaultState();
        fillerBlock = Blocks.COBBLESTONE.getDefaultState();
    }
}
