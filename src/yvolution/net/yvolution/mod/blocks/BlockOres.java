package net.yvolution.mod.blocks;

import java.util.List;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.IIcon;
import net.yvolution.mod.yvolution;

public class BlockOres extends Block {

	@SideOnly(Side.CLIENT)
	private IIcon[] texture;
	
	final static String[] subBlocks = new String[] {"Copper", "Tin", "Aluminium", "Titanium", "Lead", "Silver", "Zinc", "Osmium", "Tungsten", "Chromium", "Uranium", "Platinum", "Cobalt", "Cadmium", "Nickel", "Manganese", "Bluecrystal", "Yellowcrystal", "Redcrystal", "Orangecrystal", "Purplecrystal", "Greencrystal"};
	
	protected BlockOres() {
		super(Material.rock);
		this.setHardness(3.0F);
		this.setResistance(5.0F);
		this.setCreativeTab(yvolution.tabYvolution);
	}
	
	@SideOnly(Side.CLIENT)
	public void registerBlockIcons(IIconRegister iconRegister){
		texture = new IIcon[subBlocks.length];
		
		for (int i = 0; i < subBlocks.length; i++) {
			texture[i] = iconRegister.registerIcon(yvolution.modid + ":" + subBlocks[i] + "Ore");
		}
	}
	@SideOnly(Side.CLIENT)
	public void getSubBlocks(Item block, CreativeTabs creativeTabs, List list) {
		for (int i = 0; i < subBlocks.length; i++) {
			list.add(new ItemStack(block, 1, i));
		}
	}
	@SideOnly(Side.CLIENT)
	public IIcon getIcon(int side, int meta) {
		return texture[meta];
	}
	public int damageDropped(int meta) {
		return meta;
	}
}
