package com.likeminded.service;

import com.likeminded.dto.SubmissionRequest;
import com.likeminded.model.Submission;
import com.likeminded.repository.SubmissionRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class SubmissionService {

    private final SubmissionRepository submissionRepository;

    /**
     * User submits solution for a problem
     */
    public Submission submitSolution(String userId, SubmissionRequest request) {

        // Prevent duplicate submission by same team
        if (submissionRepository.existsByProblemIdAndTeamId(
                request.getProblemId(), request.getTeamId())) {
            throw new RuntimeException("Team has already submitted for this problem");
        }

        Submission submission = Submission.builder()
                .problemId(request.getProblemId())
                .teamId(request.getTeamId())
                .submittedByUserId(userId)
                .fileUrl(request.getFileUrl())
                .build();

        return submissionRepository.save(submission);
    }

    /**
     * Vendor views all submissions for a problem
     */
    public List<Submission> getSubmissionsByProblem(String problemId) {
        return submissionRepository.findByProblemId(problemId);
    }
}
