package expansebiomeresource.mod.init;

import biomesoplenty.api.generation.GeneratorStage;
import biomesoplenty.api.generation.IGenerator;
import biomesoplenty.common.world.GenerationManager;
import expansebiomeresource.mod.ExpanseBiomeResource;
import expansebiomeresource.mod.world.biome.*;
import net.minecraft.world.biome.*;
import net.minecraftforge.common.BiomeDictionary;
import net.minecraftforge.common.BiomeDictionary.Type;
import net.minecraftforge.common.BiomeManager;
import net.minecraftforge.common.BiomeManager.BiomeEntry;
import net.minecraftforge.common.BiomeManager.BiomeType;
import net.minecraftforge.fml.common.registry.ForgeRegistries;
import vibrantjourneys.biomes.BiomeOvergrownSpires;


import java.util.*;

@SuppressWarnings("SameParameterValue")
public class BiomeInit {

	public static final HashMap<String, BiomeEntry> biomeMap = new HashMap<>();
	public static final HashMap<String, BiomeType> typeMap = new HashMap<>();
	public static final HashMap<Biome, List<Biome>> biomeEdgeMap = new HashMap<>();
	public static final HashMap<Biome, List<Biome>> biomeHillMap = new HashMap<>();

	//Mars
	public static final Biome MARSFLATS = new BiomeMarsFlats(); 
	public static final Biome MARSCANYON = new BiomeMarsCanyon(); 
	public static final Biome MARSHILLS = new BiomeMarsHills(); 
	public static final Biome MARSMOUNTAIN = new BiomeMarsMountain(); 
	public static final Biome MARSVALLEY = new BiomeMarsValley();
	public static final Biome MARSBARREN = new BiomeMarsBarren();

	//Luna
	public static final Biome LUNAFLATS = new BiomeLunaFlats();
	public static final Biome LUNAVALLEY = new BiomeLunaDark();
	public static final Biome LUNAHILLS = new BiomeLunaHills();

	//Cytan
	public static final Biome TORUS3MESASPIKE = new BiomeTorusSpires();
	public static final Biome TORUS3MESA = new BiomeTorusMesa();
	public static final Biome TORUS3DESERT = new BiomeTorusDesert();

	//Argius
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

	//Torus_D
	public static final Biome TORUSDICE = new BiomeTorusDIce();
	public static final Biome TORUSDICEH = new BiomeTorusDIceH();
	public static final Biome TORUSDHILLS = new BiomeTorusHills();
	public  static final Biome TORUSDSPIKES = new BiomeTorusIceSpikes();

	//Ganes
	public static final Biome CRYSTALCAVERNS = new BiomeCrystalCaverns();
	public static final Biome FUNGALCAVERNS = new BiomeFungalCaverns();
	public static final Biome FORESTCAVERNS = new BiomeForestCaverns();

	//Venus
	public static final Biome VENUSFLATS = new BiomeVenusFlats();
	public static final Biome VENUSCRATER = new BiomeVenusCraters();
	public static final Biome VENUSHILLS = new BiomeVenusHills();
	public static final Biome VENUSMOUNTAIN = new BiomeVenusMountains();
	public static final Biome VENUSRIDGE = new BiomeVenusRidge();

	//Titan
	public static final Biome TITANFLATS= new BiomeTitanFlats();
	public static final Biome TITANMOUNTAINS= new BiomeTitanMountains();
	public static final Biome TITANHILLS= new BiomeTitanHills();
	public static final Biome TITANOCEAN= new BiomeTitanOcean();

	//Enceladus
	public static final Biome ENCELADUSWASTES = new BiomeEnceladusWastes();
	//public static final Biome ENCELADUSPLATEAU = new BiomeEnceladusPlateau();
	public static final Biome ENCELADUSCRATER = new BiomeEnceladusCrater();
	public static final Biome ENCELADUSCANYON = new BiomeEnceladusCanyon();

	//IO
	public static final Biome IOWASTES = new BiomeIoWastes();
	public static final Biome IOSPIRES = new BiomeIoSpires();
	public static final Biome IOHILLS = new BiomeIoHills();
	public static final Biome IOSULFUR = new BiomeIoSulfur();

	//Arrakis
	public static final Biome ARRAKISDESERT = new BiomeArrakisDesert();
	public static final Biome ARRAKISSANDS = new BiomeArrakisSands();
	public static final Biome ARRAKISHILLS = new BiomeArrakisHills();
	public static final Biome ARRAKISDUNES = new BiomeArrakisDunes();

	//Chibirus
	public static final Biome CHIBIRUSDESERT = new BiomeChibirusDesert();
	public static final Biome CHIBIRUSRIDGE = new BiomeChibirusRidge();
	public static final Biome CHIBIRUSMOUNTAIN = new BiomeChibirusMountain();
	public static final Biome CHIBIRUSWASTES = new BiomeChibirusWastes();
	public static final Biome CHIBIRUSCAVES = new BiomeChibirusCaves();

