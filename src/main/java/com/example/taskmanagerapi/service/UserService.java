package com.example.taskmanagerapi.service;

import com.example.taskmanagerapi.dto.UserDTO;

import java.util.List;

public interface UserService {
    List<UserDTO> getAllUsers();
    UserDTO getUserById(Long id);
    void createUser(UserDTO userDTO);
    void updateUser(Long id, String username, String password);
    void deleteUser(Long id);
}
