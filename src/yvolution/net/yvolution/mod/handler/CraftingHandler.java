package net.yvolution.mod.handler;

import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import cpw.mods.fml.common.gameevent.PlayerEvent.ItemCraftedEvent;
import net.minecraft.inventory.IInventory;
import net.minecraft.item.ItemStack;
import net.yvolution.mod.yvolution;

public class CraftingHandler {
	
	@SubscribeEvent
	public void onCrafting(ItemCraftedEvent event) {
		
		final IInventory craftMatrix = null;
		for(int i = 0; i < event.craftMatrix.getSizeInventory(); i++) {
			if (event.craftMatrix.getStackInSlot(i) != null) {
				
				ItemStack item0 = event.craftMatrix.getStackInSlot(i);
					if (item0 != null && item0.getItem() == yvolution.itemHammer) {
						ItemStack k = new ItemStack(yvolution.itemHammer, 2, (item0.getItemDamage() + 1));
						
						if (k.getItemDamage() >= k.getMaxDamage()) {
							k.stackSize--;
							
							
						}
						event.craftMatrix.setInventorySlotContents(i,  k);
					}
					
					ItemStack item1 = event.craftMatrix.getStackInSlot(i);
					if (item0 != null && item0.getItem() == yvolution.itemMetalCutter) {
						ItemStack k = new ItemStack(yvolution.itemMetalCutter, 2, (item0.getItemDamage() + 1));
						
						if (k.getItemDamage() >= k.getMaxDamage()) {
							k.stackSize--;
							
							
						}
						event.craftMatrix.setInventorySlotContents(i,  k);
					}
			}
		}
		
		
		
		
	}

}
