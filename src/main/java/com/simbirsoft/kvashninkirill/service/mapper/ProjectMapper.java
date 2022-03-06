package com.simbirsoft.kvashninkirill.service.mapper;

import com.simbirsoft.kvashninkirill.dto.request.RequestProjectDto;
import com.simbirsoft.kvashninkirill.dto.response.ResponseProjectDto;
import com.simbirsoft.kvashninkirill.entity.Project;
import com.simbirsoft.kvashninkirill.exception.PersonNotFoundException;
import com.simbirsoft.kvashninkirill.repository.PersonRepository;
import org.springframework.stereotype.Component;

@Component
public class ProjectMapper {

    private final PersonRepository personRepository;

    public ProjectMapper(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }

    public Project toProject(RequestProjectDto requestProjectDto) {
        Project project = new Project();
        Long clientId = requestProjectDto.getClientId();
        project.setName(requestProjectDto.getName());
        project.setClient(personRepository.findById(clientId).orElseThrow(() -> new PersonNotFoundException(clientId)));
        project.setProjectStatus(requestProjectDto.getProjectStatus());
        return project;
    }

    public ResponseProjectDto toProjectDto(Project project) {
        ResponseProjectDto responseProjectDto = new ResponseProjectDto();
        responseProjectDto.setId(project.getId());
        responseProjectDto.setName(project.getName());
        responseProjectDto.setClientId(project.getClient().getId());
        responseProjectDto.setProjectStatus(project.getProjectStatus());
        return responseProjectDto;
    }
}
