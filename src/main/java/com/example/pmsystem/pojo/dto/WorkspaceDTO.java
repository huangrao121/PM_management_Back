package com.example.pmsystem.pojo.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.multipart.MultipartFile;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class WorkspaceDTO {
    private String name;
    private String creater_user_name;
    private int creater_id;
    private MultipartFile workspace_image;
}
