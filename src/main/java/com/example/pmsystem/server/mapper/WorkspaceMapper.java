package com.example.pmsystem.server.mapper;

import com.example.pmsystem.pojo.dto.WorkspaceDTO;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface WorkspaceMapper {

    @Insert("insert into workspace (name, creater_id, creater_user_name, image_url) " +
            "values (#{workspaceDTO.name}, #{workspaceDTO.creater_id}, #{workspaceDTO.creater_user_name}, #{url})")
    void createWorkspace(@Param("workspaceDTO") WorkspaceDTO workspaceDTO, @Param("url") String url);

//    @Insert("insert into workspace (name, creater_id, creater_user_name) " +
//            "values (#{name}, #{creater_id}, #{creater_user_name})")
//    void testCreateWS(WorkspaceDTO workspaceDTO);
}
