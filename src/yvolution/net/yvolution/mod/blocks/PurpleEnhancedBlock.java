package net.yvolution.mod.blocks;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.yvolution.mod.yvolution;

public class PurpleEnhancedBlock extends Block {
	public PurpleEnhancedBlock(Material material) {
		super(material);
		
		this.setHardness(3.0F);
		this.setResistance(8000.0F);
		this.setStepSound(soundTypeStone);
		this.setCreativeTab(yvolution.tabYvolution);
		this.setLightLevel(0.625F);
		this.setLightOpacity(0);
	}
	
	@SideOnly(Side.CLIENT)
	public void registerBlockIcons(IIconRegister iconRegister) {
		this.blockIcon = iconRegister.registerIcon(yvolution.modid + ":" + this.getUnlocalizedName().substring(5));
	}
}