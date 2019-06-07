package com.sythiex.farrago.tileentity;

import javax.annotation.Nullable;

import com.sythiex.farrago.block.BlockBlazingLantern;
import com.sythiex.farrago.init.FarragoBlocks;

import net.minecraft.block.Block;
import net.minecraft.block.state.IBlockState;
import net.minecraft.init.Blocks;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.network.NetworkManager;
import net.minecraft.network.play.server.SPacketUpdateTileEntity;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ITickable;
import net.minecraft.util.math.BlockPos;

public class TileEntityBlazingLantern extends TileEntity implements ITickable
{
	public static final String NAME = "tile_entity_blazing_lantern";
	
	private int timer = 0;
	private final int TIMER_MAX_VALUE = 200; // update every 10 sec
	
	@Override
	public void update()
	{
		if(timer <= 0 && this.getWorld().getBlockState(this.getPos()).getBlock() instanceof BlockBlazingLantern)
		{
			timer = TIMER_MAX_VALUE;
			int count = 0; // used to offset update timer
			
			for(int i = -9; i <= 9; i++)
			{
				for(int j = -9; j <= 9; j++)
				{
					for(int k = -9; k <= 9; k++)
					{
						if((i % 3 == 0) && (j % 3 == 0) && (k % 3 == 0) && !(i == 0 && j == 0 && k == 0))
						{
							BlockPos lightPos = this.getPos().add(i, j, k);
							IBlockState blockStateToReplace = this.getWorld().getBlockState(lightPos);
							Block blockToReplace = blockStateToReplace.getBlock();
							if(blockToReplace == Blocks.AIR && world.isValid(lightPos))
							{
								this.getWorld().setBlockState(lightPos, FarragoBlocks.blockInvisibleLight.getDefaultState());
								TileEntityInvisibleLight lightTE = (TileEntityInvisibleLight) this.getWorld().getTileEntity(lightPos);
								lightTE.lanternPos = this.getPos();
								lightTE.timer = count % 60;
								count++;
							}
						}
					}
				}
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