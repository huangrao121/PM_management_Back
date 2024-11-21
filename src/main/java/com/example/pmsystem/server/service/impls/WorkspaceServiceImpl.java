package com.example.pmsystem.server.service.impls;

import com.example.pmsystem.azure.impls.ImageStorageClientImpl;
import com.example.pmsystem.pojo.dto.WorkspaceDTO;
import com.example.pmsystem.server.mapper.WorkspaceMapper;
import com.example.pmsystem.server.service.WorkspaceService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.io.InputStream;
import java.util.UUID;

@Service
@Slf4j
public class WorkspaceServiceImpl implements WorkspaceService {

    private final WorkspaceMapper workspaceMapper;
    private final ImageStorageClientImpl isci;
    @Override
    //@Transactional
    public String createWorkspace(WorkspaceDTO workspaceDTO) {
        MultipartFile image = workspaceDTO.getWorkspace_image();
        String file_name = image.getOriginalFilename();
        long length = image.getSize();
        try{
            String imageNewName = UUID.randomUUID() + file_name.substring(file_name.lastIndexOf("."));
            System.out.println("new image name is: " + imageNewName);
            String url = isci.uploadImage(image.getInputStream(),length,imageNewName);

            //workspaceMapper.testCreateWS(workspaceDTO);
            workspaceMapper.createWorkspace(workspaceDTO, url);

            return url;
        }catch (IOException e){
            log.info("Create workspace failed: "+ e.getMessage());
        }
        return null;
    }

    @Autowired
    public WorkspaceServiceImpl(WorkspaceMapper workspaceMapper, ImageStorageClientImpl isci){
        this.workspaceMapper = workspaceMapper;
        this.isci = isci;
    }
}
