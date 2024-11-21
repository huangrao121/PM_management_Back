package com.example.pmsystem.azure;

import com.azure.identity.DefaultAzureCredentialBuilder;

import com.azure.storage.blob.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableConfigurationProperties(AzureBlobConfig.class)
public class AzureConfig {


    private final AzureBlobConfig azureBlobConfig;
    @Autowired
    public AzureConfig(AzureBlobConfig azureBlobConfig){
        this.azureBlobConfig = azureBlobConfig;
    }
    @Bean
    public BlobServiceClient createBlobServiceClient(){
        return new BlobServiceClientBuilder()
                .endpoint(azureBlobConfig.getEndpoint())
                .credential(new DefaultAzureCredentialBuilder().build())
                .buildClient();
    }
}
