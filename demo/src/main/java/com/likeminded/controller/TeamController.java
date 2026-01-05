package com.likeminded.controller;

import com.likeminded.dto.TeamCreateRequest;
import com.likeminded.model.Team;
import com.likeminded.service.TeamService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/teams")
@RequiredArgsConstructor
public class TeamController {

    private final TeamService teamService;

    @PostMapping("/create")
    public Team createTeam(
            Authentication authentication,
            @RequestBody TeamCreateRequest request) {

        String leaderUserId = authentication.getName();
        return teamService.createTeam(leaderUserId, request);
    }
}