	//Pythrea
	public static final Biome PYTHREASHALLOWS = new BiomePythreaShallows();
	public static final Biome PYTHREAOCEAN = new BiomePythreaOcean();
	public static final Biome PYTHREAISLANDS = new BiomePythreaIslands();
	//public static final Biome PYTHREATRENCH = new BiomePythreaTrench();
	public static final Biome PYTHREARIDGE = new BiomePythreaRidge();
	public static final Biome PLOCURYDESERT = new BiomePlocuryDesert();
	public static final Biome PLOCURYBRUSH = new BiomePlocuryBrush();
	//public static final Biome PLOCURYOUTBACK = new BiomePlocuryOutback();
	//public static final Biome PLOCURYSTEPPE = new BiomePlocurySteppe();
	public static final Biome PLOCURYXERIC = new BiomePlocuryXeric();
	public static final Biome PLOCURYOASIS = new BiomePlocuryOasis();
	public static final Biome PLOCURYRIVER = new BiomePlocuryRiver();


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
		initBiome(CRYSTALCAVERNS, "crystalcaverns", 15, false, new ArrayList<>(), new ArrayList<>(), BiomeType.COOL, Type.HILLS, Type.RARE);
		initBiome(FUNGALCAVERNS, "fungalcaverns", 20, false, new ArrayList<>(), new ArrayList<>(), BiomeType.WARM, Type.PLAINS, Type.MUSHROOM);
		initBiome(FORESTCAVERNS, "forestcaverns", 20, false, new ArrayList<>(), new ArrayList<>(), BiomeType.WARM, Type.LUSH, Type.DENSE, Type.FOREST);

		//Mars
		initBiome(MARSFLATS, "marsflats", 30, false, new ArrayList<>(), Arrays.asList(MARSHILLS), BiomeType.DESERT, Type.DEAD, Type.DRY, Type.PLAINS, Type.HOT, Type.SANDY);
		initBiome(MARSCANYON, "marscanyon", 3, false, new ArrayList<>(), new ArrayList<>(), BiomeType.WARM, Type.DRY, Type.RIVER, Type.SANDY);
		initBiome(MARSHILLS, "marshills", 22, false, new ArrayList<>(), Arrays.asList(MARSMOUNTAIN), BiomeType.WARM, Type.DEAD, Type.DRY, Type.HILLS, Type.SANDY);
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
		initBiome(TITANOCEAN, "titanocean", 3, true, new ArrayList<>(), Arrays.asList(TITANHILLS), BiomeType.COOL, Type.OCEAN);

		//Enceladus
		initBiome(ENCELADUSWASTES, "enceladuswastes", 30, false, new ArrayList<>(), Arrays.asList(ENCELADUSCRATER), BiomeType.ICY, Type.PLAINS, Type.COLD);
		//initBiome(ENCELADUSPLATEAU, "enceladusplateau", 1, false, new ArrayList<>(), new ArrayList<>(), BiomeType.ICY, Type.HILLS, Type.COLD);
		initBiome(ENCELADUSCRATER, "enceladuscrater", 0, false, new ArrayList<>(), new ArrayList<>(), BiomeType.ICY, Type.COLD);
		initBiome(ENCELADUSCANYON, "enceladuscanyon", 28, false, new ArrayList<>(), new ArrayList<>(), BiomeType.ICY, Type.COLD, Type.RIVER);

		//IO
		initBiome(IOWASTES, "iowastes", 25, false, new ArrayList<>(), Arrays.asList(IOHILLS), BiomeType.COOL, Type.COLD, Type.WASTELAND);
		initBiome(IOSPIRES, "iospires", 0, false, new ArrayList<>(), new ArrayList<>(), BiomeType.COOL, Type.COLD, Type.HILLS);
		initBiome(IOHILLS, "iohills", 0, false, new ArrayList<>(), new ArrayList<>(), BiomeType.COOL, Type.COLD, Type.MOUNTAIN);
		initBiome(IOSULFUR, "iosulfur", 25, false, new ArrayList<>(), Arrays.asList(IOSPIRES), BiomeType.COOL, Type.HOT, Type.SANDY);

		//Arrakis
		initBiome(ARRAKISDESERT, "arrakisdesert", 20, false, new ArrayList<>(), Arrays.asList(ARRAKISHILLS), BiomeType.DESERT, Type.HOT, Type.SANDY, Type.WASTELAND);
		initBiome(ARRAKISSANDS, "arrakissands", 20, false, new ArrayList<>(), Arrays.asList(ARRAKISDESERT), BiomeType.DESERT, Type.HOT, Type.SANDY);
		initBiome(ARRAKISHILLS, "arrakishills", 0, false, new ArrayList<>(), new ArrayList<>(), BiomeType.DESERT, Type.HOT, Type.MOUNTAIN);
		initBiome(ARRAKISDUNES, "arrakisdunes", 17, false, new ArrayList<>(), new ArrayList<>(), BiomeType.DESERT, Type.HOT, Type.RIVER);

