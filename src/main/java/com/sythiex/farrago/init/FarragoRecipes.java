package com.sythiex.farrago.init;

import com.sythiex.farrago.FarragoMod;

import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.IRecipe;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.common.Loader;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.oredict.OreDictionary;
import net.minecraftforge.oredict.ShapedOreRecipe;
import net.minecraftforge.oredict.ShapelessOreRecipe;
import net.minecraftforge.registries.GameData;

public class FarragoRecipes
{
	public static void loadRecipes(FMLInitializationEvent event)
	{
		registerOreDictionary();
		
		FarragoMod.logger.info("Registering Recipes");
		
		ResourceLocation noGroup = new ResourceLocation("");
		
		// @formatter:off
		/////////////////////////////////////////////////////////////////////////////// BLOCKS ///////////////////////////////////////////////////////////////////////////////
		
		if(FarragoConfig.addBlockInfiniteWater)
		{
			IRecipe blockInfiniteWaterRecipe = new ShapedOreRecipe(noGroup, new ItemStack(FarragoBlocks.blockInfiniteWater), new Object[] {
					"OWO",
					"WEW",
					"OWO",
					'O', "obsidian",
					'W', new ItemStack(Items.WATER_BUCKET),
					'E', "enderpearl" });
			GameData.register_impl(blockInfiniteWaterRecipe.setRegistryName(new ResourceLocation(FarragoMod.MODID + ":block_infinite_water")));
		}
		else
			FarragoMod.logger.info("Ender Water Well disabled in config, skipping recipe registration");
		
		if(FarragoConfig.addBlockBlazingLantern)
		{
			IRecipe blockBlazingLanternRecipe = new ShapedOreRecipe(noGroup, new ItemStack(FarragoBlocks.blockBlazingLantern), new Object[] {
					"OBO",
					"BEB",
					"OBO",
					'O', "obsidian",
					'B', new ItemStack(Items.BLAZE_ROD),
					'E', new ItemStack(Items.ENDER_EYE)	});
			GameData.register_impl(blockBlazingLanternRecipe.setRegistryName(new ResourceLocation(FarragoMod.MODID + ":block_blazing_lantern")));
		}
		else
			FarragoMod.logger.info("Blazing Lantern disabled in config, skipping recipe registration");
		
		/////////////////////////////////////////////////////////////////////////////// ITEMS ///////////////////////////////////////////////////////////////////////////////
		
		if(FarragoConfig.addCotton)
		{
			if(Loader.isModLoaded("harvestcraft") && FarragoConfig.enableHarvestcraftCompat)
			{
				FarragoMod.logger.info("Using Harvestcraft cotton to string recipe");
			}
			else
			{
				IRecipe stringCottonRecipe = new ShapelessOreRecipe(noGroup, new ItemStack(Items.STRING), new Object[] { new ItemStack(FarragoItems.itemCotton) });
				GameData.register_impl(stringCottonRecipe.setRegistryName(new ResourceLocation(FarragoMod.MODID + ":string_cotton")));
			}
		}
		else
			FarragoMod.logger.info("Cotton Crops disabled in config, skipping recipe registration");
		
		/////////////////////////////////////////////////////////////////////////////// VANILLA ///////////////////////////////////////////////////////////////////////////////
		
		if(FarragoConfig.addBlockGrassRecipe)
		{
			IRecipe blockGrassRecipe = new ShapedOreRecipe(noGroup, new ItemStack(Blocks.GRASS), new Object[] {
					"S",
					"D",
					'S', "seed",
					'D', "dirt"	});
			GameData.register_impl(blockGrassRecipe.setRegistryName(new ResourceLocation(FarragoMod.MODID + ":block_grass")));
		}
		else
			FarragoMod.logger.info("Grass Block recipe disabled in config, skipping recipe registration");
		
		if(FarragoConfig.addSpongeRecipe)
		{
			IRecipe spongeRecipe = new ShapedOreRecipe(noGroup, new ItemStack(Blocks.SPONGE), new Object[] {
					"WW",
					"WW",
					'W', "woolYellow" });
			GameData.register_impl(spongeRecipe.setRegistryName(new ResourceLocation(FarragoMod.MODID + ":sponge")));
		}
		else
			FarragoMod.logger.info("Sponge recipe disabled in config, skipping recipe registration");
		
		if(FarragoConfig.addClayRecipe)
		{
			IRecipe clayRecipe = new ShapelessOreRecipe(noGroup, new ItemStack(Blocks.CLAY), new Object[] {"dirt", "dirt", "sand", "listAllwater"});
			GameData.register_impl(clayRecipe.setRegistryName(new ResourceLocation(FarragoMod.MODID + ":clay")));
		}
		else
			FarragoMod.logger.info("Clay recipe disabled in config, skipping recipe registration");
		
		if(FarragoConfig.addClayBallRecipe)
		{
			IRecipe clayBallRecipe = new ShapelessOreRecipe(noGroup, new ItemStack(Items.CLAY_BALL, 4), new ItemStack(Blocks.CLAY));
			GameData.register_impl(clayBallRecipe.setRegistryName(new ResourceLocation(FarragoMod.MODID + ":clay_ball")));
		}
		else
			FarragoMod.logger.info("Clay ball recipe disabled in config, skipping recipe registration");
		
		if(FarragoConfig.addQuartzRecipe)
		{
			IRecipe quartzRecipe = new ShapelessOreRecipe(noGroup, new ItemStack(Items.QUARTZ, 4), new ItemStack(Blocks.QUARTZ_BLOCK));
			GameData.register_impl(quartzRecipe.setRegistryName(new ResourceLocation(FarragoMod.MODID + ":nether_quartz")));
		}
		else
			FarragoMod.logger.info("Nether Quartz recipe disabled in config, skipping recipe registration");
		
		if(FarragoConfig.addWebRecipe)
		{
			IRecipe webRecipe = new ShapedOreRecipe(noGroup, new ItemStack(Blocks.WEB), new Object[] {
					"S S",
					" S ",
					"S S",
					'S', new ItemStack(Items.STRING) });
			GameData.register_impl(webRecipe.setRegistryName(new ResourceLocation(FarragoMod.MODID + ":web")));
		}
		else
			FarragoMod.logger.info("Cobweb recipe disabled in config, skipping recipe registration");
		
		if(FarragoConfig.addSaddleRecipe)
		{
			IRecipe saddleRecipe = new ShapedOreRecipe(noGroup, new ItemStack(Items.SADDLE), new Object[] {
					"LLL",
					" L ",
					'L', "leather" });
			GameData.register_impl(saddleRecipe.setRegistryName(new ResourceLocation(FarragoMod.MODID + ":saddle")));
		}
		else
			FarragoMod.logger.info("Saddle recipe disabled in config, skipping recipe registration");
		
		if(FarragoConfig.addChainArmorRecipes)
		{
			IRecipe chainHelmetRecipe = new ShapedOreRecipe(noGroup, new ItemStack(Items.CHAINMAIL_HELMET), new Object[] {
					"III",
					"I I",
					'I', "nuggetIron" });
			GameData.register_impl(chainHelmetRecipe.setRegistryName(new ResourceLocation(FarragoMod.MODID + ":chain_helmet")));
			
			IRecipe chainChestplateRecipe = new ShapedOreRecipe(noGroup, new ItemStack(Items.CHAINMAIL_CHESTPLATE), new Object[] {
					"I I",
					"III",
					"III",
					'I', "nuggetIron" });
			GameData.register_impl(chainChestplateRecipe.setRegistryName(new ResourceLocation(FarragoMod.MODID + ":chain_chestplate")));
			
			IRecipe chainLeggingsRecipe = new ShapedOreRecipe(noGroup, new ItemStack(Items.CHAINMAIL_LEGGINGS), new Object[] {
					"III",
					"I I",
					"I I",
					'I', "nuggetIron" });
			GameData.register_impl(chainLeggingsRecipe.setRegistryName(new ResourceLocation(FarragoMod.MODID + ":chain_leggings")));
			
			IRecipe chainBootsRecipe = new ShapedOreRecipe(noGroup, new ItemStack(Items.CHAINMAIL_BOOTS), new Object[] {
					"I I",
					"I I",
					'I', "nuggetIron" });
			GameData.register_impl(chainBootsRecipe.setRegistryName(new ResourceLocation(FarragoMod.MODID + ":chain_boots")));
		}
		else
			FarragoMod.logger.info("Chain Armor recipes disabled in config, skipping recipe registration");
		
		if(FarragoConfig.addFlintRecipe)
		{
			IRecipe flintRecipe = new ShapelessOreRecipe(noGroup, new ItemStack(Items.FLINT), "gravel", "gravel", "gravel");
			GameData.register_impl(flintRecipe.setRegistryName(new ResourceLocation(FarragoMod.MODID + ":flint")));
		}
		else
			FarragoMod.logger.info("Flint recipe disabled in config, skipping recipe registration");
		
		if(FarragoConfig.addHorseArmorRecipes)
		{
			IRecipe ironHorseArmorRecipe = new ShapedOreRecipe(noGroup, new ItemStack(Items.IRON_HORSE_ARMOR), new Object[] {
					"I I",
					"LWL",
					"I I",
					'I', "ingotIron",
					'L', "leather",
					'W', "wool" });
			GameData.register_impl(ironHorseArmorRecipe.setRegistryName(new ResourceLocation(FarragoMod.MODID + ":iron_horse_armor")));
			
			IRecipe goldHorseArmorRecipe = new ShapedOreRecipe(noGroup, new ItemStack(Items.GOLDEN_HORSE_ARMOR), new Object[] {
					"G G",
					"LWL",
					"G G",
					'G', "ingotGold",
					'L', "leather",
					'W', "wool" });
			GameData.register_impl(goldHorseArmorRecipe.setRegistryName(new ResourceLocation(FarragoMod.MODID + ":gold_horse_armor")));
			
			IRecipe diamondHorseArmorRecipe = new ShapedOreRecipe(noGroup, new ItemStack(Items.DIAMOND_HORSE_ARMOR), new Object[] {
					"D D",
					"LWL",
					"D D",
					'D', "gemDiamond",
					'L', "leather",
					'W', "wool" });
			GameData.register_impl(diamondHorseArmorRecipe.setRegistryName(new ResourceLocation(FarragoMod.MODID + ":diamond_horse_armor")));
		}
		else
			FarragoMod.logger.info("Horse Armor recipes disabled in config, skipping recipe registration");
		
		if(FarragoConfig.addNameTagRecipe)
		{
			IRecipe nameTagRecipe = new ShapelessOreRecipe(noGroup, new ItemStack(Items.NAME_TAG), "paper", "string");
			GameData.register_impl(nameTagRecipe.setRegistryName(new ResourceLocation(FarragoMod.MODID + ":name_tag")));
		}
		else
			FarragoMod.logger.info("Name Tag recipe disabled in config, skipping recipe registration");
		
		// @formatter:on
	}
	
	private static void registerOreDictionary()
	{
		FarragoMod.logger.info("Registering Ore Dictionary Entries");
		
		OreDictionary.registerOre("listAllwater", new ItemStack(Items.WATER_BUCKET));
		OreDictionary.registerOre("seed", new ItemStack(Items.BEETROOT_SEEDS));
		OreDictionary.registerOre("seed", new ItemStack(Items.MELON_SEEDS));
		OreDictionary.registerOre("seed", new ItemStack(Items.PUMPKIN_SEEDS));
		OreDictionary.registerOre("seed", new ItemStack(Items.WHEAT_SEEDS));
		
		if(FarragoConfig.addCotton)
		{
			OreDictionary.registerOre("seed", new ItemStack(FarragoItems.itemCottonSeeds));
			OreDictionary.registerOre("listAllseed", new ItemStack(FarragoItems.itemCottonSeeds));
			OreDictionary.registerOre("seedCotton", new ItemStack(FarragoItems.itemCottonSeeds));
			OreDictionary.registerOre("cropCotton", new ItemStack(FarragoItems.itemCotton));
		}
	}
}