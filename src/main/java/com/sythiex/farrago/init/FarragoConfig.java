package com.sythiex.farrago.init;

import com.sythiex.farrago.FarragoMod;

import net.minecraftforge.common.config.Configuration;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

public class FarragoConfig
{
	public static final String CATEGORY_FEATURES = "1) features";
	public static final String CATEGORY_SETTINGS = "2) settings";
	public static final String CATEGORY_RECIPES = "3) vanilla recipes";
	public static final String CATEGORY_COMPAT = "4) compat";
	
	public static boolean addBlockInfiniteWater;
	public static boolean addBlockBlazingLantern;
	public static boolean addItemBuildWand;
	public static boolean addItemBatKiller;
	public static boolean addCotton;
	public static boolean addFlowers;
	
	public static boolean enableLargeRivers;
	public static int cottonSeedDropWeight;
	
	public static boolean addBlockGrassRecipe;
	public static boolean addSpongeRecipe;
	public static boolean addClayRecipe;
	public static boolean addClayBallRecipe;
	public static boolean addQuartzRecipe;
	public static boolean addWebRecipe;
	public static boolean addSaddleRecipe;
	public static boolean addChainArmorRecipes;
	public static boolean addFlintRecipe;
	public static boolean addHorseArmorRecipes;
	public static boolean addNameTagRecipe;
	
	public static boolean enableHarvestcraftCompat;
	
	public static void loadConfig(FMLPreInitializationEvent event)
	{
		FarragoMod.logger.info("Loading Config");
		
		Configuration config = new Configuration(event.getSuggestedConfigurationFile());
		
		config.setCategoryComment(CATEGORY_FEATURES, "Enable/Disable Mod Features");
		config.setCategoryRequiresMcRestart(CATEGORY_FEATURES, true);
		config.setCategoryRequiresWorldRestart(CATEGORY_FEATURES, true);
		
		config.setCategoryComment(CATEGORY_SETTINGS, "Various Mod Settings");
		config.setCategoryRequiresMcRestart(CATEGORY_SETTINGS, true);
		config.setCategoryRequiresWorldRestart(CATEGORY_SETTINGS, true);
		
		config.setCategoryComment(CATEGORY_RECIPES, "Add Vanilla Recipes");
		config.setCategoryRequiresMcRestart(CATEGORY_RECIPES, true);
		config.setCategoryRequiresWorldRestart(CATEGORY_RECIPES, true);
		
		config.setCategoryComment(CATEGORY_COMPAT, "Enable/Disable Mod Compatibility");
		config.setCategoryRequiresMcRestart(CATEGORY_COMPAT, true);
		config.setCategoryRequiresWorldRestart(CATEGORY_COMPAT, true);
		
		config.load();
		
		addItemBatKiller = config.getBoolean("Bat-B-Gone", CATEGORY_FEATURES, true, "");
		addBlockBlazingLantern = config.getBoolean("Blazing Lantern", CATEGORY_FEATURES, true, "");
		addCotton = config.getBoolean("Cotton Plants", CATEGORY_FEATURES, true, "");
		addItemBuildWand = config.getBoolean("Creative Build Wand [WIP]", CATEGORY_FEATURES, false, "");
		addBlockInfiniteWater = config.getBoolean("Ender Water Well", CATEGORY_FEATURES, true, "");
		addFlowers = config.getBoolean("Extra Flowers", CATEGORY_FEATURES, true, "");
		enableLargeRivers = config.getBoolean("Generate larger rivers (may cause compatibilty issues)", CATEGORY_FEATURES, false, "");
		
		cottonSeedDropWeight = config.getInt("Cotton seed drop weight from tall grass (0 disables)", CATEGORY_SETTINGS, 5, 0, 100, "");
		
		addQuartzRecipe = config.getBoolean("Block of Quartz to Nether Quartz Recipe", CATEGORY_RECIPES, true, "");
		addBlockGrassRecipe = config.getBoolean("Grass Block Recipe", CATEGORY_RECIPES, true, "");
		addSpongeRecipe = config.getBoolean("Sponge Recipe", CATEGORY_RECIPES, true, "");
		addClayRecipe = config.getBoolean("Clay Recipe", CATEGORY_RECIPES, true, "");
		addClayBallRecipe = config.getBoolean("Clay Block to Item Recipe", CATEGORY_RECIPES, true, "");
		addWebRecipe = config.getBoolean("Cobweb Recipe", CATEGORY_RECIPES, true, "");
		addSaddleRecipe = config.getBoolean("Saddle Recipe", CATEGORY_RECIPES, true, "");
		addChainArmorRecipes = config.getBoolean("Chain Armor Recipes", CATEGORY_RECIPES, true, "");
		addFlintRecipe = config.getBoolean("Flint Recipe", CATEGORY_RECIPES, true, "");
		addHorseArmorRecipes = config.getBoolean("Horse Armor Recipes", CATEGORY_RECIPES, true, "");
		addNameTagRecipe = config.getBoolean("Name Tag Recipe", CATEGORY_RECIPES, true, "");
		
		enableHarvestcraftCompat = config.getBoolean("Pam's HarvestCraft", CATEGORY_COMPAT, true, "");
		
		config.save();
	}
}
