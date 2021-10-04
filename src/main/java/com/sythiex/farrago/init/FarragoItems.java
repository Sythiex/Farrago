package com.sythiex.farrago.init;

import com.sythiex.farrago.FarragoMod;
import com.sythiex.farrago.block.BlazingLanternBlock;
import com.sythiex.farrago.item.BatKillerItem;

import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD)
public class FarragoItems
{
	public static BatKillerItem batKillerItem;
	
	public static BlockItem blazingLanternBlockItem;
	
	@SubscribeEvent
	public static void registerItems(final RegistryEvent.Register<Item> event)
	{
		FarragoMod.logger.info("Registering items");
		
		batKillerItem = new BatKillerItem();
		event.getRegistry().register(batKillerItem);
		
		blazingLanternBlockItem = (BlockItem) new BlockItem(FarragoBlocks.blazingLanternBlock, new Item.Properties().tab(FarragoMod.farragoItemGroup)).setRegistryName(BlazingLanternBlock.NAME);
		event.getRegistry().register(blazingLanternBlockItem);
	}
}