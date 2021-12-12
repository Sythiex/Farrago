package com.sythiex.farrago.init;

import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.RenderTypeLookup;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD)
public class FarragoClient
{
	@SubscribeEvent
	public static void onClientSetupEvent(FMLClientSetupEvent event)
	{
		RenderTypeLookup.setRenderLayer(FarragoBlocks.blazingLanternBlock, FarragoClient::isLayerTranslucent);
	}
	
	public static boolean isLayerTranslucent(RenderType layerToCheck)
	{
		return layerToCheck == RenderType.cutout() || layerToCheck == RenderType.translucent();
	}
}