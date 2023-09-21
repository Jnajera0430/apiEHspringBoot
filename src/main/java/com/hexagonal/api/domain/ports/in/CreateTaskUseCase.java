/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.hexagonal.api.domain.ports.in;

import com.hexagonal.api.domain.models.Task;

/**
 *
 * @author auxsistemas3
 */
public interface CreateTaskUseCase {
    Task createTask(Task task);
}
