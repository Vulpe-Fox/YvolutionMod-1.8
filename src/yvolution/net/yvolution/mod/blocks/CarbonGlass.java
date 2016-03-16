package net.yvolution.mod.blocks;

import java.util.Random;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.yvolution.mod.yvolution;

public class CarbonGlass extends Block {
	public CarbonGlass(Material material) {
		super(material);
		
		this.setHardness(3.0F);
		this.setResistance(1.0F);
		this.setStepSound(soundTypeGlass);
		this.setCreativeTab(yvolution.tabYvolution);
		this.setLightLevel(0.625F);
		this.setLightOpacity(0);
	}
	
	@SideOnly(Side.CLIENT)
	public void registerBlockIcons(IIconRegister iconRegister) {
		this.blockIcon = iconRegister.registerIcon(yvolution.modid + ":" + this.getUnlocalizedName().substring(5));
	}
	public int quantityDropped(Random p_149745_1_)
    {
        return 0;
    }
	public int getRenderBlockPass()
	    {
	        return 0;
	    }
	public boolean renderAsNormalBlock()
    {
        return false;
    }
	protected boolean canSilkHarvest()
    {
        return true;
    }
}