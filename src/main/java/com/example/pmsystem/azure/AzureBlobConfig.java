package com.example.pmsystem.azure;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Data
@ConfigurationProperties(prefix = "azure")
public class AzureBlobConfig {
    private String containerName;
    private String endpoint;
}
