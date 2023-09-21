
package com.hexagonal.api.application.useCases;

import com.hexagonal.api.domain.ports.in.DeleteTaskUseCase;
import com.hexagonal.api.domain.ports.out.TaskRepositoryPort;

public class DeleteTaskUseCaseImpl implements DeleteTaskUseCase{
    private final TaskRepositoryPort taskRepositoryPort;

    public DeleteTaskUseCaseImpl(TaskRepositoryPort taskRepositoryPort) {
        this.taskRepositoryPort = taskRepositoryPort;
    }
    
    @Override
    public Boolean deleteTask(Long id) {
        return taskRepositoryPort.deleteById(id);
    }
    
}
