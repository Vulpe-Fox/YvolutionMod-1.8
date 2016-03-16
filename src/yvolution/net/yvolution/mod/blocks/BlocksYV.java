package net.yvolution.mod.blocks;

import static net.yvolution.mod.blocks.BlockDecYV.*;

import cpw.mods.fml.common.registry.GameRegistry;
import net.yvolution.mod.itemblocks.ItemBlockOres;
public class BlocksYV {
	
	public static void init() {
		registerBlocks();
	}

	public static void registerBlocks() {
		blockOres = new BlockOres().setBlockName("BlockOres");
		GameRegistry.registerBlock(blockOres, ItemBlockOres.class, "blockOres");
	}
}
