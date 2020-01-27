package com.example.myKitchenManager;

import com.example.myKitchenManager.db.DBConnection;
import com.example.myKitchenManager.db.DBConnectionFactory;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@RestController
public class MyKitchenManagerController {
    @RequestMapping("/")
    public String index() {
        return "Greetings from Spring Boot!";
    }

    @RequestMapping("/welcome")
    public String welcome () {
        return "This is a welcome from MyKitchenManager";
    }

    @RequestMapping("/login")
    public String login () {
        return "This is a page for user to log in";
    }

    @RequestMapping("/ingredient")
    public List<String> ingredient() {
        DBConnection testConnection = DBConnectionFactory.getConnection();
        List<String> res = testConnection.getIngredient("ingredient");
        testConnection.close();
        return res;
    }
}
