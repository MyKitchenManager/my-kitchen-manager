package com.example.myKitchenManager.controller;

import com.example.myKitchenManager.gcs.GCSHelper;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.util.HashMap;
import java.util.Map;

@RestController
public class GCSController {
    @PostMapping("/uploadimage")
    public Map<String, String> uploadToGCS(@RequestParam(value = "image", required = true) MultipartFile image) throws Exception {
        Map<String, String> res = new HashMap<>();
        String url = GCSHelper.upload(image);
        res.put("image_url", url);
        return res;
    }
}
