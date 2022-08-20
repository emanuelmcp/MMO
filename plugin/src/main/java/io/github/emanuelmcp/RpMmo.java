package io.github.emanuelmcp;

import io.github.emanuelmcp.service.MainService;
import io.github.emanuelmcp.service.Service;
import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.logging.Logger;

public class RpMmo extends JavaPlugin {
    private static final Logger LOGGER = Bukkit.getLogger();

    private final Service service = new MainService(this);
    @Override
    public void onEnable() {
        // Plugin startup logic here
        LOGGER.info("RpMmo has been enabled");
        service.start();
    }

    @Override
    public void onDisable() {
        LOGGER.info("RpMmo has been disabled");
        service.stop();
    }
    
    
    
}
