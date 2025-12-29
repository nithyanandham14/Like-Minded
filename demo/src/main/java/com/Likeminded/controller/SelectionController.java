package com.likeminded.controller;

import com.likeminded.model.Selection;
import com.likeminded.service.SelectionService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/selection")
@RequiredArgsConstructor
public class SelectionController {

    private final SelectionService selectionService;

    /**
     * VENDOR selects the winning submission
     */
    @PostMapping("/select")
    public Selection selectWinner(
            Authentication authentication,
            @RequestParam String problemId,
            @RequestParam String submissionId) {

        String vendorId = authentication.getName(); // from JWT
        return selectionService.selectWinner(vendorId, problemId, submissionId);
    }

    /**
     * View winner for a problem
     */
    @GetMapping("/problem/{problemId}")
    public Selection getWinner(@PathVariable String problemId) {
        return selectionService.getWinnerByProblem(problemId);
    }
}
