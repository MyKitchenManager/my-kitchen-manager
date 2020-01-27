package com.example.myKitchenManager.mysqldb;

public class MySQLSBUtil {
    private static final String HOSTNAME = "us-cdbr-iron-east-05.cleardb.net";
    private static final String PORT_NUM = "3306"; // change it to your mysql port number
    public static final String DB_NAME = "heroku_61e0b836e5e6c2e";
    private static final String USERNAME = "b3d05c2aa8bbb6";
    private static final String PASSWORD = "bc44c945";
    public static final String URL = "jdbc:mysql://"
            + HOSTNAME + ":" + PORT_NUM + "/" + DB_NAME
            + "?user=" + USERNAME + "&password=" + PASSWORD
            + "&autoReconnect=true&serverTimezone=UTC";
}
