package io.github.emanuelmcp.loader;

import io.github.emanuelmcp.RpMmo;
import io.github.emanuelmcp.listener.PlayerJoinListener;
import org.bukkit.plugin.PluginManager;
import org.bukkit.event.Listener;

import java.util.Arrays;


public class ListenerLoader implements Loader{
   
   private final RpMmo plugin;
   
   public ListenerLoader(RpMmo plugin) {
      this.plugin = plugin;
   }
   
   @Override
   public void load() {
      loadListeners(new PlayerJoinListener(plugin));
   }
   
   private void loadListeners(Listener... listeners) {
      PluginManager pluginManager = plugin.getServer().getPluginManager();
      Arrays.stream(listeners).forEach(listener -> pluginManager.registerEvents(listener, plugin));
   }
   
}
