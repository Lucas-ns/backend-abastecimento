package com.dimensionalengenharia.backend.configuration;

import com.azure.identity.ClientSecretCredentialBuilder;
import com.microsoft.graph.serviceclient.GraphServiceClient;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class GraphConfig {

    @Value("${SHAREPOINT_TENANT_ID}")
    private String tenantId;
    @Value("${SHAREPOINT_CLIENT_ID}")
    private String clientId;
    @Value("${SHAREPOINT_CLIENT_SECRET}")
    private String clientSecret;

    @Bean
    public GraphServiceClient graphClient() {
        final var credential = new ClientSecretCredentialBuilder()
                .tenantId(tenantId)
                .clientId(clientId)
                .clientSecret(clientSecret)
                .build();

        return new GraphServiceClient(credential, "https://graph.microsoft.com/.default");
    }
}
