package com.simbirsoft.kvashninkirill.repository;

import com.simbirsoft.kvashninkirill.entity.Task;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TaskRepository extends JpaRepository<Task, Long> {

}
