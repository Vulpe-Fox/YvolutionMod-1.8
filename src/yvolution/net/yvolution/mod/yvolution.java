package net.yvolution.mod;



import cpw.mods.fml.common.FMLCommonHandler;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.network.NetworkRegistry;
import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraftforge.oredict.OreDictionary;
import net.yvolution.mod.blocks.AlloySmelter;
import net.yvolution.mod.blocks.AluminiumOre;
import net.yvolution.mod.blocks.BlocksYV;
import net.yvolution.mod.blocks.BlueEnhancedBlock;
import net.yvolution.mod.blocks.BlueOctoidBlock;
import net.yvolution.mod.blocks.BluecrystalOre;
import net.yvolution.mod.blocks.CadmiumOre;
import net.yvolution.mod.blocks.CarbonGlass;
import net.yvolution.mod.blocks.CarbonSand;
import net.yvolution.mod.blocks.ChromiumOre;
import net.yvolution.mod.blocks.CobaltOre;
import net.yvolution.mod.blocks.CopperOre;
import net.yvolution.mod.blocks.GreenEnhancedBlock;
import net.yvolution.mod.blocks.GreenOctoidBlock;
import net.yvolution.mod.blocks.GreencrystalOre;
import net.yvolution.mod.blocks.LeadOre;
import net.yvolution.mod.blocks.ManganeseOre;
import net.yvolution.mod.blocks.NickelOre;
import net.yvolution.mod.blocks.OrangeEnhancedBlock;
import net.yvolution.mod.blocks.OrangeOctoidBlock;
import net.yvolution.mod.blocks.OrangecrystalOre;
import net.yvolution.mod.blocks.OsmiumOre;
import net.yvolution.mod.blocks.PlatinumOre;
import net.yvolution.mod.blocks.PurpleEnhancedBlock;
import net.yvolution.mod.blocks.PurpleOctoidBlock;
import net.yvolution.mod.blocks.PurplecrystalOre;
import net.yvolution.mod.blocks.RedComplexBlock;
import net.yvolution.mod.blocks.RedEnhancedBlock;
import net.yvolution.mod.blocks.RedOctoidBlock;
import net.yvolution.mod.blocks.RedcrystalOre;
import net.yvolution.mod.blocks.SilverOre;
import net.yvolution.mod.blocks.TinOre;
import net.yvolution.mod.blocks.TitaniumOre;
import net.yvolution.mod.blocks.TungstenOre;
import net.yvolution.mod.blocks.UraniumOre;
import net.yvolution.mod.blocks.YellowComplexBlock;
import net.yvolution.mod.blocks.YellowEnhancedBlock;
import net.yvolution.mod.blocks.YellowOctoidBlock;
import net.yvolution.mod.blocks.YellowcrystalOre;
import net.yvolution.mod.blocks.ZincOre;
import net.yvolution.mod.handler.CraftingHandler;
import net.yvolution.mod.handler.GuiHandler;
import net.yvolution.mod.items.yvHammer;
import net.yvolution.mod.items.yvItems;
import net.yvolution.mod.tileentity.TileEntityAlloySmelter;
import net.yvolution.mod.worldgen.YVWorldGen;

@Mod(modid = yvolution.modid, version = yvolution.version)
public class yvolution {

	public static final String modid = "yvolution";
	public static final String version = "v0.06";
	
	YVWorldGen eventWorldGen = new YVWorldGen();
	
	public static CreativeTabs tabYvolution = new CreativeTabs("Yvolution") {
		@SideOnly(Side.CLIENT)
		public Item getTabIconItem() {
			return Item.getItemFromBlock(yvolution.blockGreenOctoidBlock);
		}
	};
	
