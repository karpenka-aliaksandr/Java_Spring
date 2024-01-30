package gb.karpenka.tasks.controllers;

import gb.karpenka.tasks.model.Task;
import gb.karpenka.tasks.services.TaskService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/tasks")
public class TaskRestController {
    private TaskService taskService;

    @GetMapping
    public List<Task> getAllTasks(){
        return taskService.findAll();
    }

    @PostMapping
    public Task addTask(@RequestBody Task task){
        return taskService.addTask(task);
    }
    @GetMapping("/status")
    public List<Task> getTasksByStatus(@RequestParam String status){
        return taskService.findByStatus(status);
    }
}
