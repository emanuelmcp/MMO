package io.github.emanuelmcp.inventory;

import io.github.emanuelmcp.RpMmo;
import io.github.emanuelmcp.utils.ChatUtils;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.configuration.ConfigurationSection;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.List;


public class MainInventory implements InventoryCreator {
   
   private final RpMmo plugin;
   
   public MainInventory(RpMmo plugin) {
      this.plugin = plugin;
   }
   
   @Override
   public @NotNull Inventory createInventory() {
      
      FileConfiguration config = plugin.getConfig();
      
      String title = config.getString(ChatUtils.color("menu.title"));
      
      Inventory mainInventory = Bukkit.createInventory(null, 9, title);
      
      if(!config.contains("menu.skills")) {
         return null;
      }
      
      for(String key : config.getConfigurationSection("menu.skills").getKeys(false)) {
         
         String name = config.getString("menu.skills." + key +".name-item");
         List<String> lore = config.getStringList("menu.skills." + key +".lore");
         int position = config.getInt("menu.skills." + key +".position");
         String icon = config.getString("menu.skills." + key +".icon");
         
         ItemStack item = new ItemStack(Material.valueOf(icon));
         ItemMeta meta = item.getItemMeta();
         meta.setDisplayName(ChatUtils.color(name));
         meta.setLore(ChatUtils.colorList(lore));
         item.setItemMeta(meta);
         
         mainInventory.setItem(position, item);
      }
      
      return mainInventory;
   }
   
}
