package io.github.emanuelmcp;

import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.logging.Logger;

public class RpMmo extends JavaPlugin {

    private static final Logger LOGGER = Bukkit.getLogger();

    @Override
    public void onEnable() {
        // Plugin startup logic here
        LOGGER.info("RpMmo has been enabled");
    }

    @Override
    public void onDisable() {
        LOGGER.info("RpMmo has been disabled");
    }
}
