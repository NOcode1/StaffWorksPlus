package me.oppyusa.staffworksplus.commands;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

import me.oppyusa.staffworksplus.ItemSmith;


public class BanHammer implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
       if (cmd.getName().equalsIgnoreCase("staffworks")) {
    	   Player player = (Player) sender;
       	Inventory inv = player.getInventory();
       	ItemStack item = new ItemSmith().buildWeapon("hammer");
   		inv.addItem(item);
   		player.sendMessage(ChatColor.RED + "YOU HAVE BEEN GIVE THE" + ChatColor.BOLD + " BAN HAMMER!!!!");
       	
          return true;
        }
        return false;
    }
}