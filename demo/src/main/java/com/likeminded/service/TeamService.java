package com.likeminded.service;

import com.likeminded.dto.TeamCreateRequest;
import com.likeminded.model.Team;
import com.likeminded.model.TeamMember;
import com.likeminded.repository.TeamMemberRepository;
import com.likeminded.repository.TeamRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class TeamService {

    private final TeamRepository teamRepository;
    private final TeamMemberRepository teamMemberRepository;

    public Team createTeam(String leaderUserId, TeamCreateRequest request) {

        Team team = Team.builder()
                .teamName(request.getTeamName())
                .leaderUserId(leaderUserId)
                .build();

        Team savedTeam = teamRepository.save(team);

        // Add leader
        teamMemberRepository.save(
                TeamMember.builder()
                        .teamId(savedTeam.getId())
                        .userId(leaderUserId)
                        .build()
        );

        // Add members
        request.getMemberUserIds().forEach(userId ->
                teamMemberRepository.save(
                        TeamMember.builder()
                                .teamId(savedTeam.getId())
                                .userId(userId)
                                .build()
                )
        );

        return savedTeam;
    }
}
