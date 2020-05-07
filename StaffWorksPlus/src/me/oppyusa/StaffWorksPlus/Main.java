package me.oppyusa.StaffWorksPlus;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerInteractEntityEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.java.JavaPlugin;

public class Main extends JavaPlugin implements Listener {
  public void onEnable() {
    saveDefaultConfig();
    getServer().getPluginManager().registerEvents(this, (Plugin)this);
  }
  
  @EventHandler
  public void onClickEntity(PlayerInteractEntityEvent e) {
    Player p = e.getPlayer();
    if (!p.hasPermission("BanHammer.use"))
      return; 

	ItemStack item = p.getInventory().getItemInHand();
    if (item == null || item.getType() != Material.AIR || item.getType() != Material.STICK)
      return; 
    if (!(e.getRightClicked() instanceof Player))
      return; 
    Player rightClicked = (Player)e.getRightClicked();
    if (item.getItemMeta().getDisplayName().equals(ChatColor.translateAlternateColorCodes('&', getConfig().getString("StaffWorks.Name")))) {
      for (String s : getConfig().getStringList("StaffWorks.Commands"))
        Bukkit.dispatchCommand((CommandSender)Bukkit.getConsoleSender(), s.replace("%clicker%", p.getName()).replace("%player%", rightClicked.getName())); 
      p.sendMessage(ChatColor.translateAlternateColorCodes('&', getConfig().getString("messages.Banned-Player").replace("%player%", rightClicked.getName()).replace("%prefix%", ChatColor.translateAlternateColorCodes('&', getConfig().getString("messages.Prefix")))));
      if (getConfig().getBoolean("StaffWorks.Sounds.Enabled"))
        p.playSound(p.getLocation(), Sound.valueOf(getConfig().getString("StaffWorks.Sounds.Sound")), 1.0F, 1.0F); 
    } 
  }
  
  public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

	   if (sender instanceof Player) {
	        Player p = (Player)sender;
	    
	    if (command.getName().equalsIgnoreCase("banhammer"))
	      if (p.hasPermission("staffworks.hammer")) {
	        if (args.length == 0) {
	          ItemStack banhammer = new ItemStack(Material.IRON_AXE, 1);
	          ItemMeta banhammermeta = banhammer.getItemMeta();
	          banhammermeta.setDisplayName(ChatColor.translateAlternateColorCodes('&', getConfig().getString("BanHammer.Name")));
	          banhammer.setItemMeta(banhammermeta);
	          p.getInventory().addItem(new ItemStack[] { banhammer });
	          p.sendMessage(ChatColor.translateAlternateColorCodes('&', getConfig().getString("messages.Obtained-Hammer").replace("%prefix%", ChatColor.translateAlternateColorCodes('&', getConfig().getString("messages.Prefix")))));
	        } 
	      } else {
	        p.sendMessage(ChatColor.translateAlternateColorCodes('&', getConfig().getString("messages.No-Permission").replace("%prefix%", ChatColor.translateAlternateColorCodes('&', getConfig().getString("messages.Prefix")))));
	      }  
	  }
	   return true;
  }

}
