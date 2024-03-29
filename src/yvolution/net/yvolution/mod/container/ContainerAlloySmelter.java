package net.yvolution.mod.container;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.inventory.Container;
import net.minecraft.inventory.Slot;
import net.yvolution.mod.slot.SlotAlloySmelter;
import net.yvolution.mod.tileentity.TileEntityAlloySmelter;

public class ContainerAlloySmelter extends Container {
	
	private TileEntityAlloySmelter smelter;
	private int dualCookTime;
	private int dualPower;
	private int lastItemBurnTime;
	
	public ContainerAlloySmelter(InventoryPlayer invPlayer, TileEntityAlloySmelter teAlloySmelter){
		dualCookTime = 0;
		dualPower = 0;
		lastItemBurnTime = 0;
		
		smelter = teAlloySmelter;
		
		this.addSlotToContainer(new Slot(teAlloySmelter, 0, 45, 19));
		this.addSlotToContainer(new Slot(teAlloySmelter, 1, 65, 19));
		this.addSlotToContainer(new Slot(teAlloySmelter, 2, 56, 53));
		this.addSlotToContainer(new SlotAlloySmelter(invPlayer.player, teAlloySmelter, 3, 116, 35));
		
		//inventory
		for(int i = 0; i < 3; i++) {
			for(int j = 0; j < 9; j++) {
				this.addSlotToContainer(new Slot(invPlayer, j + i * 9 + 9, 8 + j * 18, 84 + i * 18));
				
			}
		}
		
		
		//hotbar
		for(int i = 0; i < 9; i++) {
			this.addSlotToContainer(new Slot(invPlayer, i, 8 + i * 18, 142));
		}
	}

	@Override
	public boolean canInteractWith(EntityPlayer player) {
		return smelter.isUseableByPlayer(player);
	}

}