	public static CreativeTabs tabYvolutionMaterials = new CreativeTabs("Yvolution Materials") {
		@SideOnly(Side.CLIENT)
		public Item getTabIconItem() {
			return yvolution.itemBronzeGear;
		}
	};
	//ores
	public static Block oreCopperOre;
	public static Block oreTinOre;
	public static Block oreAluminiumOre;
	public static Block oreTitaniumOre;
	public static Block oreLeadOre;
	public static Block oreSilverOre;
	public static Block oreZincOre;
	public static Block oreOsmiumOre;
	public static Block oreTungstenOre;
	public static Block oreChromiumOre;
	public static Block oreUraniumOre;
	public static Block orePlatinumOre;
	public static Block oreCobaltOre;
	public static Block oreCadmiumOre;
	public static Block oreNickelOre;
	public static Block oreManganeseOre;
	public static Block oreBluecrystalOre;
	public static Block oreYellowcrystalOre;
	public static Block oreRedcrystalOre;
	public static Block oreOrangecrystalOre;
	public static Block orePurplecrystalOre;
	public static Block oreGreencrystalOre;
	public static Block blockYellowOctoidBlock;
	public static Block blockBlueOctoidBlock;
	public static Block blockRedOctoidBlock;
	public static Block blockPurpleOctoidBlock;
	public static Block blockOrangeOctoidBlock;
	public static Block blockGreenOctoidBlock;
	public static Block blockYellowComplexBlock;
	public static Block blockRedComplexBlock;
	public static Block blockYellowEnhancedBlock;
	public static Block blockRedEnhancedBlock;
	public static Block blockBlueEnhancedBlock;
	public static Block blockGreenEnhancedBlock;
	public static Block blockPurpleEnhancedBlock;
	public static Block blockOrangeEnhancedBlock;
	public static Block blockCarbonGlass;
	public static Block blockCarbonSand;
	//Transition Metals, Rare Earth Metals, and Other Metals|Done Textures
	public static Item itemCopperIngot;
	public static Item itemTinIngot;
	public static Item itemAluminiumIngot;
	public static Item itemTitaniumIngot;
	public static Item itemLeadIngot;
	public static Item itemSilverIngot;
	public static Item itemZincIngot;
	public static Item itemOsmiumIngot;
	public static Item itemTungstenIngot;
	public static Item itemChromiumIngot;
	public static Item itemPureUraniumIngot;
	public static Item itemPlatinumIngot;
	public static Item itemCobaltIngot;
	public static Item itemCadmiumIngot;
	public static Item itemNickelIngot;
	public static Item itemManganeseIngot;
	public static Item itemDepletedUraniumIngot;
	//Alloys
	public static Item itemBrassIngot;//copper and zinc
	public static Item itemBronzeIngot;//tin and copper
	public static Item itemDuraluminIngot;//copper and aluminium
	public static Item itemNichromeIngot;//Chromium and nickel
	public static Item itemStelliteIngot;//Chromium, Cobalt, Tungsten, and carbon(coal/charcoal)
	public static Item itemElectrumIngot;//Gold, silver, and copper
	public static Item itemStirlingsilverIngot;//copper and silver
	public static Item itemStaballoyIngot;//depleted uranium and titanium (stainless Steel)
	public static Item itemUltaniumIngot;//All alloys together+one diamond
	//misc
	public static Item itemUnrefinedUranium;
	public static Item itemBlueCrystal;
	public static Item itemYellowCrystal;
	public static Item itemRedCrystal;
	public static Item itemOrangeCrystal;
	public static Item itemPurpleCrystal;
	public static Item itemGreenCrystal;
	//hand machines
	public static Item itemColourSplicer;
	public static Item itemColourSlicer;
	public static Item itemHammer;
	public static Item itemMetalCutter;
	//crafting components
	public static Item itemWoodenGear;
	public static Item itemStoneGear;
	public static Item itemIronGear;
	public static Item itemBronzeGear;
	public static Item itemTitaniumGear;
	public static Item itemStelliteGear;
	public static Item itemToolBinding;
	public static Item itemLowLevelServo;
	public static Item itemMidLevelServo;
	public static Item itemHighLevelServo;
	public static Item itemSpindle;
	public static Item itemCarbonPlate;
	public static Item itemCopperPlate;
	//world machines
	public static Block blockAlloySmelterIdle;
	public static Block blockAlloySmelterActive;
	public static final int guiIDAlloySmelter = 1;
	//OP
	public static Item itemBobRossPaintScraper;
	//instance
	public static yvolution instance;
	//money
	public static Item itemPenny;
	public static Item itemNickel;
	public static Item itemDime;
	public static Item itemQuarter;
	public static Item itemLoonie;
	public static Item itemToonie;
	public static Item item5Bill;
	public static Item item10Bill;
	public static Item item20Bill;
	public static Item item50Bill;
	public static Item item100Bill;
	@EventHandler
	public void PreInit(FMLPreInitializationEvent preEvent){
		
		itemBobRossPaintScraper = new yvItems().setUnlocalizedName("BobRossPaintScraper");
		GameRegistry.registerItem(itemBobRossPaintScraper, "BobRossPaintScraper");
		
		itemHammer = new yvHammer().setUnlocalizedName("Hammer");
		GameRegistry.registerItem(itemHammer, "Hammer");
		
		itemMetalCutter = new yvHammer().setUnlocalizedName("MetalCutter");
		GameRegistry.registerItem(itemMetalCutter, "MetalCutter");
		
		itemCarbonPlate = new yvItems().setUnlocalizedName("CarbonPlate");
		GameRegistry.registerItem(itemCarbonPlate, "CarbonPlate");
		
		itemCopperPlate = new yvItems().setUnlocalizedName("CopperPlate");
		GameRegistry.registerItem(itemCopperPlate, "CopperPlate");
		
		itemPenny = new yvItems().setUnlocalizedName("Penny");
		GameRegistry.registerItem(itemPenny, "Penny");
		
		itemNickel = new yvItems().setUnlocalizedName("Nickel");
		GameRegistry.registerItem(itemNickel, "Nickel");
		
		itemQuarter = new yvItems().setUnlocalizedName("Quarter");
		GameRegistry.registerItem(itemQuarter, "Quarter");
		
		itemColourSplicer = new yvItems().setUnlocalizedName("ColourSplicer");
		GameRegistry.registerItem(itemColourSplicer, "ColourSplicer");
		
		itemColourSlicer = new yvItems().setUnlocalizedName("ColourSlicer");
		GameRegistry.registerItem(itemColourSlicer, "ColourSlicer");
		
		itemWoodenGear = new yvItems().setUnlocalizedName("WoodenGear");
		GameRegistry.registerItem(itemWoodenGear, "WoodenGear");
		
		itemStoneGear = new yvItems().setUnlocalizedName("StoneGear");
		GameRegistry.registerItem(itemStoneGear, "StoneGear");
		
		itemIronGear = new yvItems().setUnlocalizedName("IronGear");
		GameRegistry.registerItem(itemIronGear, "IronGear");
		
		itemBronzeGear = new yvItems().setUnlocalizedName("BronzeGear");
		GameRegistry.registerItem(itemBronzeGear, "BronzeGear");
		
		itemToolBinding = new yvItems().setUnlocalizedName("ToolBinding");
		GameRegistry.registerItem(itemToolBinding, "ToolBinding");
		
		itemLowLevelServo = new yvItems().setUnlocalizedName("LowLevelServo");
		GameRegistry.registerItem(itemLowLevelServo, "LowLevelServo");
		
		itemMidLevelServo = new yvItems().setUnlocalizedName("MidLevelServo");
		GameRegistry.registerItem(itemMidLevelServo, "MidLevelServo");
		
		itemHighLevelServo = new yvItems().setUnlocalizedName("HighLevelServo");
		GameRegistry.registerItem(itemHighLevelServo, "HighLevelServo");
		
		itemSpindle = new yvItems().setUnlocalizedName("Spindle");
		GameRegistry.registerItem(itemSpindle, "Spindle");

		itemCopperIngot = new yvItems().setUnlocalizedName("CopperIngot");
		GameRegistry.registerItem(itemCopperIngot, "CopperIngot");
		
		itemAluminiumIngot = new yvItems().setUnlocalizedName("AluminiumIngot");
		GameRegistry.registerItem(itemAluminiumIngot, "AluminiumIngot");
		
		itemTinIngot = new yvItems().setUnlocalizedName("TinIngot");
		GameRegistry.registerItem(itemTinIngot, "TinIngot");
		
		itemTitaniumIngot = new yvItems().setUnlocalizedName("TitaniumIngot");
		GameRegistry.registerItem(itemTitaniumIngot, "TitaniumIngot");
		
		itemLeadIngot = new yvItems().setUnlocalizedName("LeadIngot");
		GameRegistry.registerItem(itemLeadIngot, "LeadIngot");
		
		itemSilverIngot = new yvItems().setUnlocalizedName("SilverIngot");
		GameRegistry.registerItem(itemSilverIngot, "SilverIngot");
		
		itemZincIngot = new yvItems().setUnlocalizedName("ZincIngot");
		GameRegistry.registerItem(itemZincIngot, "ZincIngot");
		
		itemOsmiumIngot = new yvItems().setUnlocalizedName("OsmiumIngot");
		GameRegistry.registerItem(itemOsmiumIngot, "OsmiumIngot");
		
		itemTungstenIngot = new yvItems().setUnlocalizedName("TungstenIngot");
		GameRegistry.registerItem(itemTungstenIngot, "TungstenIngot");
		
		itemChromiumIngot = new yvItems().setUnlocalizedName("ChromiumIngot");
		GameRegistry.registerItem(itemChromiumIngot, "ChromiumIngot");
		
		itemPureUraniumIngot = new yvItems().setUnlocalizedName("PureUraniumIngot");
		GameRegistry.registerItem(itemPureUraniumIngot, "PureUraniumIngot");
		
		itemPlatinumIngot = new yvItems().setUnlocalizedName("PlatinumIngot");
		GameRegistry.registerItem(itemPlatinumIngot, "PlatinumIngot");
		
		itemCobaltIngot = new yvItems().setUnlocalizedName("CobaltIngot");
		GameRegistry.registerItem(itemCobaltIngot, "CobaltIngot");
		
		itemCadmiumIngot = new yvItems().setUnlocalizedName("CadmiumIngot");
		GameRegistry.registerItem(itemCadmiumIngot, "CadmiumIngot");
		
		itemNickelIngot = new yvItems().setUnlocalizedName("NickelIngot");
		GameRegistry.registerItem(itemNickelIngot, "NickelIngot");
		
		itemManganeseIngot = new yvItems().setUnlocalizedName("ManganeseIngot");
		GameRegistry.registerItem(itemManganeseIngot, "ManganeseIngot");
		
		itemUnrefinedUranium = new yvItems().setUnlocalizedName("UnrefinedUranium");
		GameRegistry.registerItem(itemUnrefinedUranium, "UnrefinedUranium");
		
		itemBlueCrystal = new yvItems().setUnlocalizedName("BlueCrystal");
		GameRegistry.registerItem(itemBlueCrystal, "BlueCrystal");
		
		itemYellowCrystal = new yvItems().setUnlocalizedName("YellowCrystal");
		GameRegistry.registerItem(itemYellowCrystal, "YellowCrystal");
		
		itemRedCrystal = new yvItems().setUnlocalizedName("RedCrystal");
		GameRegistry.registerItem(itemRedCrystal, "RedCrystal");
		
		itemGreenCrystal = new yvItems().setUnlocalizedName("GreenCrystal");
		GameRegistry.registerItem(itemGreenCrystal, "GreenCrystal");
		
		itemOrangeCrystal = new yvItems().setUnlocalizedName("OrangeCrystal");
		GameRegistry.registerItem(itemOrangeCrystal, "OrangeCrystal");
		
		itemPurpleCrystal = new yvItems().setUnlocalizedName("PurpleCrystal");
		GameRegistry.registerItem(itemPurpleCrystal, "PurpleCrystal");
		
		itemBrassIngot = new yvItems().setUnlocalizedName("BrassIngot");
		GameRegistry.registerItem(itemBrassIngot, "BrassIngot");
		
		itemBronzeIngot = new yvItems().setUnlocalizedName("BronzeIngot");
		GameRegistry.registerItem(itemBronzeIngot, "BronzeIngot");
		
		itemDuraluminIngot = new yvItems().setUnlocalizedName("DuraluminIngot");
		GameRegistry.registerItem(itemDuraluminIngot, "DuraluminIngot");
		
		itemNichromeIngot = new yvItems().setUnlocalizedName("NichromeIngot");
		GameRegistry.registerItem(itemNichromeIngot, "NichromeIngot");
		
		itemStelliteIngot = new yvItems().setUnlocalizedName("StelliteIngot");
		GameRegistry.registerItem(itemStelliteIngot, "StelliteIngot");
		
		itemElectrumIngot = new yvItems().setUnlocalizedName("ElectrumIngot");
		GameRegistry.registerItem(itemElectrumIngot, "ElectrumIngot");
		
		itemStirlingsilverIngot = new yvItems().setUnlocalizedName("StirlingsilverIngot");
		GameRegistry.registerItem(itemStirlingsilverIngot, "StirlingsilverIngot");
		
		itemStaballoyIngot = new yvItems().setUnlocalizedName("StaballoyIngot");
		GameRegistry.registerItem(itemStaballoyIngot, "StaballoyIngot");
		
		itemUltaniumIngot = new yvItems().setUnlocalizedName("UltaniumIngot");
		GameRegistry.registerItem(itemUltaniumIngot, "UltaniumIngot");
		
		oreCopperOre = new CopperOre(Material.rock).setBlockName("CopperOre");
		GameRegistry.registerBlock(oreCopperOre,  "CopperOre");
		
		oreTinOre = new TinOre(Material.rock).setBlockName("TinOre");
		GameRegistry.registerBlock(oreTinOre,  "TinOre");

		oreAluminiumOre = new AluminiumOre(Material.rock).setBlockName("AluminiumOre");
		GameRegistry.registerBlock(oreAluminiumOre,  "AluminiumOre");
		
		oreTitaniumOre = new TitaniumOre(Material.rock).setBlockName("TitaniumOre");
		GameRegistry.registerBlock(oreTitaniumOre,  "TitaniumOre");

		oreLeadOre = new LeadOre(Material.rock).setBlockName("LeadOre");
		GameRegistry.registerBlock(oreLeadOre,  "LeadOre");

		oreSilverOre = new SilverOre(Material.rock).setBlockName("SilverOre");
		GameRegistry.registerBlock(oreSilverOre,  "SilverOre");

		oreZincOre = new ZincOre(Material.rock).setBlockName("ZincOre");
		GameRegistry.registerBlock(oreZincOre,  "ZincOre");

		oreOsmiumOre = new OsmiumOre(Material.rock).setBlockName("OsmiumOre");
		GameRegistry.registerBlock(oreOsmiumOre,  "OsmiumOre");

		oreTungstenOre = new TungstenOre(Material.rock).setBlockName("TungstenOre");
		GameRegistry.registerBlock(oreTungstenOre,  "TungstenOre");

		oreChromiumOre = new ChromiumOre(Material.rock).setBlockName("ChromiumOre");
		GameRegistry.registerBlock(oreChromiumOre,  "ChromiumOre");

		oreUraniumOre = new UraniumOre(Material.rock).setBlockName("UraniumOre");
		GameRegistry.registerBlock(oreUraniumOre,  "UraniumOre");

		orePlatinumOre = new PlatinumOre(Material.rock).setBlockName("PlatinumOre");
		GameRegistry.registerBlock(orePlatinumOre,  "PlatinumOre");

		oreCobaltOre = new CobaltOre(Material.rock).setBlockName("CobaltOre");
		GameRegistry.registerBlock(oreCobaltOre,  "CobaltOre");

		oreCadmiumOre = new CadmiumOre(Material.rock).setBlockName("CadmiumOre");
		GameRegistry.registerBlock(oreCadmiumOre,  "CadmiumOre");

		oreNickelOre = new NickelOre(Material.rock).setBlockName("NickelOre");
		GameRegistry.registerBlock(oreNickelOre,  "NickelOre");

		oreManganeseOre = new ManganeseOre(Material.rock).setBlockName("ManganeseOre");
		GameRegistry.registerBlock(oreManganeseOre,  "ManganeseOre");

		oreBluecrystalOre = new BluecrystalOre(Material.rock).setBlockName("BluecrystalOre");
		GameRegistry.registerBlock(oreBluecrystalOre,  "BluecrystalOre");

		oreYellowcrystalOre = new YellowcrystalOre(Material.rock).setBlockName("YellowcrystalOre");
		GameRegistry.registerBlock(oreYellowcrystalOre,  "YellowcrystalOre");

		oreRedcrystalOre = new RedcrystalOre(Material.rock).setBlockName("RedcrystalOre");
		GameRegistry.registerBlock(oreRedcrystalOre,  "RedcrystalOre");

		oreOrangecrystalOre = new OrangecrystalOre(Material.rock).setBlockName("OrangecrystalOre");
		GameRegistry.registerBlock(oreOrangecrystalOre,  "OrangecrystalOre");

		orePurplecrystalOre = new PurplecrystalOre(Material.rock).setBlockName("PurplecrystalOre");
		GameRegistry.registerBlock(orePurplecrystalOre,  "PurplecrystalOre");

		oreGreencrystalOre = new GreencrystalOre(Material.rock).setBlockName("GreencrystalOre");
		GameRegistry.registerBlock(oreGreencrystalOre,  "GreencrystalOre");
		
		blockYellowOctoidBlock = new YellowOctoidBlock(Material.iron).setBlockName("YellowOctoidBlock");
		GameRegistry.registerBlock(blockYellowOctoidBlock, "YellowOctoidBlock");
		
		blockBlueOctoidBlock = new BlueOctoidBlock(Material.iron).setBlockName("BlueOctoidBlock");
		GameRegistry.registerBlock(blockBlueOctoidBlock, "BlueOctoidBlock");
		
		blockRedOctoidBlock = new RedOctoidBlock(Material.iron).setBlockName("RedOctoidBlock");
		GameRegistry.registerBlock(blockRedOctoidBlock, "RedOctoidBlock");
		
		blockOrangeOctoidBlock = new OrangeOctoidBlock(Material.iron).setBlockName("OrangeOctoidBlock");
		GameRegistry.registerBlock(blockOrangeOctoidBlock, "OrangeOctoidBlock");
		
		blockPurpleOctoidBlock = new PurpleOctoidBlock(Material.iron).setBlockName("PurpleOctoidBlock");
		GameRegistry.registerBlock(blockPurpleOctoidBlock, "PurpleOctoidBlock");
		
		blockGreenOctoidBlock = new GreenOctoidBlock(Material.iron).setBlockName("GreenOctoidBlock");
		GameRegistry.registerBlock(blockGreenOctoidBlock, "GreenOctoidBlock");
		
		blockYellowComplexBlock = new YellowComplexBlock(Material.iron).setBlockName("YellowComplexBlock");
		GameRegistry.registerBlock(blockYellowComplexBlock, "YellowComplexBlock");
		
		blockRedComplexBlock = new RedComplexBlock(Material.iron).setBlockName("RedComplexBlock");
		GameRegistry.registerBlock(blockRedComplexBlock, "RedComplexBlock");
		
		blockYellowEnhancedBlock = new YellowEnhancedBlock(Material.iron).setBlockName("YellowEnhancedBlock");
		GameRegistry.registerBlock(blockYellowEnhancedBlock, "YellowEnhancedBlock");
		
		blockRedEnhancedBlock = new RedEnhancedBlock(Material.iron).setBlockName("RedEnhancedBlock");
		GameRegistry.registerBlock(blockRedEnhancedBlock, "RedEnhancedBlock");
		
		blockBlueEnhancedBlock = new BlueEnhancedBlock(Material.iron).setBlockName("BlueEnhancedBlock");
		GameRegistry.registerBlock(blockBlueEnhancedBlock, "BlueEnhancedBlock");
		
		blockGreenEnhancedBlock = new GreenEnhancedBlock(Material.iron).setBlockName("GreenEnhancedBlock");
		GameRegistry.registerBlock(blockGreenEnhancedBlock, "GreenEnhancedBlock");
		
		blockPurpleEnhancedBlock = new PurpleEnhancedBlock(Material.iron).setBlockName("PurpleEnhancedBlock");
		GameRegistry.registerBlock(blockPurpleEnhancedBlock, "PurpleEnhancedBlock");
		
		blockOrangeEnhancedBlock = new OrangeEnhancedBlock(Material.iron).setBlockName("OrangeEnhancedBlock");
		GameRegistry.registerBlock(blockOrangeEnhancedBlock, "OrangeEnhancedBlock");
		
		blockCarbonGlass = new CarbonGlass(Material.glass).setBlockName("CarbonGlass");
		GameRegistry.registerBlock(blockCarbonGlass, "CarbonGlass");
		
		blockCarbonSand = new CarbonSand(Material.sand).setBlockName("CarbonSand");
		GameRegistry.registerBlock(blockCarbonSand, "CarbonSand");
		
		
		
		GameRegistry.registerWorldGenerator(eventWorldGen, 0);
		
		//machines
		blockAlloySmelterIdle = new AlloySmelter(false).setBlockName("AlloySmelterIdle").setCreativeTab(yvolution.tabYvolution).setHardness(3.5F);
		blockAlloySmelterActive = new AlloySmelter(true).setBlockName("AlloySmelterActive").setLightLevel(0.625F).setHardness(3.5F);
		GameRegistry.registerBlock(blockAlloySmelterIdle, "AlloySmelterIdle");
		GameRegistry.registerBlock(blockAlloySmelterActive, "AlloySmelterActive");
		
		
		
		
		
		
		
		
		
	}
	
