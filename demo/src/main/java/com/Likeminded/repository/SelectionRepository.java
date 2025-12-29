package com.likeminded.repository;

import com.likeminded.model.Selection;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface SelectionRepository extends JpaRepository<Selection, String> {

    boolean existsByProblemId(String problemId);

    Optional<Selection> findByProblemId(String problemId);
}
