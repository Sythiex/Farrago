package com.sythiex.farrago.block;

import com.sythiex.farrago.init.FarragoItems;

import net.minecraft.block.BlockCrops;
import net.minecraft.item.Item;

public class BlockCottonCrops extends BlockCrops
{
	public static final String NAME = "block_cotton_crops";
	
	public BlockCottonCrops()
	{
		super();
		this.setUnlocalizedName(NAME);
		this.setRegistryName(NAME);
	}
	
	@Override
	protected Item getSeed()
	{
		return FarragoItems.itemCottonSeeds;
	}
	
	@Override
	protected Item getCrop()
	{
		return FarragoItems.itemCotton;
	}
	
	/*
	 * // manually set growth stage, for debugging
	 * 
	 * @Override
	 * public boolean onBlockActivated(World worldIn, BlockPos pos, IBlockState state, EntityPlayer playerIn, EnumHand hand, EnumFacing facing, float hitX, float hitY, float hitZ)
	 * {
	 * int i = this.getAge(state);
	 * 
	 * if (i < this.getMaxAge())
	 * {
	 * worldIn.setBlockState(pos, this.withAge(i + 1), 2);
	 * }
	 * else
	 * {
	 * worldIn.setBlockState(pos, this.withAge(0), 2);
	 * }
	 * 
	 * return true;
	 * }
	 */
}