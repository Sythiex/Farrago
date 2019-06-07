package com.sythiex.farrago.block;

import com.sythiex.farrago.tileentity.TileEntityInvisibleLight;

import net.minecraft.block.BlockAir;
import net.minecraft.block.state.IBlockState;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;

public class BlockInvisibleLight extends BlockAir
{
	public static final String NAME = "block_invisible_light";
	
	public BlockInvisibleLight()
	{
		super();
		this.setUnlocalizedName(NAME);
		this.setRegistryName(NAME);
		this.setLightLevel(1.0F);
	}
	
	@Override
	public boolean hasTileEntity(IBlockState state)
	{
		return true;
	}
	
	@Override
	public TileEntity createTileEntity(World world, IBlockState state)
	{
		return new TileEntityInvisibleLight();
	}
	
}