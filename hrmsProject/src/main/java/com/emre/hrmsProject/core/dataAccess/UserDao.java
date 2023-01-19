package com.emre.hrmsProject.core.dataAccess;

import org.springframework.data.jpa.repository.JpaRepository;

import com.emre.hrmsProject.core.entities.User;

public interface UserDao extends JpaRepository<User, Integer>{

}
