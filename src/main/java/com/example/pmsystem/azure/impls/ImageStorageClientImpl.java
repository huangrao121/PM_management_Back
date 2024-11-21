package com.example.pmsystem.azure.impls;

import com.azure.storage.blob.BlobClient;
import com.azure.storage.blob.BlobContainerClient;
import com.azure.storage.blob.BlobServiceClient;
import com.azure.storage.blob.models.BlobStorageException;
import com.example.pmsystem.azure.AzureBlobConfig;
import com.example.pmsystem.azure.AzureConfig;
import com.example.pmsystem.azure.ImageStorageClient;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.io.InputStream;
import java.util.UUID;

@Service
@Slf4j
public class ImageStorageClientImpl implements ImageStorageClient {

    private final BlobServiceClient bsc;

    @Override
    public String uploadImage(InputStream inputStream, long length, String imageNewName) throws IOException {
        try{
            BlobContainerClient bcc = bsc.getBlobContainerClient("pmsimages");
            BlobClient bc = bcc.getBlobClient(imageNewName);
            bc.upload(inputStream, length, true);
            return bc.getBlobUrl();
        }catch (BlobStorageException e){
            log.info("Azure upload image is not successfully: ", e);
        }
        return null;
    }

    @Autowired
    public ImageStorageClientImpl(BlobServiceClient bsc){
        this.bsc = bsc;
    }
}
