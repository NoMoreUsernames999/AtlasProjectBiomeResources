package expansebiomeresource.mod.world.biome;

import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.BiomeMesa;

public class BiomeTorusMesa extends BiomeMesa {

    public BiomeTorusMesa() {

        super(false, false, new Biome.BiomeProperties("Torus Hills").setBaseHeight(1.5f).setHeightVariation(0.4f).setRainfall(0.0f).setRainDisabled().setTemperature(1.0f));

    }

}
