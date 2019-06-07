package com.sythiex.farrago.block;

import com.sythiex.farrago.FarragoMod;

import net.minecraft.block.Block;
import net.minecraft.block.BlockBush;
import net.minecraft.block.state.IBlockState;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;

public class BlockFlowerFarrago extends BlockBush
{
	public BlockFlowerFarrago(String name)
	{
		super();
		this.setUnlocalizedName(name);
		this.setRegistryName(name);
		this.setCreativeTab(FarragoMod.tabFarrago);
	}
	
	@Override
	public AxisAlignedBB getBoundingBox(IBlockState state, IBlockAccess source, BlockPos pos)
	{
		return super.getBoundingBox(state, source, pos).offset(state.getOffset(source, pos));
	}
	
	@Override
	public Block.EnumOffsetType getOffsetType()
	{
		return Block.EnumOffsetType.XZ;
	}
}