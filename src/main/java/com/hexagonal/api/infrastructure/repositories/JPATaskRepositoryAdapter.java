package com.hexagonal.api.infrastructure.repositories;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.stereotype.Component;

import com.hexagonal.api.domain.models.Task;
import com.hexagonal.api.domain.ports.out.TaskRepositoryPort;
import com.hexagonal.api.infrastructure.entities.TaskEntity;

@Component
public class JPATaskRepositoryAdapter implements TaskRepositoryPort{
    private final JPATaskRepository jpaTaskRepository;
    public JPATaskRepositoryAdapter(JPATaskRepository jpaTaskRepository) {
        this.jpaTaskRepository = jpaTaskRepository;
    }

    @Override
    public boolean deleteById(Long id) {
        if(jpaTaskRepository.existsById(id)){
            jpaTaskRepository.deleteById(id);
            return true;
        }
        return false;
    }

    @Override
    public List<Task> findAll() {
        return jpaTaskRepository.findAll().stream()
        .map(TaskEntity::toDomainModel)
        .collect(Collectors.toList() );
    }

    @Override
    public Optional<Task> findById(Long id) {
        return jpaTaskRepository.findById(id).map(TaskEntity::toDomainModel);
    }

    @Override
    public Task save(Task task) {
        TaskEntity taskEntity = TaskEntity.fromDomainModel(task);
        TaskEntity savedTaskEntity = jpaTaskRepository.save(taskEntity);
        return savedTaskEntity.toDomainModel();
    }

    @Override
    public Optional<Task> update(Long id, Task task) {
        if(jpaTaskRepository.existsById(id)){
            TaskEntity taskEntity = TaskEntity.fromDomainModel(task);
            TaskEntity updatedTaskEntity = jpaTaskRepository.save(taskEntity);
            return Optional.of(updatedTaskEntity.toDomainModel());
        }
        return Optional.empty();
    }
    
}
