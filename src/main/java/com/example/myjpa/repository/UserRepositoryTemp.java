package com.example.myjpa.repository;

import com.example.myjpa.domain.Users;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepositoryTemp extends JpaRepository<Users, Long> {

//    List<Users> findUsersByName(String name);

    Users findByName(String name);
}
