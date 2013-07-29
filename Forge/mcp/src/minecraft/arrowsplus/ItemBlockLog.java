/*******************************************************************************
 * ItemBlockLog.java
 * Copyright (c) 2013 WildBamaBoy.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the GNU Public License v3.0
 * which accompanies this distribution, and is available at
 * http://www.gnu.org/licenses/gpl.html
 ******************************************************************************/

package arrowsplus;

import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;

/**
 * The item block for logs. Used to display the block in the inventory. (?)
 */
public class ItemBlockLog extends ItemBlock 
{
	/**
	 * Constructor
	 * 
	 * @param id	The block's ID.
	 */
	public ItemBlockLog(int id) 
	{
		super(id);
		setHasSubtypes(true);
		setUnlocalizedName("ItemBlockLog");
	}

	@Override
	public int getMetadata(int damageValue) 
	{
		return damageValue;
	}

	@Override
	public String getUnlocalizedName(ItemStack itemStack)
	{
		return ArrowsPlus.instance.woodNamesCapitalized[itemStack.getItemDamage()] + " Log";
	}
}