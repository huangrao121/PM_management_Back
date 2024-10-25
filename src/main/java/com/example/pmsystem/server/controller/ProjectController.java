package com.example.pmsystem.server.controller;

import com.example.pmsystem.resultTemplate.Result;
import com.example.pmsystem.server.service.ProjectService;
import jakarta.servlet.http.HttpServletRequest;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
@RequestMapping("/api/projects")
public class ProjectController {
    @Autowired
    private ProjectService projectService;

    @GetMapping("/")
    public Result<String> getProjectList(HttpServletRequest request){
        log.info("The controller get info: {} and {}", (String)request.getAttribute("username"), (String)request.getAttribute("email"));

        return Result.success("get request success");
    }
}
