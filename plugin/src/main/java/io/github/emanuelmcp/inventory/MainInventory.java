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
      
      for(String key : config.getConfigurationSection("menu.skills").getKeys(false)) {
         
         ConfigurationSection section = config.getConfigurationSection(key + ".");
         String name = section.getString("name-item");
         List<String> lore = section.getStringList("lore");
         int position = section.getInt("position");
         String icon = section.getString("icon");
         
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
