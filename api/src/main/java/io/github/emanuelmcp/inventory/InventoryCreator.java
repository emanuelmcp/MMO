package io.github.emanuelmcp.inventory;

import org.bukkit.inventory.Inventory;
import org.jetbrains.annotations.NotNull;


public interface InventoryCreator {
   
   @NotNull Inventory createInventory();
   
}
