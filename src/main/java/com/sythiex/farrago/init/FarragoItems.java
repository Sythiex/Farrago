package com.sythiex.farrago.init;

import com.sythiex.farrago.FarragoMod;
import com.sythiex.farrago.item.ItemBatKiller;
import com.sythiex.farrago.item.ItemBuildWand;
import com.sythiex.farrago.item.ItemCotton;
import com.sythiex.farrago.item.ItemCottonSeeds;

import net.minecraft.item.ItemStack;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.registry.ForgeRegistries;

public class FarragoItems
{
	public static ItemBuildWand itemBuildWand;
	public static ItemBatKiller itemBatKiller;
	public static ItemCottonSeeds itemCottonSeeds;
	public static ItemCotton itemCotton;
	
	public static void loadItems(FMLPreInitializationEvent event)
	{
		FarragoMod.logger.info("Registering Items");
		
		if(FarragoConfig.addItemBuildWand)
		{
			itemBuildWand = new ItemBuildWand();
			ForgeRegistries.ITEMS.register(itemBuildWand);
		}
		else
			FarragoMod.logger.info("Creative Build Wand disabled in config, skipping item registration");
		
		if(FarragoConfig.addItemBatKiller)
		{
			itemBatKiller = new ItemBatKiller();
			ForgeRegistries.ITEMS.register(itemBatKiller);
		}
		else
			FarragoMod.logger.info("Bat-B-Gone disabled in config, skipping item registration");
		
		if(FarragoConfig.addCotton)
		{
			itemCottonSeeds = new ItemCottonSeeds();
			ForgeRegistries.ITEMS.register(itemCottonSeeds);
			
			itemCotton = new ItemCotton();
			ForgeRegistries.ITEMS.register(itemCotton);
			
			MinecraftForge.addGrassSeed(new ItemStack(FarragoItems.itemCottonSeeds), FarragoConfig.cottonSeedDropWeight);
		}
		else
			FarragoMod.logger.info("Cotton Plants disabled in config, skipping item registration");
	}
}