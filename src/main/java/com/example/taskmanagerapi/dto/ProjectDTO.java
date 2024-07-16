package com.example.taskmanagerapi.dto;

import com.example.taskmanagerapi.controller.UserController;
import com.example.taskmanagerapi.entity.ProjectEntity;
import com.example.taskmanagerapi.entity.TaskEntity;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class ProjectDTO {
    private Long id;
    private String name;
    private LocalDate creationDate;
    private LocalDate deadline;
    private String description;
    private String status;
    private UserDTO userDTO;
    private List<TaskDTO> taskDTOs;

    public ProjectDTO() {
    }

    public ProjectDTO(Long id, String name, LocalDate creationDate, LocalDate deadline, String description, String status, UserDTO userDTO, List<TaskDTO> taskDTOs) {
        this.id = id;
        this.name = name;
        this.creationDate = creationDate;
        this.deadline = deadline;
        this.description = description;
        this.status = status;
        this.userDTO = userDTO;
        this.taskDTOs = taskDTOs;
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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public UserDTO getUserDTO() {
        return userDTO;
    }

    public void setUserDTO(UserDTO userDTO) {
        this.userDTO = userDTO;
    }

    public List<TaskDTO> getTaskDTOs() {
        return taskDTOs;
    }

    public void setTaskDTOs(List<TaskDTO> taskDTOs) {
        this.taskDTOs = taskDTOs;
    }

    @Override
    public String toString() {
        return "ProjectDTO{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", creationDate=" + creationDate +
                ", deadline=" + deadline +
                ", description='" + description + '\'' +
                ", status='" + status + '\'' +
                ", userDTO=" + userDTO +
                ", taskDTOs=" + taskDTOs +
                '}';
    }

    public ProjectEntity converttoEntity() {
        List<TaskEntity> taskEntities = new ArrayList<>();
        for(int i= 0; i < this.getTaskDTOs().size(); i++){
            TaskEntity taskEntity = new TaskEntity(
                    this.getTaskDTOs().get(i).getId(),
                    this.getTaskDTOs().get(i).getName(),
                    this.getTaskDTOs().get(i).getCreationDate(),
                    this.getTaskDTOs().get(i).getDeadline(),
                    this.getTaskDTOs().get(i).getProjectDTO().converttoEntity()
            );

        }
        return new ProjectEntity(
                this.getId(),
                this.getName(),
                this.getCreationDate(),
                this.getDeadline(),
                this.getDescription(),
                this.getStatus(),
                this.getUserDTO().convertToEntity(),
                taskEntities

        );
    }

    public void converttoDTO(ProjectEntity projectEntity) {
        UserDTO userDTO = new UserDTO();
        userDTO.convertToDTO(projectEntity.getUser());
        List<TaskDTO> taskDTOs = new ArrayList<>();
        for(int i=0; i < projectEntity.getTasks().size(); i++){
            TaskDTO taskDTO = new TaskDTO();
            taskDTO.convertToDTO(projectEntity.getTasks().get(i));
            taskDTOs.add(taskDTO);
        }
        this.id = projectEntity.getId();
        this.name = projectEntity.getName();
        this.creationDate = projectEntity.getCreationDate();
        this.deadline = projectEntity.getDeadline();
        this.description = projectEntity.getDescription();
        this.status = projectEntity.getStatus();
        this.userDTO = userDTO;
        this.taskDTOs = taskDTOs;
//        return new ProjectDTO(
//                projectEntity.getId(),
//                projectEntity.getName(),
//                projectEntity.getCreationDate(),
//                projectEntity.getDeadline(),
//                projectEntity.getDescription(),
//                projectEntity.getStatus(),
//                userDTO,
//                taskDTOs
//        );
    }
}
