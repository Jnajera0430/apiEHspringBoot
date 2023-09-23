package com.hexagonal.api.infrastructure.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hexagonal.api.application.services.TaskServices;
import com.hexagonal.api.domain.models.AdditionalTasksInfo;
import com.hexagonal.api.domain.models.Task;

@RestController
@RequestMapping("/api/task")
public class TaskController {
    private final TaskServices taskServices;

    public TaskController(TaskServices taskServices) {
        this.taskServices = taskServices;
    }

    @PostMapping
    public ResponseEntity<Task> createTask(@RequestBody Task task) {
        Task createdTask = this.taskServices.createTask(task);
        return new ResponseEntity<Task>(createdTask, HttpStatus.CREATED);
    }

    @GetMapping("/{taskId}")
    public ResponseEntity<Task> getTaskById(@PathVariable Long taskId) {
        Optional<Task> taskFound = this.taskServices.getTask(taskId);
        if (taskFound.isPresent())
            return new ResponseEntity<>(taskFound.get(), HttpStatus.OK);
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @GetMapping
    public ResponseEntity<List<Task>> getAllTask() {
        List<Task> tasks = this.taskServices.getTaskList();
        return new ResponseEntity<List<Task>>(tasks, HttpStatus.OK);
    }

    @PatchMapping("/{taskId}")
    public ResponseEntity<Task> patchUpdateTask(@PathVariable Long taskId, @RequestBody Task task) {
        Optional<Task> optionalUpdatedTask = this.taskServices.updateTask(taskId, task);
        if (optionalUpdatedTask.isPresent())
            return new ResponseEntity<Task>(optionalUpdatedTask.get(), HttpStatus.OK);

        return new ResponseEntity<>(HttpStatus.NOT_MODIFIED);

        // return this.taskServices.updateTask(taskId, task)
        //             .map(taskFound -> new ResponseEntity<>(taskFound, HttpStatus.OK))
        //             .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @DeleteMapping("/{taskId}")
    public ResponseEntity<HttpStatus> deleteTaskById(@PathVariable Long taskId){
        boolean deletedTask = this.taskServices.deleteTask(taskId);
        if(deletedTask) return new ResponseEntity<HttpStatus>(HttpStatus.NO_CONTENT);
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @GetMapping("/{taskId}/additionalInfo")
    public ResponseEntity<AdditionalTasksInfo> getAdditionalInfo(@PathVariable Long taskId){
        AdditionalTasksInfo additionalInfoFound = this.taskServices.getAdditionalTaskInfo(taskId);
        return new ResponseEntity<AdditionalTasksInfo>(additionalInfoFound, HttpStatus.OK);
    }
}
