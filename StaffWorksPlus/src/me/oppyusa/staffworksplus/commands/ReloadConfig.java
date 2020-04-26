package me.oppyusa.staffworksplus.commands;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import me.oppyusa.staffworksplus.ConfigMaker;

public class ReloadConfig implements CommandExecutor {
	 
    
    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
       if (cmd.getName().equalsIgnoreCase("staffworks")) {
    	   Player player = (Player) sender;
    	   ConfigMaker.get().options();
    	   player.sendMessage(ChatColor.AQUA + "StaffWorksPlus has been reloaded. If this bugs out, please make a bug report.");
          return true;
        }
        return false;
    }
}
