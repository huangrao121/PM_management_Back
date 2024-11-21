package com.example.pmsystem.server.controller;

import com.example.pmsystem.pojo.dto.WorkspaceDTO;
import com.example.pmsystem.pojo.vo.WorkspaceVO;
import com.example.pmsystem.resultTemplate.Result;
import com.example.pmsystem.server.service.WorkspaceService;
import lombok.extern.slf4j.Slf4j;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@Slf4j
@RequestMapping("/api/workspace")
public class WorkspaceController {

    @Autowired
    private WorkspaceService workspaceService;

    @PostMapping(consumes = "multipart/form-data")
    public Result<WorkspaceVO> createWorkspace(@ModelAttribute WorkspaceDTO workspaceDTO){
        try{
            String image_url = workspaceService.createWorkspace(workspaceDTO);
            return Result.success(WorkspaceVO.builder().url(image_url).build());
        }catch(Exception e){
            //e.printStackTrace();
            return Result.error("creating workspace failed");
        }
    }
}
