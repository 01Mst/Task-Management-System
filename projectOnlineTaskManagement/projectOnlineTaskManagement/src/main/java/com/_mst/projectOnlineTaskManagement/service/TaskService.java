package com._mst.projectOnlineTaskManagement.service;

import com._mst.projectOnlineTaskManagement.model.Task;
import com._mst.projectOnlineTaskManagement.model.User;
import com._mst.projectOnlineTaskManagement.repository.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TaskService {
    @Autowired
    private TaskRepository taskRepo;

    public void save(Task task) {
        taskRepo.save(task);
    }

    public List<Task> getByUser(User user) {
        return taskRepo.findByUser(user);
    }

    public Task getById(Long id) {
        return taskRepo.findById(id).orElse(null);
    }

    public void deleteById(Long id) {
        taskRepo.deleteById(id);
    }
}

