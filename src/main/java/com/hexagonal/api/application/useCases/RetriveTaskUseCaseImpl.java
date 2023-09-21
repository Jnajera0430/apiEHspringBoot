package com.hexagonal.api.application.useCases;

import com.hexagonal.api.domain.models.Task;
import com.hexagonal.api.domain.ports.in.RetriveTaskUseCase;
import com.hexagonal.api.domain.ports.out.TaskRepositoryPort;
import java.util.List;
import java.util.Optional;

public class RetriveTaskUseCaseImpl implements RetriveTaskUseCase{
    private final TaskRepositoryPort taskRepositoryPort;

    public RetriveTaskUseCaseImpl(TaskRepositoryPort taskRepositoryPort) {
        this.taskRepositoryPort = taskRepositoryPort;
    }
    
    @Override
    public Optional<Task> getTask(Long id) {
        return taskRepositoryPort.findById(id);
    }

    @Override
    public List<Task> getTaskList() {
        return taskRepositoryPort.findAll();
    }
    
}
