package com.sythiex.farrago.gui;

import com.sythiex.farrago.inventory.ContainerBuildWand;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.world.World;
import net.minecraftforge.fml.common.network.IGuiHandler;
import net.minecraftforge.items.CapabilityItemHandler;

public class FarragoGuiHandler implements IGuiHandler
{
	public static final int GUI_BUILD_WAND_ID = 1;
	
	@Override
	public Object getServerGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z)
	{
		switch(ID)
		{
		case GUI_BUILD_WAND_ID:
			return new ContainerBuildWand(player.inventory, player.getHeldItemMainhand().getCapability(CapabilityItemHandler.ITEM_HANDLER_CAPABILITY, null));
		default:
			return null;
		}
	}
	
	@Override
	public Object getClientGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z)
	{
		switch(ID)
		{
		case GUI_BUILD_WAND_ID:
			return new GuiBuildWand(player.inventory, player.getHeldItemMainhand().getCapability(CapabilityItemHandler.ITEM_HANDLER_CAPABILITY, null));
		default:
			return null;
		}
	}
}