package com.example.taskmanagerapi.dto;

import com.example.taskmanagerapi.entity.TaskEntity;

import java.time.LocalDate;

public class TaskDTO {
    private Long id;
    private String name;
    private LocalDate creationDate;
    private LocalDate deadline;
    private ProjectDTO projectDTO;

    public TaskDTO() {
    }

    public TaskDTO(Long id, String name, LocalDate creationDate, LocalDate deadline, ProjectDTO projectDTO) {
        this.id = id;
        this.name = name;
        this.creationDate = creationDate;
        this.deadline = deadline;
        this.projectDTO = projectDTO;
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

    public ProjectDTO getProjectDTO() {
        return projectDTO;
    }

    public void setProjectDTO(ProjectDTO projectDTO) {
        this.projectDTO = projectDTO;
    }

    @Override
    public String toString() {
        return "TaskDTO{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", creationDate=" + creationDate +
                ", deadline=" + deadline +
                ", projectDTO=" + projectDTO +
                '}';
    }

    public TaskEntity convertToEntity(){
        return new TaskEntity(
                this.id,
                this.name,
                this.creationDate,
                this.deadline,
                this.projectDTO.converttoEntity()
        );
    }

    public TaskDTO convertToDTO(TaskEntity taskEntity){
        ProjectDTO projectDTO  = new ProjectDTO();
        projectDTO.converttoDTO(taskEntity.getProject());
        return new TaskDTO(
                this.id = taskEntity.getId(),
                this.name = taskEntity.getName(),
                this.creationDate = taskEntity.getCreationDate(),
                this.deadline = taskEntity.getDeadline(),
                this.projectDTO = projectDTO
        );
    }
}
