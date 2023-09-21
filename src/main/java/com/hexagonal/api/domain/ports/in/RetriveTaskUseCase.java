/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.hexagonal.api.domain.ports.in;

import com.hexagonal.api.domain.models.Task;
import java.util.Optional;
import java.util.List;

/**
 *
 * @author auxsistemas3
 */
public interface RetriveTaskUseCase {
    Optional<Task> getTask(Long id);
    List<Task> getTaskList();
}
