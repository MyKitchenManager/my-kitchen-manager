package com.example.myKitchenManager.db;

import java.util.List;

public interface DBConnection {
    //close the connection
    public void close();
    //for test use
    public List<String> getIngredient(String ingredient);


}
