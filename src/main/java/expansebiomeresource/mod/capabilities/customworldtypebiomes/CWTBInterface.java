package expansebiomeresource.mod.capabilities.customworldtypebiomes;

import net.minecraft.util.ResourceLocation;
import net.minecraft.world.biome.Biome;

public interface CWTBInterface {

    void setOceanBiome(ResourceLocation source);
    Biome getOceanBiome();

    void setRiverBiome(ResourceLocation source);
    Biome getRiverBiome();

    void setMushroomBiome(ResourceLocation source);
    Biome getMushroomBiome();

}
