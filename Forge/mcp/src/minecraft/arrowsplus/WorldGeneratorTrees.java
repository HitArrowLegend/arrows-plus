/*******************************************************************************
 * WorldGeneratorTrees.java
 * Copyright (c) 2013 WildBamaBoy.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the GNU Public License v3.0
 * which accompanies this distribution, and is available at
 * http://www.gnu.org/licenses/gpl.html
 ******************************************************************************/

package arrowsplus;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import net.minecraft.world.World;
import net.minecraft.world.biome.BiomeGenBase;
import net.minecraft.world.chunk.IChunkProvider;
import cpw.mods.fml.common.IWorldGenerator;

/**
 * Forge hook for world generation. Does some logic before telling the real tree generator to begin making them.
 */
public class WorldGeneratorTrees implements IWorldGenerator
{
	@Override
	public void generate(Random random, int chunkX, int chunkZ, World world, IChunkProvider chunkGenerator, IChunkProvider chunkProvider) 
	{
		BiomeGenBase biome = world.getBiomeGenForCoords(chunkX * 16, chunkZ * 16);

		int coordX = chunkX * 16; 
		int coordZ = chunkZ * 16;

		if (biome.biomeID == BiomeGenBase.forest.biomeID || biome.biomeID == BiomeGenBase.forestHills.biomeID || biome.biomeID == BiomeGenBase.ocean.biomeID)
		{
			for (int i = 0; i < 20; i++)
			{
				int x2 = coordX + random.nextInt(16);
				int y2 = random.nextInt(90);
				int z2 = coordZ + random.nextInt(16);

				List<Integer>validMetas = new ArrayList<Integer>();
				validMetas.add(0);
				validMetas.add(1);
				validMetas.add(2);
				validMetas.add(3);
				validMetas.add(4);
				validMetas.add(5);
				validMetas.add(6);
				validMetas.add(9);

				int meta = validMetas.get(random.nextInt(validMetas.size()));
				
				if (meta == 5 && random.nextBoolean() && random.nextBoolean() && random.nextBoolean())
				{
					//Swap soft maple for hard maple.
					meta = 8;
				}
				
				new WorldGenArrowTrees(false, 6, meta).generate(world, random, x2, y2, z2);
			}
		}

		else if (biome.biomeID == BiomeGenBase.swampland.biomeID)
		{
			for (int i = 0; i < 20; i++)
			{
				int x2 = coordX + random.nextInt(16);
				int y2 = random.nextInt(90);
				int z2 = coordZ + random.nextInt(16);

				List<Integer>validMetas = new ArrayList<Integer>();
				validMetas.add(1);
				validMetas.add(3);
				validMetas.add(4);
				validMetas.add(6);
				validMetas.add(9);
				validMetas.add(10);
				
				int meta = validMetas.get(random.nextInt(validMetas.size()));
				
				new WorldGenArrowTrees(false, 6, meta).generate(world, random, x2, y2, z2);
			}
		}
		
		else if (biome.biomeID == BiomeGenBase.taiga.biomeID || biome.biomeID == BiomeGenBase.taigaHills.biomeID || 
				 biome.biomeID == BiomeGenBase.icePlains.biomeID || biome.biomeID == BiomeGenBase.iceMountains.biomeID)
		{
			for (int i = 0; i < 20; i++)
			{
				int x2 = coordX + random.nextInt(16);
				int y2 = random.nextInt(90);
				int z2 = coordZ + random.nextInt(16);

				List<Integer>validMetas = new ArrayList<Integer>();
				validMetas.add(0);
				validMetas.add(7);
				validMetas.add(4);
				validMetas.add(10);

				int meta = validMetas.get(random.nextInt(validMetas.size()));
				new WorldGenArrowTrees(false, 6, meta).generate(world, random, x2, y2, z2);
			}
		}

		else if (biome.biomeID == BiomeGenBase.jungle.biomeID || biome.biomeID == BiomeGenBase.jungleHills.biomeID)
		{
			if (random.nextBoolean())
			{
				for (int i = 0; i < 20; i++)
				{
					int x2 = coordX + random.nextInt(16);
					int y2 = random.nextInt(90);
					int z2 = coordZ + random.nextInt(16);

					new WorldGenArrowTrees(false, 3, 11).generate(world, random, x2, y2, z2);
				}
			}
		}
	}
}
