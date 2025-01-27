package com.mohsin.controller;

import com.mohsin.entity.User;
import com.mohsin.repository.UserRepository;

import java.util.ArrayList;
import java.util.List;

// Mock implementations for the repositories
class MockUserRepository implements UserRepository {
    private List<User> users = new ArrayList<>();

    @Override
    public void save(User user) {
        users.add(user);
    }

    @Override
    public User findById(Long id) {
        return users.stream().filter(u -> u.getId().equals(id)).findFirst().orElse(null);
    }

    @Override
    public User findByName(String name) {
        return users.stream().filter(u -> u.getName().equals(name)).findFirst().orElse(null);
    }

    @Override
    public void delete(Long id) {
        users.removeIf(u -> u.getId().equals(id));
    }

    @Override
    public List<User> findAll() {
        return users;
    }
}
