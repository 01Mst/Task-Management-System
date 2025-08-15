package com._mst.projectOnlineTaskManagement.controller;

import com._mst.projectOnlineTaskManagement.model.Task;
import com._mst.projectOnlineTaskManagement.model.User;
import com._mst.projectOnlineTaskManagement.service.TaskService;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class TaskController {
    @Autowired
    private TaskService taskService;

    @GetMapping("/dashboard")
    public String dashboard(HttpSession session, Model model) {
        User user = (User) session.getAttribute("user");
        if (user == null) return "redirect:/login";
        model.addAttribute("username", user.getUsername());
        model.addAttribute("tasks", taskService.getByUser(user));
        return "dashboard";
    }

    @GetMapping("/tasks/new")
    public String newTask(Model model) {
        model.addAttribute("task", new Task());
        return "task-form";
    }

    @PostMapping("/tasks/save")
    public String saveTask(@ModelAttribute Task task, HttpSession session) {
        User user = (User) session.getAttribute("user");
        task.setUser(user);
        taskService.save(task);
        return "redirect:/dashboard";
    }

    @GetMapping("/tasks/edit/{id}")
    public String editTask(@PathVariable Long id, Model model) {
        model.addAttribute("task", taskService.getById(id));
        return "task-form";
    }

    @GetMapping("/tasks/delete/{id}")
    public String deleteTask(@PathVariable Long id) {
        taskService.deleteById(id);
        return "redirect:/dashboard";
    }
}