		//Chibirus
		initBiome(CHIBIRUSDESERT, "chibirusdesert", 30, false, new ArrayList<>(), Arrays.asList(CHIBIRUSWASTES), BiomeType.COOL, Type.COLD, Type.PLAINS);
		initBiome(CHIBIRUSRIDGE, "chibirusridge", 18, false, new ArrayList<>(), new ArrayList<>(), BiomeType.COOL, Type.COLD, Type.RIVER);
		initBiome(CHIBIRUSMOUNTAIN, "chibirusmountain", 10, false, new ArrayList<>(), Arrays.asList(CHIBIRUSDESERT), BiomeType.COOL, Type.COLD, Type.MOUNTAIN);
		initBiome(CHIBIRUSWASTES, "chibiruswastes", 25, false, new ArrayList<>(), Arrays.asList(CHIBIRUSCAVES), BiomeType.COOL, Type.COLD, Type.WASTELAND);
		initBiome(CHIBIRUSCAVES, "chibiruscaves", 0, false, new ArrayList<>(), new ArrayList<>(), BiomeType.COOL, Type.COLD, Type.HILLS);

		//Kraztus

		//Pythrea
		initBiome(PYTHREASHALLOWS, "pythreashallows", 20, false, new ArrayList<>(), Arrays.asList(PYTHREAISLANDS), BiomeType.WARM, Type.WATER, Type.OCEAN);
		initBiome(PYTHREAOCEAN, "pythreaocean", 17, false, new ArrayList<>(), new ArrayList<>(), BiomeType.WARM, Type.WATER);
		//initBiome(PYTHREATRENCH, "pythreatrench", 0, false, new ArrayList<>(), new ArrayList<>(), BiomeType.WARM, Type.SPOOKY, Type.WATER, Type.OCEAN);
		initBiome(PYTHREAISLANDS, "pythreaislands", 0, false, new ArrayList<>(), new ArrayList<>(), BiomeType.WARM, Type.SANDY);
		initBiome(PYTHREARIDGE, "pythrearidge", 18, false, new ArrayList<>(), new ArrayList<>(), BiomeType.WARM, Type.BEACH, Type.RIVER);

		//Uranomi

		//Pretora4

		//Oxella
		//initBiome(OXELLAFLATS, "oxellaflats", 30, false, new ArrayList<>(), new ArrayList<>(), BiomeType.WARM, Type.WATER, Type.OCEAN);

		//Plocury
		initBiome(PLOCURYDESERT, "plocurydesert", 20, false, new ArrayList<>(), Arrays.asList(PLOCURYOASIS), BiomeType.DESERT, Type.HOT, Type.SANDY, Type.OCEAN);
		initBiome(PLOCURYBRUSH, "plocurybrush", 20, false, new ArrayList<>(), new ArrayList<>(), BiomeType.WARM, Type.DRY, Type.HOT, Type.SAVANNA);
		//initBiome(PLOCURYOUTBACK, "plocuryoutback", 20, false, new ArrayList<>(), new ArrayList<>(), BiomeType.WARM, Type.DRY, Type.HOT, Type.SAVANNA);
		//initBiome(PLOCURYSTEPPE, "plocurysteppe", 20, false, new ArrayList<>(), new ArrayList<>(), BiomeType.DESERT, Type.HOT, Type.DRY, Type.SPARSE);
		initBiome(PLOCURYXERIC, "plocuryxeric", 19, false, new ArrayList<>(), Arrays.asList(PLOCURYOASIS), BiomeType.DESERT, Type.HOT, Type.SANDY, Type.SPARSE);
		initBiome(PLOCURYOASIS, "plocuryoasis", 0, false, new ArrayList<>(), new ArrayList<>(), BiomeType.WARM, Type.WET, Type.BEACH, Type.LUSH);
		initBiome(PLOCURYRIVER, "plocuryriver", 2, false, new ArrayList<>(), new ArrayList<>(), BiomeType.WARM, Type.RIVER);

		//Tri-Thessya

		//Gelida-Tenebris

		//LV426

		//LV223

		//Novus-Terra

		//Pandora

		//Daedalus
		//initBiome(DAEDALUSPLAINS, "daedalusplains", 0, false, new ArrayList<>(), new ArrayList<>(), BiomeType.WARM, Type.WATER, Type.OCEAN);

		//Prometheus
		//initBiome(PROMETHEUSPLAINS, "prometheusplains", 0, false, new ArrayList<>(), new ArrayList<>(), BiomeType.WARM, Type.WATER, Type.OCEAN);

		//Vulcan
		////initBiome(VULCANWASTES, "vulcanwastes", 0, false, new ArrayList<>(), new ArrayList<>(), BiomeType.WARM, Type.WATER, Type.OCEAN);

		//XR013B
		////initBiome(XRPLAINS, "xrplains", 0, false, new ArrayList<>(), new ArrayList<>(), BiomeType.WARM, Type.WATER, Type.OCEAN);
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
		ExpanseBiomeResource.LOGGER.info("This is the way the world ends, This is the way the world ends, This is the way the world ends, Not with a bang but a whimper");
	}

}
