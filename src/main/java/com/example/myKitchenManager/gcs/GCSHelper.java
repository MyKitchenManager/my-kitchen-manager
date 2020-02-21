package com.example.myKitchenManager.gcs;

import com.google.cloud.storage.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.UUID;

public class GCSHelper {
    public static String upload(MultipartFile file) throws Exception{
        Storage storage = StorageOptions.getDefaultInstance().getService();
        BlobId blobId = BlobId.of("my-kitchen-manager", UUID.randomUUID() + file.getOriginalFilename());
        BlobInfo blobInfo = BlobInfo.newBuilder(blobId).setContentType(file.getContentType()).build();
        Blob blob = storage.create(blobInfo, file.getInputStream());
        return blob.getMediaLink();
    }
}
