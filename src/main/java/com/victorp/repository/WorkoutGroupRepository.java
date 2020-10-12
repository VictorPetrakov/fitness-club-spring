package com.victorp.repository;

import com.victorp.model.WorkoutGroup;
import org.springframework.data.jpa.repository.JpaRepository;

public interface WorkoutGroupRepository extends JpaRepository<WorkoutGroup, Long> {
}
