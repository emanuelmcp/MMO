package io.github.emanuelmcp.database;

import org.jetbrains.annotations.NotNull;

import java.io.FileNotFoundException;
import java.sql.Connection;
import java.sql.SQLException;

public interface Database {

    @NotNull Connection getConnection();

    void setup() throws ClassNotFoundException, SQLException, FileNotFoundException;

}
