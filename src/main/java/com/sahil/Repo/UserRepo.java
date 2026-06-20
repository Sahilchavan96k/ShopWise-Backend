package com.sahil.Repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sahil.Entity.User;

public interface UserRepo
        extends JpaRepository<User, Long> {

}