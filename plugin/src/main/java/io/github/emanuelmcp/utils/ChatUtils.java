package io.github.emanuelmcp.utils;

import org.bukkit.ChatColor;
import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.List;


public class ChatUtils {
   
   @Contract("_ -> new")
   public static @NotNull String color(String text) {
      return ChatColor.translateAlternateColorCodes('&', text);
   }
   
   public static @NotNull List<String> colorList(@NotNull List<String> list) {
      List<String> newList = new ArrayList<>();
      for(String line : list) {
         newList.add(color(line));
      }
      return newList;
   }
   
}
