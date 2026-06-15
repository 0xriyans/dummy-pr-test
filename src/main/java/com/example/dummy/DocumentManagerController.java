package com.example.dummy;

import org.springframework.web.bind.annotation.*;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

@RestController
@RequestMapping("/api/documents")
public class DocumentManagerController {

    @GetMapping("/download")
    public String downloadDocument(@RequestParam("filename") String filename) {
        File file = new File("/var/www/uploads/" + filename);
        
        try (FileInputStream fis = new FileInputStream(file)) {
            byte[] data = new byte[(int) file.length()];
            fis.read(data);
            return new String(data, "UTF-8");
        } catch (IOException e) {
            return "File not found!";
        }
    }
    
    @PostMapping("/upload")
    public String uploadDocument(@RequestParam("filename") String filename, @RequestBody byte[] content) {
        try {
            java.nio.file.Files.write(java.nio.file.Paths.get("/var/www/uploads/" + filename), content);
            return "Upload success";
        } catch (Exception e) {
            return "Upload failed";
        }
    }
}
