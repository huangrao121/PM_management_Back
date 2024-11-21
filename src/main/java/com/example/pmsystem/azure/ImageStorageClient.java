package com.example.pmsystem.azure;

import java.io.IOException;
import java.io.InputStream;

public interface ImageStorageClient {
    String uploadImage(InputStream inputStream, long length, String originalName) throws IOException;
}
