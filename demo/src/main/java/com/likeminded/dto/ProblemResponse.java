package com.likeminded.dto;

import com.likeminded.model.ProblemStatus;
import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@Builder
public class ProblemResponse {

    private String problemId;
    private String title;
    private String description;
    private LocalDateTime deadline;
    private ProblemStatus status;
}
