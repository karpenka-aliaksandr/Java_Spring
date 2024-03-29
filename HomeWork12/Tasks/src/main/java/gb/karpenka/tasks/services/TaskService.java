package gb.karpenka.tasks.services;

import gb.karpenka.tasks.aspects.ToLog;
import gb.karpenka.tasks.model.Task;
import gb.karpenka.tasks.model.Status;
import gb.karpenka.tasks.repositories.TaskRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class TaskService {
    private TaskRepository taskRepository;

    public List<Task> findAll(){
        return taskRepository.findAll();
    }

    public List<Task> findByStatus(String status){
        return taskRepository.findByStatus(Status.valueOf(status));
    }

    public Task addTask(Task task){
        task.setCreationDate(LocalDateTime.now());
        try {
            task.setStatus(Status.valueOf(task.getStatus().toString()));
        } catch (Exception e){
            task.setStatus(Status.NOT_STARTED);
        }
        return taskRepository.save(task);
    }
    @ToLog
    public Task updateTaskStatus(Long id, Task replacementTask){
        Task replacebleTask = findById(id);
        replacebleTask.setStatus(replacementTask.getStatus());
        return taskRepository.save(replacebleTask);
    }
    @ToLog
    public Task findById(Long id) {return taskRepository.findById(id).get();}

    public void deleteTask(Long id) {taskRepository.delete(taskRepository.findById(id).get());}




}
