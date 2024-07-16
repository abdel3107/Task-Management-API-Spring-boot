package com.example.taskmanagerapi.service;

import com.example.taskmanagerapi.dto.ProjectDTO;
import com.example.taskmanagerapi.dto.UserDTO;
import com.example.taskmanagerapi.entity.ProjectEntity;
import com.example.taskmanagerapi.entity.UserEntity;
import com.example.taskmanagerapi.repository.UserRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public List<UserDTO> getAllUsers() {
        List<UserEntity> users = userRepository.findAll();

        List<UserDTO> userDTOs = new ArrayList<>();
        for (UserEntity user : users) {
            UserDTO userDTO = new UserDTO();
            userDTO.convertToDTO(user);
            userDTOs.add(userDTO);
        }

        return userDTOs;
    }

    @Override
    public UserDTO getUserById(Long id) {
        UserEntity userEntity = userRepository.findById(id)
                .orElseThrow(
                        () -> new IllegalStateException("User with id " + id + " not found")
                );
        UserDTO userDTO = new UserDTO();
        userDTO.convertToDTO(userEntity);
        return userDTO;
    }

    @Override
    public void createUser(UserDTO userDTO) {
        UserEntity userEntity = userDTO.convertToEntity();
        System.out.println(userEntity);
        try {
            userRepository.save(userEntity);
        }
        catch (Exception e) {
            throw new IllegalStateException("Username taken");
        }

    }

    @Transactional
    public void updateUser(Long id, String username, String password) {
        UserEntity user = userRepository.findById(id).orElseThrow(
                () -> new IllegalStateException("User with id " + id + " not found")
        );
        if (username != null && !username.isEmpty() && !Objects.equals(user.getUsername(), username)) {
            user.setUsername(username);
        }
        if (password != null && !password.isEmpty() && !Objects.equals(user.getPassword(), password)) {
            user.setPassword(password);
        }

    }

    @Override
    public void deleteUser(Long id) {
        userRepository.findById(id).orElseThrow(
                () -> new IllegalStateException("User with id " + id + " not found")
        );
        userRepository.deleteById(id);
    }

}
