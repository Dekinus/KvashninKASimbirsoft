package com.simbirsoft.kvashninkirill.repository;

import com.simbirsoft.kvashninkirill.entity.Project;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProjectRepository extends JpaRepository<Project, Long> {
}
