package com.dimensionalengenharia.backend.controllers;

import com.dimensionalengenharia.backend.services.FileStorageService;
import com.dimensionalengenharia.backend.services.SharePointService;
import com.microsoft.graph.models.DriveItem;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.method.annotation.MvcUriComponentsBuilder;

import java.util.*;

@RestController
@RequestMapping("/files")
public class FileUploadController {

    private final FileStorageService storageService;
    private final SharePointService sharePointService;
    @Value("${PREFIX_URL}")
    private String PREFIX_URL;

    public FileUploadController(FileStorageService storageService, SharePointService sharePointService) {
        this.storageService = storageService;
        this.sharePointService = sharePointService;
    }

    @PostMapping("/upload")
    public ResponseEntity<?> uploadFile(@RequestParam("file") MultipartFile file) {
        try {
            String filename = storageService.save(file);
            String url = PREFIX_URL + MvcUriComponentsBuilder
                    .fromMethodName(FileUploadController.class, "getFile", filename).build().getPath();

            Map<String, String> response = new HashMap<>();
            response.put("url_image", url);
            return ResponseEntity.status(HttpStatus.OK).body(response);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.EXPECTATION_FAILED).body("Could not upload the file: " + file.getOriginalFilename() + "!");
        }
    }

    @GetMapping(value = "/{filename:.+}", produces = MediaType.IMAGE_PNG_VALUE)
    public ResponseEntity<byte[]> getFile(@PathVariable String filename) {
        byte[] img = storageService.load(filename);
        return ResponseEntity.ok().contentType(MediaType.IMAGE_PNG).body(img);
    }


    @PostMapping("/upload/sharepoint")
    public ResponseEntity<?> uploadFileSharepoint(@RequestParam("file") MultipartFile file, @RequestParam String folder) {
        try {
            Map<String, String> response = new HashMap<>();
            response.put("url_image", sharePointService.uploadFile(file, folder));
            return ResponseEntity.status(HttpStatus.OK).body(response);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.EXPECTATION_FAILED).body("Could not upload the file: " + file.getOriginalFilename() + "!");
        }
    }

}
