package com.sythiex.farrago.init;

import com.sythiex.farrago.FarragoMod;
import com.sythiex.farrago.network.BuildWandGuiMessage;
import com.sythiex.farrago.network.FarragoMessageHandler;

import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.network.NetworkRegistry;
import net.minecraftforge.fml.common.network.simpleimpl.SimpleNetworkWrapper;
import net.minecraftforge.fml.relauncher.Side;

public class FarragoNetwork
{
	public static SimpleNetworkWrapper networkWrapper;
	
	public static final String CHANNEL_NAME = "FarragoChannel";
	
	public static final byte BUILD_WAND_MESSAGE_ID = 1;
	
	public static void loadNetwork(FMLPreInitializationEvent event)
	{
		FarragoMod.logger.info("Registering Network");
		
		networkWrapper = NetworkRegistry.INSTANCE.newSimpleChannel(CHANNEL_NAME);
		networkWrapper.registerMessage(FarragoMessageHandler.class, BuildWandGuiMessage.class, BUILD_WAND_MESSAGE_ID, Side.SERVER);
	}
}
