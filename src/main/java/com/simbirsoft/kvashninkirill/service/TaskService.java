package com.simbirsoft.kvashninkirill.service;

import com.simbirsoft.kvashninkirill.dto.request.RequestTaskDto;
import com.simbirsoft.kvashninkirill.dto.response.ResponseTaskDto;

import java.util.List;

public interface TaskService {
    ResponseTaskDto createTask(RequestTaskDto requestTaskDto);

    ResponseTaskDto editTask(Long id, RequestTaskDto requestTaskDto);

    ResponseTaskDto getTask(Long id);

    void deleteTask(Long id);

    List<ResponseTaskDto> getAll();
}
