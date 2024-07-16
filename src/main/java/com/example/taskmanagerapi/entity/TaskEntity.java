package com.example.taskmanagerapi.entity;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
public class TaskEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private LocalDate creationDate;

    private LocalDate deadline;

    @ManyToOne
    @JoinColumn(name = "project_id")
    private ProjectEntity projectEntity;

    public TaskEntity() {
    }

    public TaskEntity(Long id, String name, LocalDate creationDate, LocalDate deadline, ProjectEntity projectEntity) {
        this.id = id;
        this.name = name;
        this.creationDate = creationDate;
        this.deadline = deadline;
        this.projectEntity = projectEntity;
    }

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

    public LocalDate getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(LocalDate creationDate) {
        this.creationDate = creationDate;
    }

    public LocalDate getDeadline() {
        return deadline;
    }

    public void setDeadline(LocalDate deadline) {
        this.deadline = deadline;
    }

    public ProjectEntity getProject() {
        return projectEntity;
    }

    public void setProject(ProjectEntity projectEntity) {
        this.projectEntity = projectEntity;
    }

    @Override
    public String toString() {
        return "TaskEntity{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", creationDate=" + creationDate +
                ", deadline=" + deadline +
                ", project=" + projectEntity +
                '}';
    }
}
