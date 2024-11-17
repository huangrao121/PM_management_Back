package com.example.pmsystem.server.service.impls;

import com.example.pmsystem.pojo.dto.WorkspaceDTO;
import com.example.pmsystem.server.mapper.WorkspaceMapper;
import com.example.pmsystem.server.service.WorkspaceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class WorkspaceServiceImpl implements WorkspaceService {
    @Autowired
    private WorkspaceMapper workspaceMapper;
    @Override
    public void createWorkspace(WorkspaceDTO workspaceDTO) {
        workspaceMapper.createWorkspace(workspaceDTO);
    }
}
