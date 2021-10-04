package com.sythiex.farrago.tileentity;

import com.sythiex.farrago.block.BlazingLanternBlock;
import com.sythiex.farrago.init.FarragoTileEntities;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.network.NetworkManager;
import net.minecraft.network.play.server.SUpdateTileEntityPacket;
import net.minecraft.tileentity.ITickableTileEntity;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class InvisibleLightTileEntity extends TileEntity implements ITickableTileEntity
{
	private BlockPos lanternPos;
	private int timer = 0;
	private final int TIMER_MAX_VALUE = 60; // update every 3 sec
	
	public InvisibleLightTileEntity()
	{
		super(FarragoTileEntities.invisibleLightTileEntity);
	}
	
	@Override
	public void tick()
	{
		if(!this.hasLevel())
			return;
		World world = this.getLevel();
		if(world.isClientSide)
			return;
		
		if(lanternPos == null)
		{
			world.setBlockAndUpdate(this.getBlockPos(), Blocks.AIR.defaultBlockState());
		}
		else if(timer <= 0)
		{
			timer = TIMER_MAX_VALUE;
			
			Block block = world.getBlockState(lanternPos).getBlock();
			if(!(block instanceof BlazingLanternBlock))
			{
				world.setBlockAndUpdate(this.getBlockPos(), Blocks.AIR.defaultBlockState());
			}
		}
		timer--;
	}
	
	public void setLanternPos(BlockPos pos)
	{
		lanternPos = pos;
	}
	
	public void setTimer(int i)
	{
		timer = i;
	}
	
	@Override
	public CompoundNBT save(CompoundNBT tag)
	{
		super.save(tag);
		tag.putInt("timer", timer);
		
		CompoundNBT lanternPosTag = new CompoundNBT();
		lanternPosTag.putInt("x", lanternPos.getX());
		lanternPosTag.putInt("y", lanternPos.getY());
		lanternPosTag.putInt("z", lanternPos.getZ());
		tag.put("lanternPos", lanternPosTag);
		
		return tag;
	}
	
	@Override
	public void load(BlockState blockState, CompoundNBT tag)
	{
		super.load(blockState, tag);
		
		int i = tag.getInt("timer");
		if(i > TIMER_MAX_VALUE || i < 0)
			i = TIMER_MAX_VALUE;
		timer = i;
		
		CompoundNBT lanternPosTag = tag.getCompound("lanternPos");
		lanternPos = new BlockPos(lanternPosTag.getInt("x"), lanternPosTag.getInt("y"), lanternPosTag.getInt("z"));
	}
	
	@Override
	public SUpdateTileEntityPacket getUpdatePacket()
	{
		CompoundNBT tag = new CompoundNBT();
		save(tag);
		return new SUpdateTileEntityPacket(this.worldPosition, 0, tag);
	}
	
	@Override
	public void onDataPacket(NetworkManager net, SUpdateTileEntityPacket packet)
	{
		load(this.getLevel().getBlockState(this.getBlockPos()), packet.getTag());
	}
	
	@Override
	public CompoundNBT getUpdateTag()
	{
		CompoundNBT tag = new CompoundNBT();
		return save(tag);
	}
	
	@Override
	public void handleUpdateTag(BlockState blockState, CompoundNBT tag)
	{
		load(blockState, tag);
	}
}