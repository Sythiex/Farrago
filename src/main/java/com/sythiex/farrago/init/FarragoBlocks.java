package com.sythiex.farrago.init;

import com.sythiex.farrago.FarragoMod;
import com.sythiex.farrago.block.BlazingLanternBlock;
import com.sythiex.farrago.block.InvisibleLightBlock;

import net.minecraft.block.Block;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD)
public class FarragoBlocks
{
	public static BlazingLanternBlock blazingLanternBlock;
	public static InvisibleLightBlock invisibleLightBlock;
	
	@SubscribeEvent
	public static void registerBlocks(final RegistryEvent.Register<Block> event)
	{
		FarragoMod.logger.info("Registering blocks");
		
		blazingLanternBlock = new BlazingLanternBlock();
		event.getRegistry().register(blazingLanternBlock);
		
		invisibleLightBlock = new InvisibleLightBlock();
		event.getRegistry().register(invisibleLightBlock);
	}
}
