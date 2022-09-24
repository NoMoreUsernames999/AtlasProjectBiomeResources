package expansebiomeresource.mod.capabilities.customworldtypebiomes;

import net.minecraft.nbt.NBTBase;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.EnumFacing;
import net.minecraftforge.common.capabilities.*;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;

public class CWTBProvider implements ICapabilitySerializable<NBTBase> {

    @CapabilityInject(CWTBInterface.class)
    public static final Capability<CWTBInterface> CUSTOM_WORLD_TYPE_BIOMES_CAPABILITY = null;
    private final CWTBInterface impl = CUSTOM_WORLD_TYPE_BIOMES_CAPABILITY.getDefaultInstance();
    @Override
    public boolean hasCapability(@Nonnull Capability<?> capability, @Nullable EnumFacing facing) {
        return capability==CUSTOM_WORLD_TYPE_BIOMES_CAPABILITY;
    }

    @Nullable
    @Override
    public <T> T getCapability(@Nonnull Capability<T> capability, @Nullable EnumFacing facing) {
        return capability == CUSTOM_WORLD_TYPE_BIOMES_CAPABILITY ? CUSTOM_WORLD_TYPE_BIOMES_CAPABILITY.cast(this.impl) : null;
    }

    @Override
    public NBTBase serializeNBT() {
        return CUSTOM_WORLD_TYPE_BIOMES_CAPABILITY.getStorage().writeNBT(CUSTOM_WORLD_TYPE_BIOMES_CAPABILITY, this.impl, null);
    }

    @Override
    public void deserializeNBT(NBTBase nbt) {
        CUSTOM_WORLD_TYPE_BIOMES_CAPABILITY.getStorage().readNBT(CUSTOM_WORLD_TYPE_BIOMES_CAPABILITY, this.impl, null, nbt);
    }
}
