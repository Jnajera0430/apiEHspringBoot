package com.hexagonal.api.infrastructure.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.hexagonal.api.infrastructure.entities.TaskEntity;

@Repository
public interface JPATaskRepository extends JpaRepository<TaskEntity, Long> {
}
