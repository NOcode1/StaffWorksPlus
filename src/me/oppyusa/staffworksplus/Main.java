/*
  _____ _         __  ____          __        _              
 / ____| |       / _|/ _\ \        / /       | |         _   
| (___ | |_ __ _| |_| |_ \ \  /\  / /__  _ __| | _____ _| |_ 
 \___ \| __/ _` |  _|  _| \ \/  \/ / _ \| '__| |/ / __|_   _|
 ____) | || (_| | | | |    \  /\  / (_) | |  |   <\__ \ |_|  
|_____/ \__\__,_|_| |_|     \/  \/ \___/|_|  |_|\_\___/      
*/
package me.oppyusa.staffworksplus;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

import me.oppyusa.staffworksplus.commands.ReloadConfig;

public class Main extends JavaPlugin {
	@Override
	public void onEnable() {
		getLogger().info("StaffWorks+ has been enabled. It is at version 0.0.2");
		PluginManager pm = getServer().getPluginManager();
        MyFirstListener listener = new MyFirstListener(this);
        pm.registerEvents(listener, this);
        
        getConfig().options().copyDefaults();
        saveDefaultConfig();
        
        ConfigMaker.setup();
        ConfigMaker.get().addDefault("Anti-Ban", "Notch");
        ConfigMaker.get().options();
        ConfigMaker.save();
        
        this.getCommand("tutorial").setExecutor((CommandExecutor)new ReloadConfig());
	}
	@Override
	public void onDisable() {
		getLogger().info("StaffWorks+ has been disable.");
	}
	
	public boolean onCommand(CommandSender sender, Command tempban, String label, String[] args) {
		
		Player player= (Player) sender;
    	if (sender instanceof Player) {
			String lowerCmd = Bukkit.getName().toLowerCase();
    		switch (lowerCmd) {
    		
			case "banhammer":
				
				int length = args.length;
				
				switch (length) {
				
					case 0:
						
						if ( player.hasPermission("helloworld2.hammer") ) {
							player.sendMessage("Giving BanHammer");
						} else {
							player.sendMessage("You do not have permissions to run this command. If you believe this was a mistake, please contat a server Admin.");
						}
						return true;
					default:
						player.sendMessage("Your command was not recognized.");
	    		    	return true;
						
				}
				
    		default:
    			player.sendMessage("You do not have permissions to run this command. If you believe this was a mistake, please contat a server Admin.");
    		
    		}
			return true;
			
		}
		
		player.sendMessage("You do not have permissions to run this command. If you believe this was a mistake, please contat a server Admin.");
		return true;
	}
}
