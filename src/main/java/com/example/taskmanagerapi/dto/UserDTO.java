package com.example.taskmanagerapi.dto;

import com.example.taskmanagerapi.entity.ProjectEntity;
import com.example.taskmanagerapi.entity.UserEntity;

import java.util.ArrayList;
import java.util.List;

public class UserDTO {
    private Long id;
    private String username;
    private String password;
    private List<ProjectDTO> projectDTOS;

    public UserDTO() {
    }

    public UserDTO(Long id, String username, String password, List<ProjectDTO> projectDTOS) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.projectDTOS = projectDTOS;
    }

    public UserDTO(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public List<ProjectDTO> getProjects() {
        return projectDTOS;
    }

    public void setProjects(List<ProjectDTO> projectDTOS) {
        this.projectDTOS = projectDTOS;
    }

    @Override
    public String toString() {
        return "UserDTO{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", projectDTOS=" + projectDTOS +
                '}';
    }

    public void convertToDTO(UserEntity userEntity) {
        List<ProjectDTO> projectDTOS = new ArrayList<>();
        List<ProjectEntity> projectEntities = userEntity.getProjects();
        for(int i = 0; i < projectEntities.size(); i++) {
            ProjectDTO projectDTO = new ProjectDTO();
            projectDTO.converttoDTO(projectEntities.get(i));
            projectDTOS.add(projectDTO);
        }
        this.id = userEntity.getId();
        this.username = userEntity.getUsername();
        this.password = userEntity.getPassword();
        this.projectDTOS = projectDTOS;
//        return new UserDTO(
//                userEntity.getId(),
//                userEntity.getUsername(),
//                userEntity.getPassword(),
//                projectDTOS
//        ); // Include projects if needed
    }

    public UserEntity convertToEntity() {
//        List<ProjectDTO> projectDTOS = this.getProjects();
//        List<ProjectEntity> projectEntities = new ArrayList<>();
//        for(int i = 0; i<projectDTOS.size(); i++){
//            ProjectEntity projectEntity = projectDTOS.get(i).converttoEntity();
//            projectEntities.add(projectEntity);
//        }

        return new UserEntity(
                this.getUsername(),
                this.getPassword()
        );
    }
}
