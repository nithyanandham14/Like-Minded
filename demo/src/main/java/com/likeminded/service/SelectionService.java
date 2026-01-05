package com.likeminded.service;

import com.likeminded.model.Selection;
import com.likeminded.repository.SelectionRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class SelectionService {

    private final SelectionRepository selectionRepository;

    /**
     * Vendor selects a winning submission
     */
    public Selection selectWinner(String vendorId, String problemId, String submissionId) {

        // Ensure only one winner per problem
        if (selectionRepository.existsByProblemId(problemId)) {
            throw new RuntimeException("Winner already selected for this problem");
        }

        Selection selection = Selection.builder()
                .problemId(problemId)
                .submissionId(submissionId)
                .vendorId(vendorId)
                .build();

        return selectionRepository.save(selection);
    }

    /**
     * View selected winner for a problem
     */
    public Selection getWinnerByProblem(String problemId) {
        return selectionRepository.findByProblemId(problemId)
                .orElseThrow(() -> new RuntimeException("Winner not selected yet"));
    }
}
