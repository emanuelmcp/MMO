package io.github.emanuelmcp.item;


import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.jetbrains.annotations.NotNull;

import java.util.*;


abstract class ItemBuilderLayout<T extends ItemBuilder> implements ItemBuilder {
   
   protected final Material material;
   private final int amount;
   private final byte data;
   
   private String name;
   private List<String> lore;
   private Map<Enchantment, Integer> enchantments;
   private List<ItemFlag> flags;
   private boolean unbreakable;
   
   protected ItemBuilderLayout(Material material, int amount, byte data) {
      this.material = material;
      this.amount = amount;
      this.data = data;
      this.lore = new ArrayList<>();
      this.enchantments = new HashMap<>();
      this.flags = new ArrayList<>();
   }
   
   @Override
   public ItemBuilder name(@NotNull String name) {
      this.name = name;
      return back();
   }
   
   @Override
   public ItemBuilder lore(@NotNull List<String> lore) {
      this.lore = lore;
      return back();
   }
   
   @Override
   public ItemBuilder lore(@NotNull String... lines) {
      this.lore = List.of(lines);
      return back();
   }
   
   @Override
   public ItemBuilder enchantments(@NotNull Map<Enchantment, Integer> enchantments) {
      this.enchantments = enchantments;
      return back();
   }
   
   @Override
   public ItemBuilder enchant(@NotNull Enchantment enchantment, @NotNull int level) {
      this.enchantments.put(enchantment, level);
      return back();
   }
   
   @Override
   public ItemBuilder flags(@NotNull List<ItemFlag> flags) {
      this.flags = flags;
      return back();
   }
   
   @Override
   public ItemBuilder flag(@NotNull ItemFlag... flags) {
      this.flags.addAll(Arrays.asList(flags));
      return back();
   }
   
   @Override
   public ItemBuilder grow() {
      this.enchantments.put(Enchantment.DURABILITY, 3);
      this.flags.add(ItemFlag.HIDE_ENCHANTS);
      return back();
   }
   
   @Override
   public ItemBuilder unbreakable(@NotNull boolean unbreakable) {
      this.unbreakable = unbreakable;
      return back();
   }
   
   @Override
   public ItemStack build() {
      ItemStack itemStack = new ItemStack(material, amount, data);
      ItemMeta meta = itemStack.getItemMeta();
      
      enchantments.forEach((enchantment, level) -> meta.addEnchant(enchantment, level, true));
      
      meta.setDisplayName(name);
      meta.setLore(lore);
      
      List<org.bukkit.inventory.ItemFlag> itemFlags = new ArrayList<>();
      
      for(ItemFlag itemFlag : flags) {
         itemFlags.add(org.bukkit.inventory.ItemFlag.valueOf(itemFlag.name()));
      }
      
      itemFlags.forEach(meta::addItemFlags);
      
      meta.setUnbreakable(unbreakable);
      itemStack.setItemMeta(meta);
      
      return itemStack;
   }
   
   protected abstract T back();
   
}
