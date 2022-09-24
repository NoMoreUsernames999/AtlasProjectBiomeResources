package expansebiomeresource.mod.capabilities.customworldtypebiomes;

import net.minecraft.init.Biomes;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.biome.Biome;
import net.minecraftforge.fml.common.registry.ForgeRegistries;

public class CWTBCapability implements CWTBInterface {

    private Biome ocean;
    private Biome river;
    private Biome mushroom;

    @Override
    public void setOceanBiome(ResourceLocation source) {
        Biome test = ForgeRegistries.BIOMES.getValue(source);
        if(test!=null) this.ocean = test;
        else this.ocean = Biomes.PLAINS;
    }

    @Override
    public Biome getOceanBiome() {
        return this.ocean;
    }

    @Override
    public void setRiverBiome(ResourceLocation source) {
        Biome test = ForgeRegistries.BIOMES.getValue(source);
        if(test!=null) this.river = test;
        else this.river = Biomes.PLAINS;
    }

    @Override
    public Biome getRiverBiome() {
        return this.river;
    }

    @Override
    public void setMushroomBiome(ResourceLocation source) {
        Biome test = ForgeRegistries.BIOMES.getValue(source);
        if(test!=null) this.mushroom = test;
        else this.mushroom = Biomes.PLAINS;
    }

    @Override
    public Biome getMushroomBiome() {
        return this.mushroom;
    }
}
