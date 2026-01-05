package com.likeminded.repository;

import com.likeminded.model.Submission;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface SubmissionRepository extends JpaRepository<Submission, String> {

    List<Submission> findByProblemId(String problemId);

    List<Submission> findByTeamId(String teamId);

    boolean existsByProblemIdAndTeamId(String problemId, String teamId);
}
