package net.yvolution.mod.worldgen;

import java.util.Random;

import cpw.mods.fml.common.IWorldGenerator;
import net.minecraft.block.Block;
import net.minecraft.world.World;
import net.minecraft.world.chunk.IChunkProvider;
import net.minecraft.world.gen.feature.WorldGenMinable;
import net.yvolution.mod.yvolution;

public class YVWorldGen implements IWorldGenerator {
	
	@Override
	public void generate(Random random, int chunkX, int chunkZ, World world, IChunkProvider chunkGenerator,IChunkProvider chunkProvider) {
		switch(world.provider.dimensionId) {
		case 0:
			//Generate surfaceworld
			generateSurface(world, random, chunkX*16, chunkZ*16);
		
		case 1:
			//Generate Endworld
			//generateEnd(world), random, chunkX*16, chunkZ*16);
			
		case -1:
			//Generate Netherworld
			//generateNether(world), random, chunkX*16, chunkZ*16);		
				
				
			
				
			
		}
	}

	private void generateSurface(World world, Random random, int x, int z) {
		this.addOreSpawn(yvolution.oreCopperOre, world, random, x, z, 16, 16, 4+random.nextInt(6), 25, 4, 100);//all
		this.addOreSpawn(yvolution.oreTinOre, world, random, x, z, 16, 16, 4+random.nextInt(6), 25, 4, 100);//all
		this.addOreSpawn(yvolution.oreAluminiumOre, world, random, x, z, 16, 16, 4+random.nextInt(6), 4, 38, 100);//all
		this.addOreSpawn(yvolution.oreTitaniumOre, world, random, x, z, 16, 16, 4+random.nextInt(6), 2, 4, 20);//low
		this.addOreSpawn(yvolution.oreLeadOre, world, random, x, z, 16, 16, 4+random.nextInt(6), 5, 20, 45);//med
		this.addOreSpawn(yvolution.oreSilverOre, world, random, x, z, 16, 16, 4+random.nextInt(6), 7, 20, 45);//med
		this.addOreSpawn(yvolution.oreZincOre, world, random, x, z, 16, 16, 4+random.nextInt(6), 15, 20, 45);//med
		this.addOreSpawn(yvolution.oreOsmiumOre, world, random, x, z, 16, 16, 4+random.nextInt(6), 7, 20, 45);//med
		this.addOreSpawn(yvolution.oreTungstenOre, world, random, x, z, 16, 16, 4+random.nextInt(6), 8, 4, 20);//low
		this.addOreSpawn(yvolution.oreChromiumOre, world, random, x, z, 16, 16, 4+random.nextInt(6), 8, 4, 45);//low-med
		this.addOreSpawn(yvolution.oreUraniumOre, world, random, x, z, 16, 16, 4+random.nextInt(6), 8, 4, 100);//all
		this.addOreSpawn(yvolution.orePlatinumOre, world, random, x, z, 16, 16, 4+random.nextInt(6), 5, 20, 45);//med
		this.addOreSpawn(yvolution.oreCobaltOre, world, random, x, z, 16, 16, 4+random.nextInt(6), 9, 4, 20);//low
		this.addOreSpawn(yvolution.oreCadmiumOre, world, random, x, z, 16, 16, 4+random.nextInt(6), 7, 20, 45);//med
		this.addOreSpawn(yvolution.oreNickelOre, world, random, x, z, 16, 16, 4+random.nextInt(6), 13, 45, 100);//high
		this.addOreSpawn(yvolution.oreManganeseOre, world, random, x, z, 16, 16, 4+random.nextInt(6), 8, 4, 45);//medlow
		this.addOreSpawn(yvolution.oreBluecrystalOre, world, random, x, z, 16, 16, 4+random.nextInt(6), 8, 4, 100);//all
		this.addOreSpawn(yvolution.oreRedcrystalOre, world, random, x, z, 16, 16, 4+random.nextInt(6), 8, 4, 100);//all
		this.addOreSpawn(yvolution.oreYellowcrystalOre, world, random, x, z, 16, 16, 4+random.nextInt(6), 8, 4, 100);//all
		this.addOreSpawn(yvolution.oreOrangecrystalOre, world, random, x, z, 16, 16, 4+random.nextInt(6), 8, 4, 100);//all
		this.addOreSpawn(yvolution.orePurplecrystalOre, world, random, x, z, 16, 16, 4+random.nextInt(6), 8, 4, 100);//all
		this.addOreSpawn(yvolution.oreGreencrystalOre, world, random, x, z, 16, 16, 4+random.nextInt(6), 8, 4, 100);//all
		//low=4-20
		//med=20-45
		//high=45-100
	}

	private void addOreSpawn(Block block, World world, Random random, int blockXPos, int blockZPos, int maxX, int maxZ, int maxVeinSize, int chanceToSpawn,int minY, int maxY) {
		for(int i = 0; i < chanceToSpawn; i++) {
			int posX = blockXPos + random.nextInt(maxX);
			int posY = minY + random.nextInt(maxY - minY);
			int posZ = blockZPos +random.nextInt(maxZ);
			(new WorldGenMinable(block, maxVeinSize)).generate(world, random, posX, posY, posZ);
		}
		
		
		
	}

}
