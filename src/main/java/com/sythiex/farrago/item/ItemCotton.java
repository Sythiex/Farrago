package com.sythiex.farrago.item;

import com.sythiex.farrago.FarragoMod;

import net.minecraft.item.Item;

public class ItemCotton extends Item
{
	public static final String NAME = "item_cotton";
	
	public ItemCotton()
	{
		this.setUnlocalizedName(NAME);
		this.setRegistryName(NAME);
		this.setCreativeTab(FarragoMod.tabFarrago);
	}
}