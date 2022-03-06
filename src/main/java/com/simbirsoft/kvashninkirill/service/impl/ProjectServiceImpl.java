package com.simbirsoft.kvashninkirill.service.impl;

import com.simbirsoft.kvashninkirill.dto.request.RequestProjectDto;
import com.simbirsoft.kvashninkirill.dto.response.ResponseProjectDto;
import com.simbirsoft.kvashninkirill.entity.Project;
import com.simbirsoft.kvashninkirill.exception.ProjectNotFoundException;
import com.simbirsoft.kvashninkirill.repository.ProjectRepository;
import com.simbirsoft.kvashninkirill.service.ProjectService;
import com.simbirsoft.kvashninkirill.service.mapper.ProjectMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProjectServiceImpl implements ProjectService {

    private final ProjectRepository projectRepository;
    private final ProjectMapper projectMapper;

    public ProjectServiceImpl(ProjectRepository projectRepository, ProjectMapper projectMapper) {
        this.projectRepository = projectRepository;
        this.projectMapper = projectMapper;
    }

    @Override
    public ResponseProjectDto createProject(RequestProjectDto requestProjectDto) {
        Project project = projectMapper.toProject(requestProjectDto);
        projectRepository.save(project);
        return projectMapper.toProjectDto(project);
    }

    @Override
    public ResponseProjectDto editProject(Long id, RequestProjectDto requestProjectDto) {
        projectRepository.findById(id).orElseThrow(() -> new ProjectNotFoundException(id));
        Project project = projectMapper.toProject(requestProjectDto);
        project.setId(id);
        projectRepository.save(project);
        return projectMapper.toProjectDto(project);
    }

    @Override
    public ResponseProjectDto getProject(Long id) {
        Project project = projectRepository.findById(id).orElseThrow(() -> new ProjectNotFoundException(id));
        return projectMapper.toProjectDto(project);
    }

    @Override
    public void deleteProject(Long id) {
        projectRepository.findById(id).orElseThrow(() -> new ProjectNotFoundException(id));
        projectRepository.deleteById(id);
    }

    @Override
    public List<ResponseProjectDto> getAll() {
        return projectRepository.findAll().stream()
                .map(projectMapper::toProjectDto).collect(Collectors.toList());
    }
}
