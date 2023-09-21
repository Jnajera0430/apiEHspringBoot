/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.hexagonal.api.domain.ports.in;

import com.hexagonal.api.domain.models.Task;
import java.util.Optional;

/**
 *
 * @author auxsistemas3
 */
public interface UpdateTaskUseCase {
    Optional<Task> updateTask(Long id, Task task);
}
