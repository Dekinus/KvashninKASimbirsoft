package com.simbirsoft.kvashninkirill.controller;

import com.simbirsoft.kvashninkirill.dto.request.RequestProjectDto;
import com.simbirsoft.kvashninkirill.dto.response.ResponseProjectDto;
import com.simbirsoft.kvashninkirill.service.ProjectService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/project")
@Tag(name = "Проект")
public class ProjectController {
    private final ProjectService projectService;

    public ProjectController(ProjectService projectService) {
        this.projectService = projectService;
    }

    @Operation(summary = "Записать в базу данных проект")
    @PostMapping
    public ResponseEntity<ResponseProjectDto> createProject(@RequestBody RequestProjectDto requestProjectDto) {
        return ResponseEntity.ok(projectService.createProject(requestProjectDto));
    }

    @Operation(summary = "Обновить данные проекта")
    @PutMapping("/{id}")
    public ResponseEntity<ResponseProjectDto> editProject(@PathVariable Long id, @RequestBody RequestProjectDto requestProjectDto) {
        return ResponseEntity.ok(projectService.editProject(id, requestProjectDto));
    }

    @Operation(summary = "Найти проект по id")
    @GetMapping("/{id}")
    public ResponseEntity<ResponseProjectDto> getProject(@PathVariable Long id) {
        return ResponseEntity.ok(projectService.getProject(id));
    }

    @Operation(summary = "Найти все проекты")
    @GetMapping("/all")
    public ResponseEntity<List<ResponseProjectDto>> getAllProject() {
        return ResponseEntity.ok(projectService.getAll());
    }

    @Operation(summary = "Удалить проект по id")
    @DeleteMapping("/{id}")
    public String deleteProject(@PathVariable Long id) {
        projectService.deleteProject(id);
        return "Project deleted";
    }
}
