package com.sythiex.farrago.init;

import net.minecraftforge.common.ForgeConfigSpec;
import net.minecraftforge.common.ForgeConfigSpec.BooleanValue;

public class FarragoConfig
{
	public static final ForgeConfigSpec.Builder BUILDER = new ForgeConfigSpec.Builder();
	public static final ForgeConfigSpec SPEC = BUILDER.build();
	
	// public static final BooleanValue enableBatKiller;
	
	static
	{
		BUILDER.push("ENABLE FEATURES");
		// enableBatKiller = BUILDER.define("Bat-B-Gone Enabled", true);
		BUILDER.pop();
	}
}