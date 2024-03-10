package com.crud.projectmanagementsystem.Dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.crud.projectmanagementsystem.Entities.User;

public interface UserRepository extends JpaRepository<User, Long> {
    
    @Query(value = "DROP TABLE IF EXISTS `user` CASCADE", nativeQuery = true)
    void dropUserTable();
}
