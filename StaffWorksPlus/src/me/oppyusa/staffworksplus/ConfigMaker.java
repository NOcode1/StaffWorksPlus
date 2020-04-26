package me.oppyusa.staffworksplus;

import org.bukkit.Bukkit;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;

import java.io.File;
import java.io.IOException;

public class ConfigMaker {
	private static File config;
	private static FileConfiguration customConfig;
	
	
	public static void setup(){
		
		config = new File(Bukkit.getServer().getPluginManager().getPlugin("StaffWorksPlus").getDataFolder(), "config.yml");
		
		if (!config.exists()) {
			try {
				config.createNewFile();
			} catch (IOException e) {
				// Just fixing an error...
			}
		}
		customConfig = YamlConfiguration.loadConfiguration(config);
	}
	public static final FileConfiguration get() {
		return customConfig;
	}
	public static final void save() {
		try{
			customConfig.save(config);
		} catch (IOException e) {
			System.out.println("File, config.yml, could not save.");
		}
	
	} 
	public static void reloadConfig() {
		customConfig = YamlConfiguration.loadConfiguration(config);
	}
	public static void setup(Main i) {
		// TODO Auto-generated method stub
		
	}
}