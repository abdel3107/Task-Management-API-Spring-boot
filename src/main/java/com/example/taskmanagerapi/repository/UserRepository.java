package com.example.taskmanagerapi.repository;

import com.example.taskmanagerapi.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<UserEntity, Long> {

    
}
