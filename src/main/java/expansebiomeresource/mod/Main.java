package expansebiomeresource.mod;

import expansebiomeresource.mod.proxy.CommonProxy;
import expansebiomeresource.mod.util.Reference;
import expansebiomeresource.mod.util.handlers.RegistryHandler;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.Mod.Instance;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
//Import references and utilities 

//Declare mod ID, name, and version. By making this a reference instead, you can copy it across mods and simply change
//the included reference file instead. 
@Mod(modid = Reference.MODID, name = Reference.MODNAME, version = Reference.VERSION)
public class Main {
	//Can't refer to main.class, so refer to main instance instead 
	@Instance
	public static Main instance;
	
	@SidedProxy(clientSide = Reference.CLIENT, serverSide = Reference.SERVER)
	public static CommonProxy proxy;
	
	@EventHandler	
	public static void preInit(FMLPreInitializationEvent event) {
		
		RegistryHandler.preInitRegistries(); 
	}
	@EventHandler	
	public static void init(FMLInitializationEvent event) {}
	@EventHandler	
	public static void postInit(FMLPostInitializationEvent event) {
		
		RegistryHandler.postInitRegistries();
	}
	
}
