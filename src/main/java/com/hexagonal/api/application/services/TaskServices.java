package com.hexagonal.api.application.services;

import com.hexagonal.api.domain.models.AdditionalTasksInfo;
import com.hexagonal.api.domain.models.Task;
import com.hexagonal.api.domain.ports.in.CreateTaskUseCase;
import com.hexagonal.api.domain.ports.in.DeleteTaskUseCase;
import com.hexagonal.api.domain.ports.in.GetAdditionalTaskInfoUseCase;
import com.hexagonal.api.domain.ports.in.RetriveTaskUseCase;
import com.hexagonal.api.domain.ports.in.UpdateTaskUseCase;
import java.util.List;
import java.util.Optional;

public class TaskServices implements CreateTaskUseCase, DeleteTaskUseCase,
        GetAdditionalTaskInfoUseCase, RetriveTaskUseCase, UpdateTaskUseCase {

    private final CreateTaskUseCase createTaskUseCase;
    private final DeleteTaskUseCase deleteTaskUseCase;
    private final UpdateTaskUseCase updateTaskUseCase;
    private final RetriveTaskUseCase retriveTaskUseCase;
    private final GetAdditionalTaskInfoUseCase getAdditionalTaskUseCase;

    public TaskServices(CreateTaskUseCase createTaskUseCase, DeleteTaskUseCase 
            deleteTaskUseCase, UpdateTaskUseCase updateTaskUseCase, RetriveTaskUseCase
            retriveTaskUseCase, GetAdditionalTaskInfoUseCase getAdditionalTaskUseCase) {
        this.createTaskUseCase = createTaskUseCase;
        this.deleteTaskUseCase = deleteTaskUseCase;
        this.updateTaskUseCase = updateTaskUseCase;
        this.retriveTaskUseCase = retriveTaskUseCase;
        this.getAdditionalTaskUseCase = getAdditionalTaskUseCase;
    }

    @Override
    public Task createTask(Task task) {
        return createTaskUseCase.createTask(task);
    }

    @Override
    public Boolean deleteTask(Long id) {
        return deleteTaskUseCase.deleteTask(id);
    }

    @Override
    public AdditionalTasksInfo getAdditionalTaskInfo(Long id) {
        return getAdditionalTaskUseCase.getAdditionalTaskInfo(id);
    }

    @Override
    public Optional<Task> getTask(Long id) {
        return retriveTaskUseCase.getTask(id);
    }

    @Override
    public List<Task> getTaskList() {
        return retriveTaskUseCase.getTaskList();
    }

    @Override
    public Optional<Task> updateTask(Long id, Task task) {
        return updateTaskUseCase.updateTask(id, task);
    }

}
