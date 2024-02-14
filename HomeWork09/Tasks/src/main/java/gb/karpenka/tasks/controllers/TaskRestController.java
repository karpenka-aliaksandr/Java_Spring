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

    /**
     * Возвращает все задачи
     * POSTMAN:GET localhost:8080/tasks
     * @return все задачи
     */
    @GetMapping
    public List<Task> getAllTasks(){
        return taskService.findAll();
    }

    /**
     * Добавляет задачу
     * @param task - задача
     * POSTMAN:POST localhost:8080/tasks
     * BODY JSON: {"description":"Задача в работе","status":"IN_PROGRESS"}
     *    если статус не указан - по умолчанию "NOT_STARTED"
     * @return добавленная задача
     */
    @PostMapping
    public Task addTask(@RequestBody Task task){
        return taskService.addTask(task);
    }

    /**
     * Возвращает задачи по статусу
     * POSTMAN:GET localhost:8080/tasks/status/IN_PROGRESS
     * @return задачи по статусу
     */
    @GetMapping("/status/{status}")
    public List<Task> getTasksByStatus(@PathVariable String status){
        return taskService.findByStatus(status);
    }

    /**
     * Обновляет статус
     * POSTMAN:PUT localhost:8080/tasks/1 1-id записи
     * BODY JSON: {"status":"IN_PROGRESS"}
     * @return обновленная задача
     */
    @PutMapping("/{id}")
    public Task updateTaskStatus(@PathVariable Long id, @RequestBody Task task) {
        return taskService.updateTaskStatus(id,task);
    }

    /**
     * Удаляет задачу
     * POSTMAN:PUT localhost:8080/tasks/1 1-id записи
     * BODY JSON: {"status":"IN_PROGRESS"}
     * @return обновленная задача
     */
    @DeleteMapping("/{id}")
    public void deleteTask(@PathVariable Long id){
        taskService.deleteTask(id);
    }

}
