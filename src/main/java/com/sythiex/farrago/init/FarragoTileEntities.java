package com.sythiex.farrago.init;

import com.sythiex.farrago.block.BlazingLanternBlock;
import com.sythiex.farrago.block.InvisibleLightBlock;
import com.sythiex.farrago.tileentity.BlazingLanternTileEntity;
import com.sythiex.farrago.tileentity.InvisibleLightTileEntity;

import net.minecraft.tileentity.TileEntityType;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD)
public class FarragoTileEntities
{
	public static TileEntityType<BlazingLanternTileEntity> blazingLanternTileEntity;
	public static TileEntityType<InvisibleLightTileEntity> invisibleLightTileEntity;
	
	@SubscribeEvent
	public static void registerTileEntities(final RegistryEvent.Register<TileEntityType<?>> event)
	{
		blazingLanternTileEntity = (TileEntityType<BlazingLanternTileEntity>) TileEntityType.Builder.of(BlazingLanternTileEntity::new, FarragoBlocks.blazingLanternBlock).build(null).setRegistryName(BlazingLanternBlock.NAME);
		event.getRegistry().register(blazingLanternTileEntity);
		
		invisibleLightTileEntity = (TileEntityType<InvisibleLightTileEntity>) TileEntityType.Builder.of(InvisibleLightTileEntity::new, FarragoBlocks.invisibleLightBlock).build(null).setRegistryName(InvisibleLightBlock.NAME);
		event.getRegistry().register(invisibleLightTileEntity);
	}
}