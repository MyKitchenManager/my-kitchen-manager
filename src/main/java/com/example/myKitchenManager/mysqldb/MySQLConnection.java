package com.example.myKitchenManager.mysqldb;

import com.example.myKitchenManager.db.DBConnection;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class MySQLConnection implements DBConnection {
    private Connection conn;
    private static final String url = "jdbc:mysql://b3d05c2aa8bbb6:bc44c945@us-cdbr-iron-east-05.cleardb.net/heroku_61e0b836e5e6c2e?reconnect=true";

    public MySQLConnection () {
        try {
            System.out.println("Connecting to" + url);
            Class.forName("com.mysql.cj.jdbc.Driver").getConstructor().newInstance();
            conn = DriverManager.getConnection(url);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void close() {
        if (conn != null) {
            try {
                conn.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public List<String> getIngredient(String ingredient) {
        List<String> res = new ArrayList<>();
        try {
            String sql = "SELECT * FROM ingredient";
            PreparedStatement prep = conn.prepareStatement(sql);
            //prep.setString(1, ingredient.toLowerCase());
            ResultSet rs = prep.executeQuery();
            while (rs.next()) {
                res.add(rs.getString("ingredient_name"));
            }
        } catch (Exception e) {
            System.out.println(e.getStackTrace());
        }
        return res;
    }
}
