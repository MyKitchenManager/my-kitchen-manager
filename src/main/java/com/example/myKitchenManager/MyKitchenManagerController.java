package com.example.myKitchenManager;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;

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
}
