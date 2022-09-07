package io.github.emanuelmcp.item;

import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.inventory.ItemStack;
import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;

import java.util.List;
import java.util.Map;


public interface ItemBuilder {
   
   ItemBuilder name(String name);
   
   ItemBuilder lore(List<String> lore);
   
   ItemBuilder lore(String... lines);
   
   ItemBuilder enchantments(Map<Enchantment, Integer> enchantments);
   
   ItemBuilder enchant(Enchantment enchantment, int level);
   
   ItemBuilder flags(List<ItemFlag> flags);
   
   ItemBuilder flag(ItemFlag... flags);
   
   ItemBuilder grow();
   
   ItemBuilder unbreakable(boolean unbreakable);
   
   ItemStack build();
   
   @Contract("_ -> new")
   static @NotNull ItemBuilder builder(Material material) {
      return builder(material, 1);
   }
   
   @Contract("_, _ -> new")
   static @NotNull ItemBuilder builder(Material material, int amount) {
      return builder(material, amount, (byte) 0);
   }
   
   @Contract("_, _, _ -> new")
   static @NotNull ItemBuilder builder(Material material, int amount, byte data) {
      return new DefaultItemBuilder(material, amount, data);
   }

}
