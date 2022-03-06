package com.simbirsoft.kvashninkirill.service.impl;

import com.simbirsoft.kvashninkirill.dto.request.RequestTaskDto;
import com.simbirsoft.kvashninkirill.dto.response.ResponseTaskDto;
import com.simbirsoft.kvashninkirill.entity.Task;
import com.simbirsoft.kvashninkirill.exception.TaskNotFoundException;
import com.simbirsoft.kvashninkirill.repository.TaskRepository;
import com.simbirsoft.kvashninkirill.service.TaskService;
import com.simbirsoft.kvashninkirill.service.mapper.TaskMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class TaskServiceImpl implements TaskService {

    private final TaskRepository taskRepository;
    private final TaskMapper taskMapper;

    public TaskServiceImpl(TaskRepository taskRepository, TaskMapper taskMapper) {
        this.taskRepository = taskRepository;
        this.taskMapper = taskMapper;
    }

    @Override
    public ResponseTaskDto createTask(RequestTaskDto requestTaskDto) {
        Task task = taskMapper.toTask(requestTaskDto);
        taskRepository.save(task);
        return taskMapper.toTaskDto(task);
    }

    @Override
    public ResponseTaskDto editTask(Long id, RequestTaskDto requestTaskDto) {
        taskRepository.findById(id).orElseThrow(() -> new TaskNotFoundException(id));
        Task task = taskMapper.toTask(requestTaskDto);
        task.setId(id);
        taskRepository.save(task);
        return taskMapper.toTaskDto(task);
    }

    @Override
    public ResponseTaskDto getTask(Long id) {
        Task task = taskRepository.findById(id).orElseThrow(() -> new TaskNotFoundException(id));
        return taskMapper.toTaskDto(task);
    }

    @Override
    public void deleteTask(Long id) {
        taskRepository.findById(id).orElseThrow(() -> new TaskNotFoundException(id));
        taskRepository.deleteById(id);
    }

    @Override
    public List<ResponseTaskDto> getAll() {
        return taskRepository.findAll().stream()
                .map(taskMapper::toTaskDto).collect(Collectors.toList());
    }
}
