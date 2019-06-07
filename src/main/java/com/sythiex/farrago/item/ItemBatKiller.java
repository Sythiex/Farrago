package com.sythiex.farrago.item;

import java.util.List;

import com.sythiex.farrago.FarragoMod;

import baubles.api.BaubleType;
import baubles.api.IBauble;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.passive.EntityBat;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.world.World;
import net.minecraftforge.fml.common.Optional;

@Optional.Interface(iface = "baubles.api.IBauble", modid = "baubles", striprefs = true)
public class ItemBatKiller extends Item implements IBauble
{
	public static final String NAME = "item_bat_killer";
	public static final int RADIUS = 10;
	
	private int timer = 0;
	
	public ItemBatKiller()
	{
		this.setUnlocalizedName(NAME);
		this.setRegistryName(NAME);
		this.setCreativeTab(FarragoMod.tabFarrago);
		this.setMaxStackSize(1);
	}
	
	@Override
	public void onUpdate(ItemStack itemStack, World world, Entity entity, int itemSlot, boolean isSelected)
	{
		if(!world.isRemote)
		{
			timer++;
			if(timer >= 20)
			{
				timer = 0;
				List<EntityBat> listBats = world.getEntitiesWithinAABB(EntityBat.class, new AxisAlignedBB(entity.posX - RADIUS, entity.posY - RADIUS, entity.posZ - RADIUS, entity.posX + RADIUS, entity.posY + RADIUS, entity.posZ + RADIUS));
				for(EntityBat bat : listBats)
				{
					bat.setFire(420);
				}
			}
		}
	}
	
	@Optional.Method(modid = "baubles")
	@Override
	public BaubleType getBaubleType(ItemStack stack)
	{
		return BaubleType.TRINKET;
	}
	
	@Optional.Method(modid = "baubles")
	@Override
	public void onWornTick(ItemStack itemstack, EntityLivingBase player)
	{
		onUpdate(itemstack, player.world, player, 0, false);
	}
	
	@Optional.Method(modid = "baubles")
	@Override
	public void onUnequipped(ItemStack itemstack, EntityLivingBase player)
	{
	}
	
	@Optional.Method(modid = "baubles")
	@Override
	public boolean canEquip(ItemStack itemstack, EntityLivingBase player)
	{
		return true;
	}
	
	@Optional.Method(modid = "baubles")
	@Override
	public boolean canUnequip(ItemStack itemstack, EntityLivingBase player)
	{
		return true;
	}
}
