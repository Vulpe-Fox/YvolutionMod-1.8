package net.yvolution.mod.handler;

import cpw.mods.fml.common.network.IGuiHandler;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;
import net.yvolution.mod.yvolution;
import net.yvolution.mod.container.ContainerAlloySmelter;
import net.yvolution.mod.gui.GuiAlloySmelter;
import net.yvolution.mod.tileentity.TileEntityAlloySmelter;

public class GuiHandler implements IGuiHandler {

	@Override
	public Object getServerGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z) {
		TileEntity entity = world.getTileEntity(x, y, z);
		
		if(entity != null) {
			switch(ID) {
			case yvolution.guiIDAlloySmelter:
				if (entity instanceof TileEntityAlloySmelter) {
					return new ContainerAlloySmelter(player.inventory, (TileEntityAlloySmelter) entity);
				}
			}
		}
		return null;
	}

	@Override
	public Object getClientGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z) {
		TileEntity entity = world.getTileEntity(x, y, z);
		
		if(entity != null) {
			switch(ID) {
			case yvolution.guiIDAlloySmelter:
				if (entity instanceof TileEntityAlloySmelter) {
					return new GuiAlloySmelter(player.inventory, (TileEntityAlloySmelter) entity);
				}
				return null;
			}
		}
		return null;
		
	}

}
