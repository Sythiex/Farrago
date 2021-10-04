package com.sythiex.farrago.block;

import com.sythiex.farrago.tileentity.InvisibleLightTileEntity;

import net.minecraft.block.AirBlock;
import net.minecraft.block.BlockState;
import net.minecraft.block.material.Material;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.IBlockReader;

public class InvisibleLightBlock extends AirBlock
{
	public static final String NAME = "invisible_light";
	
	public InvisibleLightBlock()
	{
		super(Properties.of(Material.AIR).noCollission().noDrops().lightLevel((blockState) ->
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
		return new InvisibleLightTileEntity();
	}
}