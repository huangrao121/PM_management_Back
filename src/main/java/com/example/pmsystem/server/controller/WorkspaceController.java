package com.example.pmsystem.server.controller;

import com.example.pmsystem.pojo.dto.WorkspaceDTO;
import com.example.pmsystem.pojo.vo.WorkspaceVO;
import com.example.pmsystem.resultTemplate.Result;
import com.example.pmsystem.server.service.WorkspaceService;
import lombok.extern.slf4j.Slf4j;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
@RequestMapping("/api/workspace")
public class WorkspaceController {

    @Autowired
    private WorkspaceService workspaceService;

    @PostMapping
    public Result<WorkspaceVO> createWorkspace(@RequestBody WorkspaceDTO workspaceDTO){
        try{
            workspaceService.createWorkspace(workspaceDTO);
            return Result.success();
        }catch(Exception e){
            //e.printStackTrace();
            return Result.error("creating workspace failed");
        }
    }
}
