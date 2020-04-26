/*
  _____ _         __  ____          __        _              
 / ____| |       / _|/ _\ \        / /       | |         _   
| (___ | |_ __ _| |_| |_ \ \  /\  / /__  _ __| | _____ _| |_ 
 \___ \| __/ _` |  _|  _| \ \/  \/ / _ \| '__| |/ / __|_   _|
 ____) | || (_| | | | |    \  /\  / (_) | |  |   <\__ \ |_|  
|_____/ \__\__,_|_| |_|     \/  \/ \___/|_|  |_|\_\___/      
*/
package me.oppyusa.staffworksplus;

// import org.bukkit.command.CommandExecutor;
import org.bukkit.plugin.java.JavaPlugin;

import me.oppyusa.staffworksplus.commands.BanHammer;
import me.oppyusa.staffworksplus.commands.ReloadConfig;


public class Main extends JavaPlugin {
	private static Main i;
	public static Main get() { return i; }
	@Override
	public void onEnable() {
		i = this;
		getLogger().info("StaffWorksPlus has been enabled. It is at version 0.0.2");
        
        getConfig().options().copyDefaults();
        saveDefaultConfig();
        
        ConfigMaker.setup(i);
        ConfigMaker.get().addDefault("Anti-Ban", "Notch");
        ConfigMaker.get().options();
        ConfigMaker.save();
        // getCommand("staffworks").setExecutor(new BanHammer());
        // getCommand("swreload").setExecutor((CommandExecutor)new ReloadConfig());
        i.getCommand("staffworks").setExecutor(new ReloadConfig());
        i.getCommand("banhammer").setExecutor(new BanHammer());
	}
	@Override
	public void onDisable() {
		getLogger().info("StaffWorksPlus has been disable.");
	}
}