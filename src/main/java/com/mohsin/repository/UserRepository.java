package com.mohsin.repository;

import com.mohsin.entity.User;

import java.util.List;

public interface UserRepository {
    void save(User user);
    User findById(Long id);
    User findByName(String name);
    void delete(Long id);
    List<User> findAll();
}
