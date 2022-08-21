package io.github.emanuelmcp.database;

import io.github.emanuelmcp.RpMmo;
import org.bukkit.configuration.file.FileConfiguration;
import org.jetbrains.annotations.NotNull;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class MySQLDatabase implements Database {

    private static final String DRIVER = "com.mysql.cj.jdbc.Driver";
    private Connection connection;

    private final RpMmo plugin;
    
    public MySQLDatabase(RpMmo plugin) {
        this.plugin = plugin;
    }
    
    @Override
    public @NotNull Connection getConnection() {
        return connection;
    }

    @Override
    public void setup() throws ClassNotFoundException, SQLException {
        FileConfiguration config = plugin.getConfig();
        
        String ip = config.getString("database.ip");
        String port = config.getString("database.port");
        String database = config.getString("database.name");

        String url = "jdbc:mysql://" + ip + ":" + port + "/" + database;
        String user = config.getString("database.user");
        String password = config.getString("database.password");

        Class.forName(DRIVER);
        connection = DriverManager.getConnection(url, user, password);

    }
}
