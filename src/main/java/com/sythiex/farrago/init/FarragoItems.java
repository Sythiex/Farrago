package com.sythiex.farrago.init;

import com.sythiex.farrago.FarragoMod;
import com.sythiex.farrago.item.ItemBatKiller;
import com.sythiex.farrago.item.ItemBuildWand;
import com.sythiex.farrago.item.ItemCotton;
import com.sythiex.farrago.item.ItemCottonSeeds;

import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.registry.ForgeRegistries;

public class FarragoItems
{
	public static ItemBuildWand itemBuildWand;
	public static ItemBatKiller itemBatKiller;
	public static ItemCottonSeeds itemCottonSeeds;
	public static ItemCotton itemCotton;
	public static ItemCotton itemDyeBlack;
	
	public static void loadItems(FMLPreInitializationEvent event)
	{
		FarragoMod.logger.info("Registering Items");
		
		itemBuildWand = new ItemBuildWand();
		ForgeRegistries.ITEMS.register(itemBuildWand);
		
		itemBatKiller = new ItemBatKiller();
		ForgeRegistries.ITEMS.register(itemBatKiller);
		
		itemCottonSeeds = new ItemCottonSeeds();
		ForgeRegistries.ITEMS.register(itemCottonSeeds);
		
		itemCotton = new ItemCotton();
		ForgeRegistries.ITEMS.register(itemCotton);
	}
}