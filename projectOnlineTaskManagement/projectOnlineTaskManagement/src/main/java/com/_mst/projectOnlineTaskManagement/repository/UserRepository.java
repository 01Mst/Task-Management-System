package com._mst.projectOnlineTaskManagement.repository;

import com._mst.projectOnlineTaskManagement.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
    User findByEmail(String email);
}

