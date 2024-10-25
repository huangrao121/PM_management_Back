package com.example.pmsystem.server.service.impls;

import com.example.pmsystem.server.mapper.ProjectMapper;
import com.example.pmsystem.server.service.ProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProjectServiceImpl implements ProjectService {

    @Autowired
    private ProjectMapper projectMapper;


}
