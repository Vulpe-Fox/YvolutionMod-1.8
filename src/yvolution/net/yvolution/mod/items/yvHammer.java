package net.yvolution.mod.items;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.item.Item;
import net.yvolution.mod.yvolution;

public class yvHammer extends Item {
	
	public yvHammer() {
		super();
		this.maxStackSize = 1;
		this.setMaxDamage(87);
		this.setNoRepair();
		this.setCreativeTab(yvolution.tabYvolutionMaterials);
	}
	
	@SideOnly(Side.CLIENT)
	public void registerIcons(IIconRegister iconRegister) {
		this.itemIcon = iconRegister.registerIcon(yvolution.modid + ":" + this.getUnlocalizedName().substring(5));
	}

}
