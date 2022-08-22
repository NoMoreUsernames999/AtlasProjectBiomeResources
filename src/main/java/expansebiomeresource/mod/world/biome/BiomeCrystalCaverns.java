package expansebiomeresource.mod.world.biome;

import net.minecraft.init.Blocks;
import net.minecraft.world.biome.Biome;

public class BiomeCrystalCaverns extends Biome {

    public BiomeCrystalCaverns() {

        super(new BiomeProperties("Quartz Caves").setBaseHeight(6.5f).setHeightVariation(0.4f).setRainfall(0.0f).setRainDisabled().setTemperature(1.0f));

        topBlock = Blocks.STONE.getDefaultState();
        fillerBlock = Blocks.STONE.getDefaultState();

    }


}