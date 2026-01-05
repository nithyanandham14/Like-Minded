package com.likeminded.service;

import com.likeminded.dto.ProblemCreateRequest;
import com.likeminded.dto.ProblemResponse;
import com.likeminded.model.Problem;
import com.likeminded.model.ProblemStatus;
import com.likeminded.repository.ProblemRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ProblemService {

    private final ProblemRepository problemRepository;

    /**
     * Vendor creates a problem
     */
    public ProblemResponse createProblem(String vendorId, ProblemCreateRequest request) {

        Problem problem = Problem.builder()
                .title(request.getTitle())
                .description(request.getDescription())
                .deadline(request.getDeadline())
                .vendorId(vendorId)
                .build();

        return mapToResponse(problemRepository.save(problem));
    }

    /**
     * Users view all open problems
     */
    public List<ProblemResponse> getOpenProblems() {
        return problemRepository.findByStatus(ProblemStatus.OPEN)
                .stream()
                .map(this::mapToResponse)
                .collect(Collectors.toList());
    }

    /**
     * Vendor views problems posted by them
     */
    public List<ProblemResponse> getVendorProblems(String vendorId) {
        return problemRepository.findByVendorId(vendorId)
                .stream()
                .map(this::mapToResponse)
                .collect(Collectors.toList());
    }

    private ProblemResponse mapToResponse(Problem problem) {
        return ProblemResponse.builder()
                .problemId(problem.getId())
                .title(problem.getTitle())
                .description(problem.getDescription())
                .deadline(problem.getDeadline())
                .status(problem.getStatus())
                .build();
    }
}
