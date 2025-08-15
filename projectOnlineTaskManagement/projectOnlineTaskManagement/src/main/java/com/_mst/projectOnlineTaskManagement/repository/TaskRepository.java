package com._mst.projectOnlineTaskManagement.repository;

import com._mst.projectOnlineTaskManagement.model.Task;
import com._mst.projectOnlineTaskManagement.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TaskRepository extends JpaRepository<Task, Long> {
    List<Task> findByUser(User user);
}

