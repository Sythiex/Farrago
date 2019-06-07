package com.sythiex.farrago.world;

import java.util.Random;

import com.sythiex.farrago.init.FarragoBlocks;

import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.gen.feature.WorldGenerator;

public class WorldGenFlowersFarrago extends WorldGenerator
{
	public WorldGenFlowersFarrago()
	{
	}
	
	public boolean generate(World worldIn, Random rand, BlockPos position)
	{
		for(int i = 0; i < 64; ++i)
		{
			BlockPos blockpos = position.add(rand.nextInt(8) - rand.nextInt(8), rand.nextInt(4) - rand.nextInt(4), rand.nextInt(8) - rand.nextInt(8));
			
			if(worldIn.isAirBlock(blockpos) && (!worldIn.provider.isNether() || blockpos.getY() < 255) && FarragoBlocks.blockFlowerBlack.canBlockStay(worldIn, blockpos, FarragoBlocks.blockFlowerBlack.getDefaultState()))
			{
				worldIn.setBlockState(blockpos, FarragoBlocks.blockFlowerBlack.getDefaultState(), 2);
			}
		}
		return true;
	}
}