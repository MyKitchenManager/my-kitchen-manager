package com.example.myKitchenManager.db;

import com.example.myKitchenManager.mysqldb.MySQLConnection;

public class DBConnectionFactory {
    private static final String DEFAULT_DB = "mysql";

    public static DBConnection getConnection(String db) {
        switch (db) {
            case "mysql":
                return new MySQLConnection();
            default:
                throw new IllegalArgumentException("Invalid DB");
        }
    }
    public static DBConnection getConnection() {
        return getConnection(DEFAULT_DB);
    }
}
