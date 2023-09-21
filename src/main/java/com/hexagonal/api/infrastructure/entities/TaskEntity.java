package com.hexagonal.api.infrastructure.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import java.time.LocalDateTime;
import com.hexagonal.api.domain.models.Task;
@Entity
public class TaskEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY )
    private Long id;
    
    private String title;
    
    private String description;
    
    private LocalDateTime createdAt;
    
    private Boolean state;

    public TaskEntity() {
    }

    public TaskEntity(Long id, String title, String description, 
            LocalDateTime createdAt, Boolean state) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.createdAt = createdAt;
        this.state = state;
    }
    
    public static TaskEntity fromDomainModel(Task task){
        return new TaskEntity(task.getId(), task.getTitle(), task.getDescription(), 
                task.getCreatedAt(), task.getState());
    }

    public Task toDomainModel(){
        return new Task(id,title,description,createdAt,state);
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public Boolean getState() {
        return state;
    }

    public void setState(Boolean state) {
        this.state = state;
    }
    
    
}
