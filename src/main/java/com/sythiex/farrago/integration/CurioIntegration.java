package com.sythiex.farrago.integration;

import com.sythiex.farrago.FarragoMod;

import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.InterModComms;
import net.minecraftforge.fml.ModList;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.InterModEnqueueEvent;
import top.theillusivec4.curios.api.SlotTypeMessage;
import top.theillusivec4.curios.api.SlotTypePreset;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD)
public class CurioIntegration
{
	@SubscribeEvent
	public static void sendIMC(InterModEnqueueEvent event)
	{
		if(ModList.get().isLoaded("curios"))
		{
			FarragoMod.logger.info("Curios detected, adding integration");
			
			InterModComms.sendTo("curios", SlotTypeMessage.REGISTER_TYPE, () -> SlotTypePreset.RING.getMessageBuilder().size(1).build());
		}
	}
}