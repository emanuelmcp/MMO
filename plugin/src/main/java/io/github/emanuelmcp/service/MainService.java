package io.github.emanuelmcp.service;

import io.github.emanuelmcp.RpMmo;
import io.github.emanuelmcp.database.Database;
import io.github.emanuelmcp.database.MySQLDatabase;
import io.github.emanuelmcp.loader.ListenerLoader;
import io.github.emanuelmcp.loader.Loader;

import java.io.FileNotFoundException;
import java.sql.SQLException;
import java.util.Arrays;


public class MainService implements Service{
   
   private final Database database;
   private final RpMmo plugin;
   
   
   public MainService(RpMmo plugin) {
      this.plugin = plugin;
      this.database = new MySQLDatabase(plugin);
   }
   
   @Override
   public void start() {
      loadServices(new ListenerLoader(plugin));
   }
   
   @Override
   public void stop() {
   
   }
   
   private void loadServices(Loader... loaders) {
      Arrays.stream(loaders).forEach(Loader::load);
   }
   
}
