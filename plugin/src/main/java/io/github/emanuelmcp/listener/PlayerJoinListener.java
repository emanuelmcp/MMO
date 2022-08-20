package io.github.emanuelmcp.listener;

import io.github.emanuelmcp.RpMmo;
import io.github.emanuelmcp.inventory.InventoryCreator;
import io.github.emanuelmcp.inventory.MainInventory;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.jetbrains.annotations.NotNull;


public class PlayerJoinListener implements Listener{
   
   private final InventoryCreator inventoryCreator;
   
   public PlayerJoinListener(RpMmo plugin) {
      this.inventoryCreator = new MainInventory(plugin);
   }
   @EventHandler
   private void onPlayerJoin(@NotNull PlayerJoinEvent event) {
   
      Player player = event.getPlayer();
   
      player.openInventory(inventoryCreator.createInventory());
   
   }
}
