package com.example.myKitchenManager.controller;

import com.example.myKitchenManager.gcs.GCSHelper;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@RestController
public class GCSController {
    @PostMapping("/uploadimage")
    public String uploadToGCS(@RequestParam(value = "image", required = true) MultipartFile image) throws Exception {
        return GCSHelper.upload(image);
    }
}
