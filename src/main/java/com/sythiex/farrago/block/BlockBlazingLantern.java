package com.sythiex.farrago.block;

import com.sythiex.farrago.FarragoMod;
import com.sythiex.farrago.tileentity.TileEntityBlazingLantern;

import net.minecraft.block.Block;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.BlockRenderLayer;
import net.minecraft.util.EnumBlockRenderType;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

// Better texture
public class BlockBlazingLantern extends Block
{
	public static final String NAME = "block_blazing_lantern";
	
	public BlockBlazingLantern()
	{
		super(Material.GLASS);
		this.setUnlocalizedName(NAME);
		this.setRegistryName(NAME);
		this.setCreativeTab(FarragoMod.tabFarrago);
		this.setLightLevel(1.0F);
		this.setSoundType(SoundType.GLASS);
		this.setHardness(0.3F);
	}
	
	@Override
	public boolean hasTileEntity(IBlockState state)
	{
		return true;
	}
	
	@Override
	public TileEntity createTileEntity(World world, IBlockState state)
	{
		return new TileEntityBlazingLantern();
	}
	
	@SideOnly(Side.CLIENT)
	public BlockRenderLayer getBlockLayer()
	{
		return BlockRenderLayer.TRANSLUCENT;
	}
	
	@Override
	public boolean isOpaqueCube(IBlockState state)
	{
		return false;
	}
	
	@Override
	public boolean isFullCube(IBlockState state)
	{
		return false;
	}
	
	@Override
	public EnumBlockRenderType getRenderType(IBlockState iBlockState)
	{
		return EnumBlockRenderType.MODEL;
	}
}