package com.sythiex.farrago.event;

import com.sythiex.farrago.FarragoMod;
import com.sythiex.farrago.init.FarragoConfig;
import com.sythiex.farrago.world.GenLayerLargeRivers;
import com.sythiex.farrago.world.WorldGenFlowersFarrago;

import net.minecraft.util.math.BlockPos;
import net.minecraft.world.WorldType;
import net.minecraftforge.event.terraingen.DecorateBiomeEvent.Decorate;
import net.minecraftforge.event.terraingen.DecorateBiomeEvent.Decorate.EventType;
import net.minecraftforge.event.terraingen.WorldTypeEvent.InitBiomeGens;
import net.minecraftforge.fml.common.eventhandler.EventPriority;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

public class FarragoTerrainGenHandler
{
	WorldGenFlowersFarrago worldGenFlowersFarrago = new WorldGenFlowersFarrago();
	
	@SubscribeEvent(priority = EventPriority.NORMAL)
	public void onInitBiomeGensEvent(InitBiomeGens event)
	{
		if(FarragoConfig.enableLargeRivers)
		{
			System.out.println(event.getWorldType() == WorldType.DEFAULT);
			if(event.getWorldType() == WorldType.DEFAULT)
			{
				FarragoMod.logger.info("Using large river biome generators");
				event.setNewBiomeGens(GenLayerLargeRivers.initializeAllBiomeGenerators(event.getSeed(), event.getWorldType(), null));
			}
		}
	}
	
	@SubscribeEvent(priority = EventPriority.NORMAL, receiveCanceled = false)
	public void onDecorateEvent(Decorate event)
	{
		if(event.getType() == EventType.FLOWERS)
		{
			int xRand = event.getRand().nextInt(16) + 8;
			int zRand = event.getRand().nextInt(16) + 8;
			BlockPos chunkPos = new BlockPos(event.getChunkPos().getXStart(), 0, event.getChunkPos().getZStart());
			int yRange = event.getWorld().getHeight(chunkPos.add(xRand, 0, zRand)).getY() + 32;
			
			if(yRange > 0)
			{
				int yRand = event.getRand().nextInt(yRange);
				BlockPos placementPos = chunkPos.add(xRand, yRand, zRand);
				worldGenFlowersFarrago.generate(event.getWorld(), event.getRand(), placementPos);
			}
		}
	}
}