package io.github.emanuelmcp.database;

import java.sql.Connection;
import java.sql.DriverManager;

public class MySQLDatabase implements Database {

    private static final String DRIVER = "com.mysql.cj.jdbc.Driver";
    private Connection connection;

    @Override
    public Connection getConnection() {
        return connection;
    }

    @Override
    public void setup() throws ClassNotFoundException {
        /*
        Base de datos URL: jdbc:mysql://localhost:3306/hotelcoloniallinn
        Usuario: root
        Clave:
         */
        String ip = "localhost";
        String port = "3306";
        String database = "prueba";

        String url = "jdbc:mysql://" + ip + ":" + port + "/" + database;
        String user = "root";
        String password = "";

        Class.forName(DRIVER);
        connection = DriverManager.getConnection(dataBaseURL, user, password);

    }
}
