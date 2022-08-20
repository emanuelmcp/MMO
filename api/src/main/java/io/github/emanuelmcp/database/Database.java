package io.github.emanuelmcp.database;

import java.io.FileNotFoundException;
import java.sql.Connection;
import java.sql.SQLException;

public interface Database {

    Connection getConnection();

    void setup() throws ClassNotFoundException, SQLException, FileNotFoundException;

}
