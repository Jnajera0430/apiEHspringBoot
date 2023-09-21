package com.hexagonal.api.application.useCases;

import com.hexagonal.api.domain.models.Task;
import com.hexagonal.api.domain.ports.in.UpdateTaskUseCase;
import com.hexagonal.api.domain.ports.out.TaskRepositoryPort;
import java.util.Optional;

public class UpdateTaskUseCaseImpl implements UpdateTaskUseCase{
    private final TaskRepositoryPort taskRepositoryPort;

    public UpdateTaskUseCaseImpl(TaskRepositoryPort taskRepositoryPort) {
        this.taskRepositoryPort = taskRepositoryPort;
    }
    
    @Override
    public Optional<Task> updateTask(Long id, Task task) {
        return taskRepositoryPort.update(id, task);
    }
    
    
    
}
