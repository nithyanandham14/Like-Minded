package com.likeminded.dto;

import lombok.Data;

import java.util.List;

@Data
public class TeamCreateRequest {

    private String teamName;
    private List<String> memberUserIds;
}
