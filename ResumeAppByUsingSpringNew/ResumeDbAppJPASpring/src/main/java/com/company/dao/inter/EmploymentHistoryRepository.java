package com.company.dao.inter;

import com.company.entity.EmploymentHistory;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmploymentHistoryRepository extends JpaRepository<EmploymentHistory, Integer> {
}
