package com.simbirsoft.kvashninkirill.service.mapper;

import com.simbirsoft.kvashninkirill.dto.request.RequestTaskDto;
import com.simbirsoft.kvashninkirill.dto.response.ResponseTaskDto;
import com.simbirsoft.kvashninkirill.entity.Task;
import com.simbirsoft.kvashninkirill.exception.PersonNotFoundException;
import com.simbirsoft.kvashninkirill.exception.ProjectNotFoundException;
import com.simbirsoft.kvashninkirill.exception.ReleaseNotFoundException;
import com.simbirsoft.kvashninkirill.repository.PersonRepository;
import com.simbirsoft.kvashninkirill.repository.ProjectRepository;
import com.simbirsoft.kvashninkirill.repository.ReleaseRepository;
import org.springframework.stereotype.Component;

@Component
public class TaskMapper {

    private final ProjectRepository projectRepository;
    private final ReleaseRepository releaseRepository;
    private final PersonRepository personRepository;

    public TaskMapper(ProjectRepository projectRepository, ReleaseRepository releaseRepository, PersonRepository personRepository) {
        this.projectRepository = projectRepository;
        this.releaseRepository = releaseRepository;
        this.personRepository = personRepository;
    }

    public Task toTask(RequestTaskDto requestTaskDto) {
        Task task = new Task();
        Long authorId = requestTaskDto.getAuthorId();
        Long executorId = requestTaskDto.getExecutorId();
        Long projectId = requestTaskDto.getProjectId();
        Long releaseId = requestTaskDto.getReleaseId();
        task.setName(requestTaskDto.getName());
        task.setDescription(requestTaskDto.getDescription());
        task.setAuthor(personRepository.findById(authorId).orElseThrow(() -> new PersonNotFoundException(authorId)));
        task.setExecutor(personRepository.findById(executorId).orElseThrow(() -> new PersonNotFoundException(executorId)));
        task.setTaskStatus(requestTaskDto.getTaskStatus());
        task.setProject(projectRepository.findById(projectId).orElseThrow(() -> new ProjectNotFoundException(projectId)));
        task.setRelease(releaseRepository.findById(releaseId).orElseThrow(() -> new ReleaseNotFoundException(releaseId)));
        return task;
    }

    public ResponseTaskDto toTaskDto(Task task) {
        ResponseTaskDto responseTaskDto = new ResponseTaskDto();
        responseTaskDto.setId(task.getId());
        responseTaskDto.setName(task.getName());
        responseTaskDto.setDescription(task.getDescription());
        responseTaskDto.setAuthorId(task.getAuthor().getId());
        responseTaskDto.setExecutorId(task.getExecutor().getId());
        responseTaskDto.setTaskStatus(task.getTaskStatus());
        responseTaskDto.setProjectId(task.getProject().getId());
        responseTaskDto.setReleaseId(task.getRelease().getId());
        return responseTaskDto;
    }
}
