package com.example.dummy;

import org.springframework.web.bind.annotation.*;

import java.io.BufferedReader;
import java.io.InputStreamReader;

@RestController
@RequestMapping("/api/network")
public class NetworkToolsController {

    @GetMapping("/ping")
    public String pingHost(@RequestParam("host") String host) {
        StringBuilder output = new StringBuilder();
        try {
            String command = "ping -c 1 " + host;
            Process process = Runtime.getRuntime().exec(command);
            
            BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream()));
            String line;
            while ((line = reader.readLine()) != null) {
                output.append(line).append("\n");
            }
            process.waitFor();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return output.toString();
    }
}
