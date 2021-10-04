package com.sythiex.farrago.tileentity;

import com.sythiex.farrago.FarragoMod;
import com.sythiex.farrago.init.FarragoBlocks;
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

public class BlazingLanternTileEntity extends TileEntity implements ITickableTileEntity
{
	private int timer = 0;
	private final int TIMER_MAX_VALUE = 40;// 200; // update every 10 sec
	
	public BlazingLanternTileEntity()
	{
		super(FarragoTileEntities.blazingLanternTileEntity);
	}
	
	@Override
	public void tick()
	{
		if(!this.hasLevel())
			return;
		World world = this.getLevel();
		if(world.isClientSide)
			return;
		
		if(timer <= 0)
		{
			timer = TIMER_MAX_VALUE;
			int count = 0; // used to offset InvisibleLightTileEntity update timer
			
			for(int i = -9; i <= 9; i++)
			{
				for(int j = -9; j <= 9; j++)
				{
					for(int k = -9; k <= 9; k++)
					{
						if((i % 3 == 0) && (j % 3 == 0) && (k % 3 == 0) && !(i == 0 && j == 0 && k == 0))
						{
							BlockPos currentPos = this.getBlockPos().offset(i, j, k);
							Block blockToReplace = world.getBlockState(currentPos).getBlock();
							
							if(blockToReplace == Blocks.AIR)
							{
								// testing seed: -576398854975003031

								world.setBlockAndUpdate(currentPos, FarragoBlocks.invisibleLightBlock.defaultBlockState());
								InvisibleLightTileEntity lightTE = (InvisibleLightTileEntity) world.getBlockEntity(currentPos);
								if(lightTE != null)
								{
									lightTE.setLanternPos(this.getBlockPos());
									lightTE.setTimer(count % 60);
									count++;
								}
								else
								{
									FarragoMod.logger.error("Tile entity at " + currentPos.toString() + " should be " + InvisibleLightTileEntity.class.toString() + " but is " + world.getBlockEntity(currentPos).toString());
									System.out.println("lightTE is NULL, " + "currentPos: " + currentPos.toString() + ", block class: " + blockToReplace.getClass());
								}
							}
						}
					}
				}
			}
		}
		timer--;
	}
	
	@Override
	public CompoundNBT save(CompoundNBT tag)
	{
		super.save(tag);
		tag.putInt("timer", timer);
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