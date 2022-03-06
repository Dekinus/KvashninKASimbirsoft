package com.simbirsoft.kvashninkirill.controller;

import com.simbirsoft.kvashninkirill.dto.request.RequestTaskDto;
import com.simbirsoft.kvashninkirill.dto.response.ResponseTaskDto;
import com.simbirsoft.kvashninkirill.service.TaskService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/task")
@Tag(name = "Задача")
public class TaskController {

    private final TaskService taskService;

    public TaskController(TaskService taskService) {
        this.taskService = taskService;
    }


    @Operation(summary = "Записать задачу в базу данных ")
    @PostMapping
    public ResponseEntity<ResponseTaskDto> createTask(@RequestBody RequestTaskDto requestTaskDto) {
        return ResponseEntity.ok(taskService.createTask(requestTaskDto));
    }

    @Operation(summary = "Обновить данные релиза")
    @PutMapping("/{id}")
    public ResponseEntity<ResponseTaskDto> editTask(@PathVariable Long id, @RequestBody RequestTaskDto requestTaskDto) {
        return ResponseEntity.ok(taskService.editTask(id, requestTaskDto));
    }

    @Operation(summary = "Найти задачу по id")
    @GetMapping("/{id}")
    public ResponseEntity<ResponseTaskDto> getTask(@PathVariable Long id) {
        return ResponseEntity.ok(taskService.getTask(id));
    }

    @Operation(summary = "Найти все задачи")
    @GetMapping("/all")
    public ResponseEntity<List<ResponseTaskDto>> getAllTask() {
        return ResponseEntity.ok(taskService.getAll());
    }

    @Operation(summary = "Удалить задачу")
    @DeleteMapping("/{id}")
    public String deleteTask(@PathVariable Long id) {
        taskService.deleteTask(id);
        return "Task deleted";
    }

}
