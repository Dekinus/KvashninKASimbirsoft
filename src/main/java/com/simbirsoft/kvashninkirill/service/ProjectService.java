package com.simbirsoft.kvashninkirill.service;


import com.simbirsoft.kvashninkirill.dto.request.RequestProjectDto;
import com.simbirsoft.kvashninkirill.dto.response.ResponseProjectDto;

import java.util.List;

public interface ProjectService {
    ResponseProjectDto createProject(RequestProjectDto requestProjectDto);

    ResponseProjectDto editProject(Long id, RequestProjectDto requestProjectDto);

    ResponseProjectDto getProject(Long id);

    void deleteProject(Long id);

    List<ResponseProjectDto> getAll();
}
