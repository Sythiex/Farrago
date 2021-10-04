package com.sythiex.farrago.item;

import java.util.List;

import com.sythiex.farrago.FarragoMod;

import net.minecraft.entity.Entity;
import net.minecraft.entity.passive.BatEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.world.World;

public class BatKillerItem extends Item
{
	public static final String NAME = "bat_killer";
	public static final int RADIUS = 10;
	
	private int timer = 0;
	
	public BatKillerItem()
	{
		super(new Item.Properties().stacksTo(1).tab(FarragoMod.farragoItemGroup));
		setRegistryName(NAME);
	}
	
	@Override
	public void inventoryTick(ItemStack itemStack, World world, Entity entity, int itemSlot, boolean isSelected)
	{
		if(world.isClientSide)
			return;
		
		timer++;
		if(timer >= 20)
		{
			timer = 0;
			List<BatEntity> listBats = world.getEntitiesOfClass(BatEntity.class, new AxisAlignedBB(entity.getX() - RADIUS, entity.getY() - RADIUS, entity.getZ() - RADIUS, entity.getX() + RADIUS, entity.getY() + RADIUS, entity.getZ() + RADIUS));
			for(BatEntity bat : listBats)
			{
				bat.setSecondsOnFire(420);
			}
		}
	}
}