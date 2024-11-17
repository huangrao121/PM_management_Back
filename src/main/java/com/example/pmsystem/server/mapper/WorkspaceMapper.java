package com.example.pmsystem.server.mapper;

import com.example.pmsystem.pojo.dto.WorkspaceDTO;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface WorkspaceMapper {

    @Insert("insert into workspace (name, creater_id, creater_user_name) " +
            "values (#{name}, #{creater_id}, #{creater_user_name})")
    void createWorkspace(WorkspaceDTO workspaceDTO);
}
