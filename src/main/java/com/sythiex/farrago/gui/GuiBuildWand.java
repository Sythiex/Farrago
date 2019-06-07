package com.sythiex.farrago.gui;

import java.awt.Color;
import java.io.IOException;

import com.sythiex.farrago.FarragoMod;
import com.sythiex.farrago.init.FarragoNetwork;
import com.sythiex.farrago.inventory.ContainerBuildWand;
import com.sythiex.farrago.item.ItemBuildWand.BuildWandShape;
import com.sythiex.farrago.network.BuildWandGuiMessage;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiButton;
import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import net.minecraftforge.items.IItemHandler;

@SideOnly(Side.CLIENT)
public class GuiBuildWand extends GuiContainer
{
	private InventoryPlayer inventoryPlayer;
	private int shapeIndex;
	private boolean isHollow;
	
	public GuiBuildWand(InventoryPlayer inventoryPlayer, IItemHandler itemHandler)
	{
		super(new ContainerBuildWand(inventoryPlayer, itemHandler));
		this.xSize = 176;
		this.ySize = 175;
		this.inventoryPlayer = inventoryPlayer;
	}
	
	@Override
	public void initGui()
	{
		super.initGui();
		
		shapeIndex = inventoryPlayer.getCurrentItem().getTagCompound().getInteger("shape");
		isHollow = inventoryPlayer.getCurrentItem().getTagCompound().getBoolean("isHollow");
		
		this.buttonList.add(new GuiButton(0, this.guiLeft + 45, this.guiTop + 17, 120, 20, BuildWandShape.DISPLAY_NAMES[shapeIndex]));
		this.buttonList.add(new GuiButton(1, this.guiLeft + 45, this.guiTop + 42, 120, 20, isHollow ? "True" : "False"));
		this.buttonList.add(new GuiButton(2, this.guiLeft + 115, this.guiTop + 67, 50, 20, "Reset"));
	}
	
	@Override
	protected void actionPerformed(GuiButton button) throws IOException
	{
		switch(button.id)
		{
		// Shape
		case 0:
			FarragoNetwork.networkWrapper.sendToServer(new BuildWandGuiMessage(button.id));
			
			shapeIndex++;
			if(shapeIndex >= BuildWandShape.values().length)
				shapeIndex = 0;
			button.displayString = BuildWandShape.DISPLAY_NAMES[shapeIndex];
			return;
		// Hollow
		case 1:
			FarragoNetwork.networkWrapper.sendToServer(new BuildWandGuiMessage(button.id));
			
			isHollow = !isHollow;
			button.displayString = isHollow ? "True" : "False";
			return;
		// Reset
		case 2:
			FarragoNetwork.networkWrapper.sendToServer(new BuildWandGuiMessage(button.id));
			return;
		default:
			throw new IOException("Button ID mismatch!");
		}
	}
	
	@Override
	protected void drawGuiContainerBackgroundLayer(float partialTicks, int mouseX, int mouseY)
	{
		Minecraft.getMinecraft().getTextureManager().bindTexture(new ResourceLocation(FarragoMod.MODID, "textures/gui/build_wand_gui.png"));
		GlStateManager.color(1.0F, 1.0F, 1.0F, 1.0F);
		drawTexturedModalRect(guiLeft, guiTop, 0, 0, xSize, ySize);
	}
	
	@Override
	protected void drawGuiContainerForegroundLayer(int mouseX, int mouseY)
	{
		fontRenderer.drawString("Creative Build Wand", 5, 5, Color.darkGray.getRGB());
		fontRenderer.drawString("Shape:", 7, this.buttonList.get(0).y - this.guiTop + 6, Color.black.getRGB());
		fontRenderer.drawString("Hollow:", 7, this.buttonList.get(1).y - this.guiTop + 6, Color.black.getRGB());
		fontRenderer.drawString("Block:", 7, this.buttonList.get(1).y - this.guiTop + 31, Color.black.getRGB());
	}
	
	public InventoryPlayer getInventoryPlayer()
	{
		return this.inventoryPlayer;
	}
}