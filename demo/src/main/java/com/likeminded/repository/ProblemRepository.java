package com.likeminded.repository;

import com.likeminded.model.Problem;
import com.likeminded.model.ProblemStatus;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProblemRepository extends JpaRepository<Problem, String> {

    List<Problem> findByStatus(ProblemStatus status);

    List<Problem> findByVendorId(String vendorId);

    int countByVendorId(String vendorId);

    int countByVendorIdAndStatus(String vendorId, String open);

}
