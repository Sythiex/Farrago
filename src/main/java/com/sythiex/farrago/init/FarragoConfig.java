package com.sythiex.farrago.init;

import net.minecraftforge.common.ForgeConfigSpec;

public class FarragoConfig
{
	public static final ForgeConfigSpec.Builder BUILDER = new ForgeConfigSpec.Builder();
	public static final ForgeConfigSpec SPEC = BUILDER.build();
	
	static
	{
		BUILDER.push("General");
		
		BUILDER.pop();
	}
}