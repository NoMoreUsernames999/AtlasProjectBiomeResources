package expansebiomeresource.mod;

import expansebiomeresource.mod.capabilities.customworldtypebiomes.CWTBCapability;
import expansebiomeresource.mod.capabilities.customworldtypebiomes.CWTBInterface;
import expansebiomeresource.mod.capabilities.customworldtypebiomes.CWTBStorage;
import expansebiomeresource.mod.proxy.CommonProxy;
import expansebiomeresource.mod.util.Reference;
import expansebiomeresource.mod.util.handlers.RegistryHandler;
import expansebiomeresource.mod.world.Events;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.common.capabilities.CapabilityManager;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

//Declare mod ID, name, and version. By making this a reference instead, you can copy it across mods and simply change
//the included reference file instead. 
@Mod(modid = Reference.MODID, name = Reference.MODNAME, version = Reference.VERSION, dependencies = Reference.DEPENDENCIES)
public class ExpanseBiomeResource {

	public static Logger LOGGER;

	public ExpanseBiomeResource() {
		LOGGER = LogManager.getLogger(Reference.MODID);
	}
	
	@SidedProxy(clientSide = Reference.CLIENT, serverSide = Reference.SERVER)
	public static CommonProxy proxy;
	
	@EventHandler	
	public static void preInit(FMLPreInitializationEvent event) {
		RegistryHandler.preInitRegistries();
		CapabilityManager.INSTANCE.register(CWTBInterface.class, new CWTBStorage(), CWTBCapability::new);
		MinecraftForge.EVENT_BUS.register(Events.class);
	}
	@EventHandler	
	public static void init(FMLInitializationEvent event) {}
	@EventHandler	
	public static void postInit(FMLPostInitializationEvent event) {
		RegistryHandler.postInitRegistries();
	}
	
}
