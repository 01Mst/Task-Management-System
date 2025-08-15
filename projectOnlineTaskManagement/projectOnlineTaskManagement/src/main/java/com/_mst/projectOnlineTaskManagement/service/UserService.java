package com._mst.projectOnlineTaskManagement.service;

import com._mst.projectOnlineTaskManagement.model.User;
import com._mst.projectOnlineTaskManagement.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepo;

    public void register(User user) {
        userRepo.save(user);
    }

    public User login(String email, String password) {
        User user = userRepo.findByEmail(email);
        return (user != null && user.getPassword().equals(password)) ? user : null;
    }

    public User getById(Long id) {
        return userRepo.findById(id).orElse(null);
    }
}