	@EventHandler
	public void Init(FMLInitializationEvent event){
		
		FMLCommonHandler.instance().bus().register(new CraftingHandler());
		
		NetworkRegistry.INSTANCE.registerGuiHandler(this, new GuiHandler());
		GameRegistry.registerTileEntity(TileEntityAlloySmelter.class, "AlloySmelter");
		
		
		
		GameRegistry.addRecipe(new ItemStack(yvolution.blockYellowOctoidBlock, 5), "SYS", "YSY", "SYS", 'Y', itemYellowCrystal, 'S', Blocks.stone);
		GameRegistry.addRecipe(new ItemStack(yvolution.blockBlueOctoidBlock, 5), "SYS", "YSY", "SYS", 'Y', itemBlueCrystal, 'S', Blocks.stone);
		GameRegistry.addRecipe(new ItemStack(yvolution.blockRedOctoidBlock, 5), "SYS", "YSY", "SYS", 'Y', itemRedCrystal, 'S', Blocks.stone);
		GameRegistry.addRecipe(new ItemStack(yvolution.blockOrangeOctoidBlock, 5), "SYS", "YSY", "SYS", 'Y', itemOrangeCrystal, 'S', Blocks.stone);
		GameRegistry.addRecipe(new ItemStack(yvolution.blockPurpleOctoidBlock, 5), "SYS", "YSY", "SYS", 'Y', itemPurpleCrystal, 'S', Blocks.stone);
		GameRegistry.addRecipe(new ItemStack(yvolution.blockGreenOctoidBlock, 5), "SYS", "YSY", "SYS", 'Y', itemGreenCrystal, 'S', Blocks.stone);
		GameRegistry.addRecipe(new ItemStack(yvolution.itemWoodenGear), "SYS", "Y Y", "SYS", 'Y', Items.stick, 'S', Blocks.planks);
		GameRegistry.addRecipe(new ItemStack(yvolution.itemStoneGear), "S S", " Y ", "S S", 'Y', yvolution.itemWoodenGear, 'S', Blocks.cobblestone);
		GameRegistry.addRecipe(new ItemStack(yvolution.itemIronGear), "S S", " Y ", "S S", 'Y', yvolution.itemStoneGear, 'S', Items.iron_ingot);
		GameRegistry.addRecipe(new ItemStack(yvolution.itemBronzeGear), "S S", " Y ", "S S", 'Y', yvolution.itemIronGear, 'S', yvolution.itemBronzeIngot);
		GameRegistry.addRecipe(new ItemStack(yvolution.itemSpindle, 4), " Y ", " Y ", " Y ", 'Y', yvolution.itemNickelIngot);
		GameRegistry.addRecipe(new ItemStack(yvolution.itemSpindle, 4), " Y ", " Y ", " Y ", 'Y', yvolution.itemOsmiumIngot);
		GameRegistry.addRecipe(new ItemStack(yvolution.itemToolBinding, 4), " Y ", "YSY", " Y ", 'S', yvolution.itemSpindle, 'Y', Items.string);
		GameRegistry.addRecipe(new ItemStack(yvolution.itemLowLevelServo), "YUY", "XUB", "YUY", 'Y', Items.iron_ingot, 'U', yvolution.itemSpindle, 'X', yvolution.itemCopperIngot, 'B', yvolution.itemBronzeIngot);
		GameRegistry.addShapelessRecipe(new ItemStack(yvolution.itemCarbonPlate), new Object[]{new ItemStack(itemHammer, 1, OreDictionary.WILDCARD_VALUE), Blocks.coal_block});
		GameRegistry.addShapelessRecipe(new ItemStack(yvolution.itemCopperPlate), new Object[]{new ItemStack(itemHammer, 1, OreDictionary.WILDCARD_VALUE), yvolution.itemCopperIngot});
		GameRegistry.addShapelessRecipe(new ItemStack(yvolution.itemPenny, 4), new Object[]{new ItemStack(itemMetalCutter, 1, OreDictionary.WILDCARD_VALUE), yvolution.itemCopperPlate});
		GameRegistry.addRecipe(new ItemStack(yvolution.itemHammer), "IXI", "ISI", " S ", 'I', yvolution.itemStirlingsilverIngot, 'X', yvolution.itemToolBinding, 'S', Items.stick);
		GameRegistry.addShapelessRecipe(new ItemStack(yvolution.blockCarbonSand, 4), new Object[]{Blocks.sand, Blocks.sand, Blocks.sand, Blocks.sand, Items.coal});
		GameRegistry.addRecipe(new ItemStack(yvolution.blockYellowComplexBlock, 4), "CYT", "YIY", "TYC", 'Y', yvolution.blockYellowOctoidBlock, 'I', Items.iron_ingot, 'C', yvolution.itemCopperIngot, 'T', yvolution.itemChromiumIngot);
		GameRegistry.addRecipe(new ItemStack(yvolution.blockRedComplexBlock, 4), "CYT", "YIY", "TYC", 'Y', yvolution.blockRedOctoidBlock, 'I', Items.iron_ingot, 'C', yvolution.itemCopperIngot, 'T', yvolution.itemChromiumIngot);
		GameRegistry.addRecipe(new ItemStack(yvolution.blockYellowEnhancedBlock, 3), "CGC", "CBC", "CGC", 'C', yvolution.itemCarbonPlate, 'G', yvolution.blockCarbonGlass, 'B', yvolution.blockYellowComplexBlock);
		GameRegistry.addRecipe(new ItemStack(yvolution.blockRedEnhancedBlock, 3), "CGC", "CBC", "CGC", 'C', yvolution.itemCarbonPlate, 'G', yvolution.blockCarbonGlass, 'B', yvolution.blockRedComplexBlock);
		
		
		//to be removed once machines are available
		GameRegistry.addShapelessRecipe(new ItemStack(yvolution.itemBronzeIngot, 2), new Object[]{yvolution.itemCopperIngot, yvolution.itemTinIngot});
		GameRegistry.addShapelessRecipe(new ItemStack(yvolution.itemBrassIngot, 2), new Object[]{yvolution.itemCopperIngot, yvolution.itemZincIngot});
		GameRegistry.addShapelessRecipe(new ItemStack(yvolution.itemDuraluminIngot, 2), new Object[]{yvolution.itemCopperIngot, yvolution.itemAluminiumIngot});
		GameRegistry.addShapelessRecipe(new ItemStack(yvolution.itemNichromeIngot, 2), new Object[]{yvolution.itemNickelIngot, yvolution.itemChromiumIngot});
		GameRegistry.addShapelessRecipe(new ItemStack(yvolution.itemStelliteIngot, 2), new Object[]{yvolution.itemChromiumIngot, yvolution.itemCobaltIngot, yvolution.itemTungstenIngot, Items.coal});
		GameRegistry.addShapelessRecipe(new ItemStack(yvolution.itemElectrumIngot, 2), new Object[]{yvolution.itemSilverIngot, Items.gold_ingot, yvolution.itemCopperIngot});
		GameRegistry.addShapelessRecipe(new ItemStack(yvolution.itemStirlingsilverIngot, 2), new Object[]{yvolution.itemSilverIngot, yvolution.itemCopperIngot});
		GameRegistry.addShapelessRecipe(new ItemStack(yvolution.itemGreenCrystal), new Object[]{yvolution.itemBlueCrystal, yvolution.itemYellowCrystal});
		GameRegistry.addShapelessRecipe(new ItemStack(yvolution.itemPurpleCrystal), new Object[]{yvolution.itemBlueCrystal, yvolution.itemRedCrystal});
		GameRegistry.addShapelessRecipe(new ItemStack(yvolution.itemOrangeCrystal), new Object[]{yvolution.itemRedCrystal, yvolution.itemYellowCrystal});
		
		
		GameRegistry.addSmelting(oreCopperOre, new ItemStack(itemCopperIngot), 1F);
		GameRegistry.addSmelting(oreTinOre, new ItemStack(itemTinIngot), 1F);
		GameRegistry.addSmelting(oreAluminiumOre, new ItemStack(itemAluminiumIngot), 1F);
		GameRegistry.addSmelting(oreTitaniumOre, new ItemStack(itemTitaniumIngot), 1F);
		GameRegistry.addSmelting(oreLeadOre, new ItemStack(itemLeadIngot), 1F);
		GameRegistry.addSmelting(oreSilverOre, new ItemStack(itemSilverIngot), 1F);
		GameRegistry.addSmelting(oreZincOre, new ItemStack(itemZincIngot), 1F);
		GameRegistry.addSmelting(oreOsmiumOre, new ItemStack(itemOsmiumIngot), 1F);
		GameRegistry.addSmelting(oreTungstenOre, new ItemStack(itemTungstenIngot), 1F);
		GameRegistry.addSmelting(oreChromiumOre, new ItemStack(itemChromiumIngot), 1F);
		GameRegistry.addSmelting(oreUraniumOre, new ItemStack(itemUnrefinedUranium), 1F);
		GameRegistry.addSmelting(orePlatinumOre, new ItemStack(itemPlatinumIngot), 1F);
		GameRegistry.addSmelting(oreCobaltOre, new ItemStack(itemCobaltIngot), 1F);
		GameRegistry.addSmelting(oreCadmiumOre, new ItemStack(itemCadmiumIngot), 1F);
		GameRegistry.addSmelting(oreNickelOre, new ItemStack(itemNickelIngot), 1F);
		GameRegistry.addSmelting(oreManganeseOre, new ItemStack(itemManganeseIngot), 1F);
		GameRegistry.addSmelting(oreBluecrystalOre, new ItemStack(itemBlueCrystal, 5), 1F);
		GameRegistry.addSmelting(oreRedcrystalOre, new ItemStack(itemRedCrystal, 5), 1F);
		GameRegistry.addSmelting(oreYellowcrystalOre, new ItemStack(itemYellowCrystal, 5), 1F);
		GameRegistry.addSmelting(oreOrangecrystalOre, new ItemStack(itemOrangeCrystal, 5), 1F);
		GameRegistry.addSmelting(orePurplecrystalOre, new ItemStack(itemPurpleCrystal, 5), 1F);
		GameRegistry.addSmelting(oreGreencrystalOre, new ItemStack(itemGreenCrystal, 5), 1F);
		GameRegistry.addSmelting(blockCarbonSand, new ItemStack(blockCarbonGlass, 9), 1F);
		
		
		
		
	}
	
	@EventHandler
	public void PostInit(FMLPostInitializationEvent postEvent){
		
	}
}
