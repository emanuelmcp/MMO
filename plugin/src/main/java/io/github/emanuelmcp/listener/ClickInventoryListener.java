package io.github.emanuelmcp.listener;

import io.github.emanuelmcp.RpMmo;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.event.Event;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.inventory.InventoryType;
import org.bukkit.inventory.ItemStack;
import org.jetbrains.annotations.NotNull;


public class ClickInventoryListener implements Listener {
   
   private final RpMmo plugin;
   
   public ClickInventoryListener(RpMmo plugin) {
      this.plugin = plugin;
   }
   
   @EventHandler
   public void onClickInventory(@NotNull InventoryClickEvent event) {
      FileConfiguration config = plugin.getConfig();
      
      Player player = (Player) event.getWhoClicked();
      String title = ChatColor.stripColor(event.getView().getTitle());
      String configTitle = ChatColor.stripColor(plugin.getConfig().getString("menu.title"));
      ItemStack item = event.getCurrentItem();
      InventoryType.SlotType slotType = event.getSlotType();
      
      if(item == null) {
         event.setCancelled(true);
         return;
      }
   
      Material material = item.getType();
      
      if(slotType == InventoryType.SlotType.OUTSIDE || material == Material.AIR) {
         event.setCancelled(true);
         return;
      }
      
      if(!item.hasItemMeta()) {
         event.setCancelled(true);
         return;
      }
      
      if(!title.equals(configTitle)) {
         event.setCancelled(true);
         return;
      }
      
      for(String key : config.getConfigurationSection("menu.skills").getKeys(false)) {
         ItemStack itemSkill = new ItemStack(
            Material.valueOf(config.getString("menu.skills." + key + ".icon")));
         switch(key) {
            case "warrior":
               if(item.equals(itemSkill)) {
                  player.sendMessage(ChatColor.GREEN + "You have selected the warrior skill");
                  player.closeInventory();
               }
               break;
            case "wizard":
               if(item.equals(itemSkill)) {
                  player.sendMessage(ChatColor.GREEN + "You have selected the wizard skill");
                  player.closeInventory();
               }
               break;
               case "homeless":
                  if(item.equals(itemSkill)) {
                     player.sendMessage(ChatColor.GREEN + "You have selected the homeless skill");
                     player.closeInventory();
                  }
                  break;
            case "hunter":
               if(item.equals(itemSkill)) {
                  player.sendMessage(ChatColor.GREEN + "You have selected the hunter skill");
                  player.closeInventory();
               }
               break;
            case "shaman":
               if(item.equals(itemSkill)) {
                  player.sendMessage(ChatColor.GREEN + "You have selected the shaman skill");
                  player.closeInventory();
               }
               break;
         }
      }
      
   }
   
}
