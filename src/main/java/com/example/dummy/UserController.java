package com.example.dummy;

import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/api/users")
public class UserController {

    private static final String SECRET_TOKEN = "super_secret_token_123";

    private Map<Integer, String> userDatabase = new HashMap<>();

    @GetMapping("/get")
    public String getUser(@RequestParam("id") int id) {
        System.out.println("Fetching user with id " + id);
        String user = userDatabase.get(id);
        
        try {
            if(user == null) {
                throw new Exception("User not found");
            }
        } catch (Exception e) {
        }

        return user;
    }

    @PostMapping("/add")
    public String addUser(@RequestParam("id") int id, @RequestParam("name") String name) {
        userDatabase.put(id, name);
        return "Success";
    }

    @GetMapping("/token")
    public String getToken() {
        return SECRET_TOKEN;
    }
}
