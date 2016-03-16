package net.yvolution.mod.tileentity;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.IInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;

public class TileEntityAlloySmelter extends TileEntity implements IInventory {
	
	private ItemStack slots[];
	
	public int dualPower;
	public int dualCookTime;
	
	private String customName;
	
	public TileEntityAlloySmelter() {
		slots = new ItemStack[4];
	}
	
	@Override
	public int getSizeInventory() {
		// TODO Auto-generated method stub
		return 0;
	}
	@Override
	public ItemStack getStackInSlot(int p_70301_1_) {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public ItemStack decrStackSize(int p_70298_1_, int p_70298_2_) {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public ItemStack getStackInSlotOnClosing(int p_70304_1_) {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public void setInventorySlotContents(int p_70299_1_, ItemStack p_70299_2_) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public String getInventoryName() {
		return this.hasCustomInventoryName() ? this.customName : "container.alloysmelter";
	}
	@Override
	public boolean hasCustomInventoryName() {
		return this.customName != null && this.customName.length() > 0;
	}
	
	public void setGuiDisplayName (String name) {
		this.customName = name;
	}
	
	@Override
	public int getInventoryStackLimit() {
		// TODO Auto-generated method stub
		return 0;
	}
	@Override
	public boolean isUseableByPlayer(EntityPlayer player) {
	 return this.worldObj.getTileEntity(this.xCoord, this.yCoord, this.zCoord) != this ? false : player.getDistanceSq((double)this.xCoord + 0.5D, (double)this.yCoord + 0.5D, (double)this.zCoord + 0.5D) <= 64.0D;
	}
	@Override
	public void openInventory() {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void closeInventory() {
		// TODO Auto-generated method stub
		
	}
	@Override
	public boolean isItemValidForSlot(int p_94041_1_, ItemStack p_94041_2_) {
		// TODO Auto-generated method stub
		return false;
	}

}
