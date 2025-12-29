package com.likeminded.repository;

import com.likeminded.model.Team;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TeamRepository extends JpaRepository<Team, String> {

    List<Team> findByLeaderUserId(String leaderUserId);
}
