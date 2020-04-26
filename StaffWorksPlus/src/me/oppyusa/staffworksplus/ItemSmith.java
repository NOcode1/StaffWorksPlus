package me.oppyusa.staffworksplus;

import java.util.ArrayList;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class ItemSmith {

	public ItemStack makeItem(Material m, String name, String desc, int amount) {
		
		ItemStack item = new ItemStack (m, amount);
		
		//Create the item's meta data (name, lore/desc text, etc.)
		ItemMeta im = item.getItemMeta();
		im.setDisplayName(name);
		//Creates the lore
		ArrayList<String> lore = new ArrayList<String>();
		lore.add(desc);
		im.setLore(lore);
		//Hides the vanilla Minecraft tooltip text
		im.addItemFlags(ItemFlag.HIDE_ENCHANTS);
		im.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);
		//Sets the item's meta data to the custom "im" meta data
		item.setItemMeta(im);
		
		return item;
		
	}
	
	public ItemStack buildWeapon(String sword) {
		
		Material m = Material.YELLOW_WOOL;
		String name = new String();
		String desc = new String();
		
		if ( sword.toLowerCase().equals("hammer") ) {
			m = Material.IRON_HOE;
			name = (ChatColor.DARK_RED + "" + ChatColor.BOLD + "Ban Hammer");
			desc = (ChatColor.DARK_GRAY + "" + ChatColor.BOLD + ChatColor.ITALIC + "The PERM BAN HAMMER!");
		}
		return makeItem(m, name, desc, 1);
		
	}
	
}