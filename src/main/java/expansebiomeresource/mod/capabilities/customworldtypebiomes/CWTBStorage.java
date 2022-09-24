package expansebiomeresource.mod.capabilities.customworldtypebiomes;

import expansebiomeresource.mod.ExpanseBiomeResource;
import net.minecraft.init.Biomes;
import net.minecraft.nbt.NBTBase;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.common.capabilities.Capability;

import javax.annotation.Nullable;

public class CWTBStorage implements Capability.IStorage<CWTBInterface> {

    @Nullable
    @Override
    public NBTBase writeNBT(Capability<CWTBInterface> capability, CWTBInterface instance, EnumFacing side) {
        NBTTagCompound compound = new NBTTagCompound();
        compound.setString("ocean",instance.getOceanBiome().getRegistryName().toString());
        compound.setString("river",instance.getRiverBiome().getRegistryName().toString());
        compound.setString("mushroom",instance.getMushroomBiome().getRegistryName().toString());
        return compound;

    }

    @Override
    public void readNBT(Capability<CWTBInterface> capability, CWTBInterface instance, EnumFacing side, NBTBase nbt) {
        if(nbt instanceof NBTTagCompound) {
            NBTTagCompound compound = (NBTTagCompound)nbt;
            if(compound.hasKey("ocean")) instance.setOceanBiome(new ResourceLocation(compound.getString("ocean")));
            else instance.setOceanBiome(Biomes.PLAINS.getRegistryName());
            if(compound.hasKey("river")) instance.setRiverBiome(new ResourceLocation(compound.getString("river")));
            else instance.setOceanBiome(Biomes.PLAINS.getRegistryName());
            if(compound.hasKey("mushroom")) instance.setMushroomBiome(new ResourceLocation(compound.getString("mushroom")));
            else instance.setOceanBiome(Biomes.PLAINS.getRegistryName());
        } else ExpanseBiomeResource.LOGGER.error("Biome capability was not read in with NBT compound");
    }
}
