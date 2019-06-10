package com.sythiex.farrago.init;

import com.sythiex.farrago.FarragoMod;
import com.sythiex.farrago.block.BlockBlazingLantern;
import com.sythiex.farrago.block.BlockCottonCrops;
import com.sythiex.farrago.block.BlockFlowerBlack;
import com.sythiex.farrago.block.BlockInfiniteWater;
import com.sythiex.farrago.block.BlockInvisibleLight;
import com.sythiex.farrago.tileentity.TileEntityBlazingLantern;
import com.sythiex.farrago.tileentity.TileEntityInfiniteWater;
import com.sythiex.farrago.tileentity.TileEntityInvisibleLight;

import net.minecraft.item.ItemBlock;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.registry.ForgeRegistries;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class FarragoBlocks
{
	public static BlockInfiniteWater blockInfiniteWater;
	public static BlockBlazingLantern blockBlazingLantern;
	public static BlockInvisibleLight blockInvisibleLight;
	public static BlockCottonCrops blockCottonCrops;
	public static BlockFlowerBlack blockFlowerBlack;
	
	public static ItemBlock itemBlockInfiniteWater;
	public static ItemBlock itemBlockBlazingLantern;
	public static ItemBlock itemBlockFlowerBlack;
	
	public static void loadBlocks(FMLPreInitializationEvent event)
	{
		FarragoMod.logger.info("Registering Blocks");
		
		blockInfiniteWater = new BlockInfiniteWater();
		ForgeRegistries.BLOCKS.register(blockInfiniteWater);
		itemBlockInfiniteWater = new ItemBlock(blockInfiniteWater);
		itemBlockInfiniteWater.setRegistryName(blockInfiniteWater.getRegistryName());
		ForgeRegistries.ITEMS.register(itemBlockInfiniteWater);
		GameRegistry.registerTileEntity(TileEntityInfiniteWater.class, FarragoMod.MODID + ":" + TileEntityInfiniteWater.NAME);
		
		blockBlazingLantern = new BlockBlazingLantern();
		ForgeRegistries.BLOCKS.register(blockBlazingLantern);
		itemBlockBlazingLantern = new ItemBlock(blockBlazingLantern);
		itemBlockBlazingLantern.setRegistryName(blockBlazingLantern.getRegistryName());
		ForgeRegistries.ITEMS.register(itemBlockBlazingLantern);
		GameRegistry.registerTileEntity(TileEntityBlazingLantern.class, FarragoMod.MODID + ":" + TileEntityBlazingLantern.NAME);
		
		blockInvisibleLight = new BlockInvisibleLight();
		ForgeRegistries.BLOCKS.register(blockInvisibleLight);
		GameRegistry.registerTileEntity(TileEntityInvisibleLight.class, FarragoMod.MODID + ":" + TileEntityInvisibleLight.NAME);
		
		blockCottonCrops = new BlockCottonCrops();
		ForgeRegistries.BLOCKS.register(blockCottonCrops);
		
		blockFlowerBlack = new BlockFlowerBlack();
		ForgeRegistries.BLOCKS.register(blockFlowerBlack);
		itemBlockFlowerBlack = new ItemBlock(blockFlowerBlack);
		itemBlockFlowerBlack.setRegistryName(blockFlowerBlack.getRegistryName());
		ForgeRegistries.ITEMS.register(itemBlockFlowerBlack);
	}
}