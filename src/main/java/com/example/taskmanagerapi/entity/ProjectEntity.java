package com.example.taskmanagerapi.entity;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.List;

@Entity
public class ProjectEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private LocalDate creationDate;

    private LocalDate deadline;

    private String description;

    private String status;

    @ManyToOne
    @JoinColumn(name ="user_id")
    private UserEntity userEntity;

    @OneToMany(cascade = CascadeType.ALL)
    private List<TaskEntity> taskEntities;

    public ProjectEntity() {
    }

    public ProjectEntity(Long id, String name, LocalDate creationDate, LocalDate deadline, String description, String status, UserEntity userEntity, List<TaskEntity> taskEntities) {
        this.id = id;
        this.name = name;
        this.creationDate = creationDate;
        this.deadline = deadline;
        this.description = description;
        this.status = status;
        this.userEntity = userEntity;
        this.taskEntities = taskEntities;
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

    public UserEntity getUser() {
        return userEntity;
    }

    public void setUser(UserEntity userEntity) {
        this.userEntity = userEntity;
    }

    public List<TaskEntity> getTasks() {
        return taskEntities;
    }

    public void setTasks(List<TaskEntity> taskEntities) {
        this.taskEntities = taskEntities;
    }

    @Override
    public String toString() {
        return "ProjectEntity{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", creationDate=" + creationDate +
                ", deadline=" + deadline +
                ", description='" + description + '\'' +
                ", status='" + status + '\'' +
                ", user=" + userEntity +
                ", tasks=" + taskEntities +
                '}';
    }
}
