package expansebiomeresource.mod.world.biome;

import net.minecraft.init.Blocks;
import net.minecraft.world.biome.Biome;

public class BiomeFungalCaverns extends Biome {

    public BiomeFungalCaverns() {

        super(new BiomeProperties("Fungal Caverns").setBaseHeight(6.5f).setHeightVariation(0.2f).setRainfall(0.0f).setRainDisabled().setTemperature(1.0f));

        topBlock = Blocks.STONE.getDefaultState();
        fillerBlock = Blocks.STONE.getDefaultState();

    }


}
