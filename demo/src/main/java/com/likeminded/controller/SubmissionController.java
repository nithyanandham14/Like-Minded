package com.likeminded.controller;

import com.likeminded.dto.SubmissionRequest;
import com.likeminded.model.Submission;
import com.likeminded.service.SubmissionService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/submissions")
@RequiredArgsConstructor
public class SubmissionController {

    private final SubmissionService submissionService;

    /**
     * USER submits solution
     */
    @PostMapping("/submit")
    public Submission submitSolution(
            Authentication authentication,
            @RequestBody SubmissionRequest request) {

        String userId = authentication.getName(); // From JWT
        return submissionService.submitSolution(userId, request);
    }

    /**
     * VENDOR views submissions for a problem
     */
    @GetMapping("/problem/{problemId}")
    public List<Submission> getSubmissionsForProblem(@PathVariable String problemId) {
        return submissionService.getSubmissionsByProblem(problemId);
    }
}
