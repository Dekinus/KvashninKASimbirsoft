package com.simbirsoft.kvashninkirill.dto.request;

import com.simbirsoft.kvashninkirill.entity.status.ProjectStatus;

public class RequestProjectDto {
    private String name;
    private Long clientId;
    private ProjectStatus projectStatus;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getClientId() {
        return clientId;
    }

    public void setClientId(Long clientId) {
        this.clientId = clientId;
    }

    public ProjectStatus getProjectStatus() {
        return projectStatus;
    }

    public void setProjectStatus(ProjectStatus projectStatus) {
        this.projectStatus = projectStatus;
    }
}
