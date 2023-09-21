package com.hexagonal.api.application.useCases;

import com.hexagonal.api.domain.models.Task;
import com.hexagonal.api.domain.ports.in.CreateTaskUseCase;
import com.hexagonal.api.domain.ports.out.TaskRepositoryPort;

public class CreateTaskUseCaseImpl implements CreateTaskUseCase{
    private final TaskRepositoryPort taskRepositoryPort;

    public CreateTaskUseCaseImpl(TaskRepositoryPort taskRepositoryPort) {
        this.taskRepositoryPort = taskRepositoryPort;
    }
    
    
    @Override
    public Task createTask(Task task) {
        return taskRepositoryPort.save(task);
    }
    
}
