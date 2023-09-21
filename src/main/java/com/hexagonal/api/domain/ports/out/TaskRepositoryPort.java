/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.hexagonal.api.domain.ports.out;

import com.hexagonal.api.domain.models.Task;
import java.util.Optional;
import java.util.List;

/**
 *
 * @author auxsistemas3
 */
public interface TaskRepositoryPort {

    Task save(Task task);

    Optional<Task> findById(Long id);

    List<Task> findAll();

    Optional<Task> update(Long id, Task task);

    boolean deleteById(Long id);
}
