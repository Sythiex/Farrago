package com.sythiex.farrago.inventory;

import javax.annotation.Nonnull;

import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;
import net.minecraftforge.items.IItemHandler;
import net.minecraftforge.items.SlotItemHandler;

public class SlotItemHandlerBlocksOnly extends SlotItemHandler
{
	/**
	 * As {@link SlotItemHandler}, but only allows ItemBlocks
	 * 
	 * @param itemHandler
	 * @param index
	 * @param xPosition
	 * @param yPosition
	 */
	public SlotItemHandlerBlocksOnly(IItemHandler itemHandler, int index, int xPosition, int yPosition)
	{
		super(itemHandler, index, xPosition, yPosition);
	}
	
	@Override
	public boolean isItemValid(@Nonnull ItemStack stack)
	{
		return stack.getItem() instanceof ItemBlock ? super.isItemValid(stack) : false;
	}
}