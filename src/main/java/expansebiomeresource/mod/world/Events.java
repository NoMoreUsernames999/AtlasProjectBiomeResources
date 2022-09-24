package expansebiomeresource.mod.world;

import expansebiomeresource.mod.capabilities.customworldtypebiomes.CWTBProvider;
import expansebiomeresource.mod.util.Reference;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.World;
import net.minecraftforge.event.AttachCapabilitiesEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

@Mod.EventBusSubscriber(modid = Reference.MODID)
public class Events {

    public static final ResourceLocation CUSTOM_WORLD_TYPE_BIOMES_CAPABILITY = new ResourceLocation(Reference.MODID, "custom_world_type_biomes");

    @SubscribeEvent
    public static void attachWorldCapabilities(AttachCapabilitiesEvent<World> event) {
        if(event.getObject().getWorldType() instanceof WorldTypes.WorldTypeBundle)
            event.addCapability(CUSTOM_WORLD_TYPE_BIOMES_CAPABILITY, new CWTBProvider());
    }
}