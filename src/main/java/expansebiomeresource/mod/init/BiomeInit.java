package expansebiomeresource.mod.init;

import expansebiomeresource.mod.ExpanseBiomeResource;
import expansebiomeresource.mod.world.biome.*;
import net.minecraft.world.biome.*;
import net.minecraftforge.common.BiomeDictionary;
import net.minecraftforge.common.BiomeDictionary.Type;
import net.minecraftforge.common.BiomeManager;
import net.minecraftforge.common.BiomeManager.BiomeEntry;
import net.minecraftforge.common.BiomeManager.BiomeType;
import net.minecraftforge.fml.common.registry.ForgeRegistries;


import java.util.*;

@SuppressWarnings("SameParameterValue")
public class BiomeInit {
	public static final HashMap<String, BiomeEntry> biomeMap = new HashMap<>();
	public static final HashMap<String, BiomeType> typeMap = new HashMap<>();
	public static final HashMap<Biome, List<Biome>> biomeEdgeMap = new HashMap<>();
	public static final HashMap<Biome, List<Biome>> biomeHillMap = new HashMap<>();
	
	public static final Biome MARSFLATS = new BiomeMarsFlats(); 
	public static final Biome MARSCANYON = new BiomeMarsCanyon(); 
	public static final Biome MARSHILLS = new BiomeMarsHills(); 
	public static final Biome MARSMOUNTAIN = new BiomeMarsMountain(); 
	public static final Biome MARSVALLEY = new BiomeMarsValley();
	public static final Biome MARSBARREN = new BiomeMarsBarren();

