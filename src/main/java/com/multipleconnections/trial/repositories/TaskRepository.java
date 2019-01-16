package com.multipleconnections.trial.repositories;

import com.multipleconnections.trial.models.Task;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface TaskRepository extends CrudRepository<Task, Long> {

    List<Task> findAllByTasksperson_Id(Long id);
}
