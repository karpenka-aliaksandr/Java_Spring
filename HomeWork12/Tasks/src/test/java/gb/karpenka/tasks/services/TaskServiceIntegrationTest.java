package gb.karpenka.tasks.services;

import gb.karpenka.tasks.model.Status;
import gb.karpenka.tasks.model.Task;
import gb.karpenka.tasks.repositories.TaskRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.time.LocalDateTime;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.BDDMockito.given;

@SpringBootTest
class TaskServiceIntegrationTest {

    @Autowired
    public TaskRepository taskRepository;

    @Autowired
    public TaskService taskService;


    @Test
    public void updateTaskStatusTest() {
        //arrange
        Task updatableTask = new Task(); //задача для внесения изменений
        updatableTask.setStatus(Status.NOT_STARTED);
        updatableTask.setId(1L);
        updatableTask.setDescription("task1");
        updatableTask.setCreationDate(LocalDateTime.now());

        Task updateTask = new Task(); //задача с новым статусом
        updateTask.setStatus(Status.IN_PROGRESS);

        taskService.addTask(updatableTask);

        //act
        Task result = taskService.updateTaskStatus(1L, updateTask);

        //assert
        assertEquals(Status.IN_PROGRESS, result.getStatus());



    }
}