package com.likeminded.dto;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class ProblemCreateRequest {

    private String title;
    private String description;
    private LocalDateTime deadline;
}
