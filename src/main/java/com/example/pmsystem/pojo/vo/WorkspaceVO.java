package com.example.pmsystem.pojo.vo;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class WorkspaceVO {
    private String name;
    private String creater_name;
    private int creater_id;
    private String url;
}
