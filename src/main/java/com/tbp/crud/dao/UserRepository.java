package com.tbp.crud.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.tbp.crud.entity.User;

public interface UserRepository extends JpaRepository<User, Integer> {

}
