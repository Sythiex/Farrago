package com.sythiex.farrago.tileentity;

import javax.annotation.Nullable;

import com.sythiex.farrago.block.BlockBlazingLantern;

import net.minecraft.block.Block;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.network.NetworkManager;
import net.minecraft.network.play.server.SPacketUpdateTileEntity;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ITickable;
import net.minecraft.util.math.BlockPos;

public class TileEntityInvisibleLight extends TileEntity implements ITickable
{
	public static final String NAME = "tile_entity_invisible_light";
	
	public BlockPos lanternPos;
	public int timer = 0;
	
	private final int TIMER_MAX_VALUE = 60; // update every 3 sec
	
	@Override
	public void update()
	{
		if(lanternPos == null)
			this.getWorld().setBlockToAir(getPos());
		else if(timer <= 0)
		{
			timer = TIMER_MAX_VALUE;
			
			Block block = this.getWorld().getBlockState(lanternPos).getBlock();
			if(!(block instanceof BlockBlazingLantern))
			{
				this.getWorld().setBlockToAir(getPos());
			}
		}
		timer--;
	}
	
	@Override
	public NBTTagCompound getUpdateTag()
	{
		return writeToNBT(new NBTTagCompound());
	}
	
	@Nullable
	@Override
	public SPacketUpdateTileEntity getUpdatePacket()
	{
		return new SPacketUpdateTileEntity(getPos(), 0, getUpdateTag());
	}
	
	@Override
	public void onDataPacket(NetworkManager net, SPacketUpdateTileEntity pkt)
	{
		readFromNBT(pkt.getNbtCompound());
	}
}