	public static final Biome LUNAFLATS = new BiomeLunaFlats();
	public static final Biome LUNAVALLEY = new BiomeLunaDark();
	public static final Biome LUNAHILLS = new BiomeLunaHills();
	public static final Biome TORUS3MESASPIKE = new BiomeMesa(true, false, new Biome.BiomeProperties("Eroded Spires"));
	public static final Biome TORUS3MESA = new BiomeTorusMesa();
	public static final Biome TORUS3DESERT = new BiomeDesert(new Biome.BiomeProperties("Torus Desert"));
	public static final Biome TORUS2SHALLOWS = new BiomeTorusShallows();
	public static final Biome TORUS2KELP = new BiomeTorusKelp();
	public static final Biome TORUS2BLOOD = new BiomeTorusKelpBlood();
	public static final Biome TORUS2GRASSY = new BiomeTorusGrassy();
	public static final Biome TORUS2MUSHROOM = new BiomeTorusMushroom();
	public static final Biome TORUS2DUNES = new BiomeTorusDunes();
	public static final Biome TORUS2GRAND = new BiomeTorusGrandReef();
	public static final Biome TORUS2CRAG = new BiomeTorusCrag();
	public static final Biome TORUS2GRANDPIT = new BiomeTorusGrandPit();
	public static final Biome TORUS2REEF = new BiomeTorusReef();
	public static final Biome TORUS2BULBS = new BiomeTorusBulbs();
	public static final Biome TORUS2ISLAND = new BiomeTorusIsland();
	public static final Biome TORUS2ISLANDW = new BiomeTorusIslandFloat();
	public static final Biome TORUSDICE = new BiomeTorusDIce();
	public static final Biome TORUSDICEH = new BiomeTorusDIceH();
	public static final Biome TORUSDHILLS = new BiomeTorusHills();
	public  static final Biome TORUSDSPIKES = new BiomeTorusIceSpikes();
	//public static final Biome CRYSTALCAVERNS = new BiomeCrystalCaverns();
	//public static final Biome FUNGALCAVERNS = new BiomeFungalCaverns();
	//public static final Biome UNDERFOREST = new BiomeUnderForest();
	//public static final Biome UNDERRAINFOREST = new BiomeUnderRainForest();
	//public static final Biome HOWLINGCLIFFS = new BiomeHowlingCliffs();
	public static final Biome VENUSFLATS = new BiomeVenusFlats();
	public static final Biome VENUSCRATER = new BiomeVenusCraters();
	public static final Biome VENUSHILLS = new BiomeVenusHills();
	public static final Biome VENUSMOUNTAIN = new BiomeVenusMountains();
	public static final Biome VENUSRIDGE = new BiomeVenusRidge();
	public static final Biome TITANFLATS= new BiomeTitanFlats();
	public static final Biome TITANMOUNTAINS= new BiomeTitanMountains();
	public static final Biome TITANHILLS= new BiomeTitanHills();
	public static final Biome TITANOCEAN= new BiomeTitanOcean();


	
	public static void registerBiomes() {
		//Cytan
		initBiome(TORUS3MESA, "torus3mesa", 3, false, new ArrayList<>(), Arrays.asList(TORUS3DESERT), BiomeType.WARM, Type.HOT);
		initBiome(TORUS3MESASPIKE, "torus3mesaspike", 5, false, new ArrayList<>(), Arrays.asList(TORUS3DESERT, TORUS3MESA), BiomeType.WARM, Type.HOT);
		initBiome(TORUS3DESERT, "torus3desert", 7, false, new ArrayList<>(), Arrays.asList(TORUS3MESASPIKE, TORUS3MESA), BiomeType.DESERT, Type.SANDY, Type.HOT);

		//Argius
		initBiome(TORUS2SHALLOWS, "torus2shallows", 0, false, new ArrayList<>(), new ArrayList<>(), BiomeType.WARM, Type.PLAINS, Type.SANDY, Type.WET);
		initBiome(TORUS2KELP, "torus2kelp", 25, false, new ArrayList<>(), Arrays.asList(TORUS2SHALLOWS), BiomeType.WARM, Type.PLAINS, Type.SANDY, Type.WET);
		initBiome(TORUS2GRASSY, "torus2grassy", 25, false, new ArrayList<>(), new ArrayList<>(), BiomeType.COOL, Type.PLAINS, Type.SANDY, Type.WET);
		initBiome(TORUS2ISLAND, "torus2island", 0, false, new ArrayList<>(), new ArrayList<>(), BiomeType.WARM, Type.MOUNTAIN, Type.HILLS, Type.BEACH);
		initBiome(TORUS2CRAG, "torus2crag", 15, false, new ArrayList<>(), Arrays.asList(TORUS2ISLAND), BiomeType.COOL, Type.DEAD, Type.HILLS, Type.WET);
		initBiome(TORUS2BLOOD, "torus2blood", 15, false, new ArrayList<>(), new ArrayList<>(), BiomeType.COOL, Type.HILLS, Type.WET);
		initBiome(TORUS2DUNES, "torus2dunes", 25, false, new ArrayList<>(), Arrays.asList(TORUS2MUSHROOM), BiomeType.COOL, Type.SANDY, Type.WET);
		initBiome(TORUS2MUSHROOM, "torus2mushroom", 0, false, new ArrayList<>(), new ArrayList<>(), BiomeType.COOL, Type.RARE, Type.WET);
		initBiome(TORUS2GRAND, "torus2grandreef", 20, false, new ArrayList<>(), Arrays.asList(TORUS2GRANDPIT), BiomeType.COOL, Type.SPOOKY, Type.WET);
		initBiome(TORUS2GRANDPIT, "torus2grandpit", 0, false, new ArrayList<>(), new ArrayList<>(), BiomeType.COOL, Type.HILLS, Type.SPOOKY, Type.WET);
		initBiome(TORUS2REEF, "torus2reef", 3, false, new ArrayList<>(), new ArrayList<>(), BiomeType.WARM, Type.WET, Type.RIVER);
		initBiome(TORUS2BULBS, "torus2bulbs", 23, false, new ArrayList<>(), new ArrayList<>(), BiomeType.COOL, Type.WET, Type.PLAINS);
		initBiome(TORUS2ISLANDW, "torus2islandw", 15, false, new ArrayList<>(), new ArrayList<>(), BiomeType.COOL, Type.MOUNTAIN, Type.WET);

		//Torus_D
		initBiome(TORUSDICE, "torusdice", 20, false, new ArrayList<>(), Arrays.asList(TORUSDICEH), BiomeType.ICY, Type.PLAINS, Type.COLD);
		initBiome(TORUSDICEH, "torusdiceh", 20, false, new ArrayList<>(), Arrays.asList(TORUSDHILLS), BiomeType.ICY, Type.PLAINS, Type.COLD);
		initBiome(TORUSDHILLS, "torusdhills", 0, false, new ArrayList<>(), new ArrayList<>(), BiomeType.ICY, Type.HILLS, Type.COLD);
		initBiome(TORUSDSPIKES, "torusdspikes", 18, false, new ArrayList<>(), Arrays.asList(TORUSDICE), BiomeType.ICY, Type.SPOOKY, Type.COLD);

		//Ganes
		//initBiome(CRYSTALCAVERNS, "crystalcaverns", 10, false, new ArrayList<>(), new ArrayList<>(), BiomeType.COOL, Type.HILLS, Type.RARE);
		//initBiome(FUNGALCAVERNS, "fungalcaverns", 20, false, new ArrayList<>(), new ArrayList<>(), BiomeType.WARM, Type.PLAINS, Type.MUSHROOM, Type.SAVANNA);
		//initBiome(UNDERFOREST, "underforest", 20, false, new ArrayList<>(), new ArrayList<>(), BiomeType.WARM, Type.LUSH, Type.DENSE, Type.FOREST);
		//initBiome(UNDERRAINFOREST, "underrainforest", 20, false, new ArrayList<>(), new ArrayList<>(), BiomeType.WARM, Type.LUSH, Type.HILLS, Type.JUNGLE, Type.WET);
		//initBiome(HOWLINGCLIFFS, "howlingcliffs", 0, false, new ArrayList<>(), new ArrayList<>(), BiomeType.COOL, Type.MOUNTAIN, Type.SPOOKY, Type.DEAD, Type.COLD);

		//Mars
		initBiome(MARSFLATS, "marsflats", 30, false, new ArrayList<>(), Arrays.asList(MARSHILLS, MARSMOUNTAIN), BiomeType.DESERT, Type.DEAD, Type.DRY, Type.PLAINS, Type.HOT, Type.SANDY);
		initBiome(MARSCANYON, "marscanyon", 3, false, new ArrayList<>(), new ArrayList<>(), BiomeType.WARM, Type.DRY, Type.RIVER, Type.SANDY);
		initBiome(MARSHILLS, "marshills", 22, false, new ArrayList<>(), Arrays.asList(MARSFLATS), BiomeType.WARM, Type.DEAD, Type.DRY, Type.HILLS, Type.SANDY);
		initBiome(MARSMOUNTAIN, "marsmountain", 0, false, new ArrayList<>(), new ArrayList<>(), BiomeType.COOL, Type.DEAD, Type.DRY, Type.MOUNTAIN, Type.SANDY);
		initBiome(MARSVALLEY, "marsvalley", 8, true, new ArrayList<>(), Arrays.asList(MARSBARREN), BiomeType.COOL, Type.DEAD, Type.DRY, Type.RARE, Type.OCEAN, Type.SANDY);
		initBiome(MARSBARREN, "marsbarren", 20, false, new ArrayList<>(), new ArrayList<>(), BiomeType.WARM, Type.DEAD, Type.DRY, Type.PLAINS, Type.SANDY);

		//Luna
		initBiome(LUNAFLATS, "lunaflats", 30, false, new ArrayList<>(), Arrays.asList(LUNAVALLEY), BiomeType.COOL, Type.DEAD, Type.COLD);
		initBiome(LUNAVALLEY, "lunavalley", 0, false, new ArrayList<>(), new ArrayList<>(), BiomeType.COOL, Type.DEAD, Type.COLD);
		initBiome(LUNAHILLS, "lunahills", 25, false, new ArrayList<>(), Arrays.asList(LUNAVALLEY), BiomeType.COOL, Type.DEAD, Type.COLD);

		//Venus
		initBiome(VENUSFLATS, "venusflats", 30, false, new ArrayList<>(), Arrays.asList(VENUSCRATER), BiomeType.WARM, Type.PLAINS, Type.DEAD, Type.HOT);
		initBiome(VENUSCRATER, "venuscrater", 0, false, new ArrayList<>(), new ArrayList<>(), BiomeType.WARM, Type.SANDY, Type.DEAD, Type.HOT);
		initBiome(VENUSHILLS, "venushills", 30, false, new ArrayList<>(), Arrays.asList(VENUSMOUNTAIN), BiomeType.WARM, Type.HILLS, Type.DEAD, Type.HOT);
		initBiome(VENUSMOUNTAIN, "venusmountain", 0, false, new ArrayList<>(), new ArrayList<>(), BiomeType.WARM, Type.MOUNTAIN, Type.DEAD, Type.HOT);
		initBiome(VENUSRIDGE, "venusridge", 10, false, new ArrayList<>(), new ArrayList<>(), BiomeType.WARM, Type.RIVER, Type.DEAD, Type.HOT);

		//Titan
		initBiome(TITANFLATS, "titanflats", 30, false, new ArrayList<>(), Arrays.asList(TITANMOUNTAINS), BiomeType.WARM, Type.DEAD, Type.PLAINS);
		initBiome(TITANMOUNTAINS, "titanmountains", 25, false, new ArrayList<>(), Arrays.asList(TITANFLATS), BiomeType.WARM, Type.DEAD, Type.MOUNTAIN);
		initBiome(TITANHILLS, "titanhills", 0, false, new ArrayList<>(), new ArrayList<>(), BiomeType.WARM, Type.DEAD, Type.HILLS);
		initBiome(TITANOCEAN, "titanocean", 5, true, new ArrayList<>(), Arrays.asList(TITANHILLS), BiomeType.COOL, Type.OCEAN);
	}

	private static void initBiome(Biome biome, String name, int weight, boolean isOceanic, List<Biome> edges, List<Biome> hills, BiomeType biometype, Type... types) {
		biome.setRegistryName(name);
		ForgeRegistries.BIOMES.register(biome);
		BiomeDictionary.addTypes(biome, types);
		BiomeEntry entry = new BiomeEntry(biome, weight);
		BiomeManager.addBiome(biometype, entry);
		BiomeManager.addSpawnBiome(biome);
		if(isOceanic) BiomeManager.oceanBiomes.add(biome);
		biomeMap.put(name,entry);
		typeMap.put(name,biometype);
		biomeEdgeMap.put(biome,edges);
		biomeHillMap.put(biome,hills);
		ExpanseBiomeResource.LOGGER.info("An Expanse biome has been registered");
	}

}
