package com.sythiex.farrago;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.sythiex.farrago.init.FarragoConfig;
import com.sythiex.farrago.init.FarragoItems;
import com.sythiex.farrago.proxy.ClientProxy;
import com.sythiex.farrago.proxy.CommonProxy;

import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.fml.DistExecutor;
import net.minecraftforge.fml.ModLoadingContext;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.config.ModConfig;

@Mod(FarragoMod.MODID)
public class FarragoMod
{
	public static final String MODID = "farrago";
	public static final String NAME = "Farrago";
	public static final String VERSION = "0.1.0";
	
	public static CommonProxy proxy = DistExecutor.safeRunForDist(() -> ClientProxy::new, () -> CommonProxy::new);
	
	public static Logger logger = LogManager.getLogger(MODID);
	
	public static ItemGroup farragoItemGroup;
	
	public FarragoMod()
	{
		ModLoadingContext.get().registerConfig(ModConfig.Type.COMMON, FarragoConfig.SPEC);
		
		farragoItemGroup = new ItemGroup("farrago")
		{
			@Override
			@OnlyIn(Dist.CLIENT)
			public ItemStack makeIcon()
			{
				return new ItemStack(FarragoItems.batKillerItem);
			}
		};
	}
}