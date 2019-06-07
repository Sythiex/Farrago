package com.sythiex.farrago.proxy;

import com.sythiex.farrago.FarragoMod;
import com.sythiex.farrago.block.BlockBlazingLantern;
import com.sythiex.farrago.block.BlockFlowerBlack;
import com.sythiex.farrago.block.BlockInfiniteWater;
import com.sythiex.farrago.init.FarragoBlocks;
import com.sythiex.farrago.init.FarragoConfig;
import com.sythiex.farrago.init.FarragoItems;
import com.sythiex.farrago.item.ItemBatKiller;
import com.sythiex.farrago.item.ItemBuildWand;
import com.sythiex.farrago.item.ItemCotton;
import com.sythiex.farrago.item.ItemCottonSeeds;

import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

public class ClientProxy extends CommonProxy
{
	@Override
	public void preInit(FMLPreInitializationEvent event)
	{
		super.preInit(event);
		
		FarragoMod.logger.info("Loading Item Models");
		
		/////////////////////////////////////////////////////////////////////////////// BLOCKS ///////////////////////////////////////////////////////////////////////////////
		
		if(FarragoConfig.addBlockInfiniteWater)
			ModelLoader.setCustomModelResourceLocation(FarragoBlocks.itemBlockInfiniteWater, 0, new ModelResourceLocation(FarragoMod.MODID + ":" + BlockInfiniteWater.NAME, "inventory"));
		
		if(FarragoConfig.addBlockBlazingLantern)
			ModelLoader.setCustomModelResourceLocation(FarragoBlocks.itemBlockBlazingLantern, 0, new ModelResourceLocation(FarragoMod.MODID + ":" + BlockBlazingLantern.NAME, "inventory"));
		
		if(FarragoConfig.addFlowers)
		{
			ModelLoader.setCustomModelResourceLocation(FarragoBlocks.itemBlockFlowerBlack, 0, new ModelResourceLocation(FarragoMod.MODID + ":" + BlockFlowerBlack.NAME, "inventory"));
		}
		
		/////////////////////////////////////////////////////////////////////////////// ITEMS ///////////////////////////////////////////////////////////////////////////////
		
		if(FarragoConfig.addItemBuildWand)
			ModelLoader.setCustomModelResourceLocation(FarragoItems.itemBuildWand, 0, new ModelResourceLocation(FarragoMod.MODID + ":" + ItemBuildWand.NAME, "inventory"));
		
		if(FarragoConfig.addItemBatKiller)
			ModelLoader.setCustomModelResourceLocation(FarragoItems.itemBatKiller, 0, new ModelResourceLocation(FarragoMod.MODID + ":" + ItemBatKiller.NAME, "inventory"));
		
		if(FarragoConfig.addCotton)
		{
			ModelLoader.setCustomModelResourceLocation(FarragoItems.itemCottonSeeds, 0, new ModelResourceLocation(FarragoMod.MODID + ":" + ItemCottonSeeds.NAME, "inventory"));
			ModelLoader.setCustomModelResourceLocation(FarragoItems.itemCotton, 0, new ModelResourceLocation(FarragoMod.MODID + ":" + ItemCotton.NAME, "inventory"));
		}
	}
	
	public void init(FMLInitializationEvent event)
	{
		super.init(event);
	}
	
	public void postInit(FMLPostInitializationEvent event)
	{
		super.postInit(event);
	}
}