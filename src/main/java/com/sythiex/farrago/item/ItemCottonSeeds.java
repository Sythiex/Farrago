package com.sythiex.farrago.item;

import com.sythiex.farrago.FarragoMod;
import com.sythiex.farrago.init.FarragoBlocks;

import net.minecraft.init.Blocks;
import net.minecraft.item.ItemSeeds;

public class ItemCottonSeeds extends ItemSeeds
{
	public static final String NAME = "item_cotton_seeds";
	
	public ItemCottonSeeds()
	{
		super(FarragoBlocks.blockCottonCrops, Blocks.FARMLAND);
		this.setUnlocalizedName(NAME);
		this.setRegistryName(NAME);
		this.setCreativeTab(FarragoMod.tabFarrago);
	}
}