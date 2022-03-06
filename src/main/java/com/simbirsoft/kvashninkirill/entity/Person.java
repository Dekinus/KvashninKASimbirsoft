package com.simbirsoft.kvashninkirill.entity;

import javax.persistence.*;
import java.util.List;

@Entity
public class Person {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "name", nullable = false)
    private String name;

    @OneToMany(mappedBy = "client")
    List<Project> clientProjectList;

    @OneToMany(mappedBy = "author")
    List<Task> authorTaskList;

    @OneToMany(mappedBy = "executor")
    List<Task> executorTaskList;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Project> getClientProjectList() {
        return clientProjectList;
    }

    public void setClientProjectList(List<Project> clientProjectList) {
        this.clientProjectList = clientProjectList;
    }

    public List<Task> getAuthorTaskList() {
        return authorTaskList;
    }

    public void setAuthorTaskList(List<Task> authorTaskList) {
        this.authorTaskList = authorTaskList;
    }

    public List<Task> getExecutorTaskList() {
        return executorTaskList;
    }

    public void setExecutorTaskList(List<Task> executorTaskList) {
        this.executorTaskList = executorTaskList;
    }
}
