package com.springboot.dao;

import org.springframework.data.repository.CrudRepository;

import com.springboot.entities.User;

public interface UserRepository extends CrudRepository<User, Integer> {

}
