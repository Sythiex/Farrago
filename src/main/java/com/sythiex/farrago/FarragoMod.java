package com.sythiex.farrago;

import org.apache.logging.log4j.Logger;

import com.sythiex.farrago.event.FarragoTerrainGenHandler;
import com.sythiex.farrago.gui.FarragoGuiHandler;
import com.sythiex.farrago.init.FarragoBlocks;
import com.sythiex.farrago.init.FarragoConfig;
import com.sythiex.farrago.init.FarragoItems;
import com.sythiex.farrago.init.FarragoNetwork;
import com.sythiex.farrago.init.FarragoRecipes;
import com.sythiex.farrago.proxy.CommonProxy;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemStack;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.Mod.Instance;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.network.NetworkRegistry;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

@Mod(modid = FarragoMod.MODID, name = FarragoMod.NAME, version = FarragoMod.VERSION, acceptedMinecraftVersions = "[1.12.2]", dependencies = "after:baubles")
public class FarragoMod
{
	@SidedProxy(clientSide = "com.sythiex.farrago.proxy.ClientProxy", serverSide = "com.sythiex.farrago.proxy.CommonProxy")
	public static CommonProxy proxy;
	
	public static final String MODID = "farrago";
	public static final String NAME = "Farrago";
	public static final String VERSION = "0.1.0";
	
	@Instance(MODID)
	public static FarragoMod instance;
	
	public static Logger logger;
	
	public static CreativeTabs tabFarrago;
	
	@EventHandler
	public void preInit(FMLPreInitializationEvent event)
	{
		logger = event.getModLog();
		logger.info("Preinitializing");
		
		tabFarrago = new CreativeTabs("tab_farrago")
		{
			@Override
			@SideOnly(Side.CLIENT)
			public ItemStack getTabIconItem()
			{
				return new ItemStack(FarragoBlocks.blockInfiniteWater);
			}
		};
		
		FarragoConfig.loadConfig(event);
		FarragoBlocks.loadBlocks(event);
		FarragoItems.loadItems(event);
		FarragoNetwork.loadNetwork(event);
		
		NetworkRegistry.INSTANCE.registerGuiHandler(FarragoMod.instance, new FarragoGuiHandler());
		
		MinecraftForge.TERRAIN_GEN_BUS.register(new FarragoTerrainGenHandler());
		
		proxy.preInit(event);
	}
	
	@EventHandler
	public void init(FMLInitializationEvent event)
	{
		logger.info("Initializing");
		
		FarragoRecipes.loadRecipes(event);
		
		proxy.init(event);
	}
	
	@EventHandler
	public void postInit(FMLPostInitializationEvent event)
	{
		logger.info("Postinitializing");
		
		proxy.postInit(event);
	}
}