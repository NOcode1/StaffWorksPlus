package me.oppyusa.staffworksplus;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.inventory.ItemStack;

public class MyFirstListener implements Listener {

	public MyFirstListener(Main plugin) {
		
	}
	
	@EventHandler
	public void onPlayerJoin(PlayerJoinEvent event) {
		
		Player player = (Player) event.getPlayer();
		
		player.sendMessage("Please welcome " + player.getName() + " to Server Name");
		ItemStack item = new ItemSmith().buildWeapon("midas");
		
		player.getInventory().addItem(item);
		
	}
}
