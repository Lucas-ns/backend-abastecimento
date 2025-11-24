package com.dimensionalengenharia.backend.services;

import com.microsoft.graph.models.DriveItem;
import com.microsoft.graph.serviceclient.GraphServiceClient;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.io.InputStream;

@Service
public class SharePointService {

    private final GraphServiceClient graphClient;

    @Value("${SHAREPOINT_DRIVE_ID}")
    private String driveId;

    public SharePointService(GraphServiceClient graphClient) {
        this.graphClient = graphClient;
    }

    public String uploadFile(MultipartFile file, String folder) throws IOException {
        String filename = file.getOriginalFilename();

        try (InputStream inputStream = file.getInputStream()) {
            DriveItem uploadedItem = graphClient.drives()
                    .byDriveId(driveId)
                    .items()
                    .byDriveItemId("root:/Teste/" + folder + "/" + filename + ":")
                    .content()
                    .put(inputStream);

            if (uploadedItem != null) {
                return uploadedItem.getWebUrl();
            }

            return null;
        } catch (Exception e) {
            throw new RuntimeException("Erro ao fazer upload para ao Sharepoint: " + e.getMessage());
        }
    }
}
