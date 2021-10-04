package com.sythiex.farrago.block;

import com.sythiex.farrago.tileentity.BlazingLanternTileEntity;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.IBlockReader;

public class BlazingLanternBlock extends Block
{
	public static final String NAME = "blazing_lantern";
	
	public BlazingLanternBlock()
	{
		super(Properties.of(Material.METAL).sound(SoundType.LANTERN).strength(0.3F).lightLevel((blockState) ->
		{
			return 15;
		}));
		setRegistryName(NAME);
	}
	
	@Override
	public boolean hasTileEntity(BlockState state)
	{
		return true;
	}
	
	@Override
	public TileEntity createTileEntity(BlockState state, IBlockReader world)
	{
		return new BlazingLanternTileEntity();
	}
}