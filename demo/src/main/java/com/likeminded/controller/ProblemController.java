package com.likeminded.controller;

import com.likeminded.dto.ProblemCreateRequest;
import com.likeminded.dto.ProblemResponse;
import com.likeminded.model.Problem;
import com.likeminded.service.ProblemService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/problems")
@RequiredArgsConstructor
public class ProblemController {

    private final ProblemService problemService;

    /**
     * Vendor posts a problem
     */
    @PostMapping("/vendor/create")
    public ProblemResponse createProblem(
            Authentication authentication,
            @RequestBody ProblemCreateRequest request) {

        String vendorId = authentication.getName(); // from JWT
        return problemService.createProblem(vendorId, request);
    }

    /**
     * Users view open problems
     */
    @GetMapping("/open")
    public List<ProblemResponse> getOpenProblems() {
        return problemService.getOpenProblems();
    }

    /**
     * Vendor views their problems
     */
    @GetMapping("/vendor/my-problems")
    public List<ProblemResponse> getVendorProblems(Authentication authentication) {
        String vendorId = authentication.getName();
        return problemService.getVendorProblems(vendorId);
    }
    @GetMapping("{problemid}")
    public ProblemResponse getProblem(@PathVariable String problemid)
    {
     return problemService.getProblem(problemid);
    }
}
