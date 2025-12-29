package com.likeminded.dto;

import lombok.Data;

@Data
public class SubmissionRequest {

    private String problemId;
    private String teamId;
    private String fileUrl;   // Solution link
}
