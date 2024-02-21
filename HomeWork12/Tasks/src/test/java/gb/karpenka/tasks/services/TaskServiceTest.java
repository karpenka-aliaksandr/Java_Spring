package gb.karpenka.tasks.services;

import gb.karpenka.tasks.model.Status;
import gb.karpenka.tasks.model.Task;
import gb.karpenka.tasks.repositories.TaskRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDateTime;
import java.util.Optional;


import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.verify;



//    public Task updateTaskStatus(Long id, Task replacementTask){
//        Task replacebleTask = findById(id);
//        replacebleTask.setStatus(replacementTask.getStatus());
//        return taskRepository.save(replacebleTask);
//    }
@ExtendWith(MockitoExtension.class)
class TaskServiceTest {

    @Mock
    public TaskRepository taskRepository;

    @InjectMocks
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
        updateTask.setId(1L);
        updateTask.setDescription("task1");
        updateTask.setCreationDate(LocalDateTime.now());

        given(taskRepository.findById(1L)).willReturn(Optional.of(updatableTask));
        given(taskRepository.save(updateTask)).willReturn(updateTask);

        //act
        Task result = taskService.updateTaskStatus(1L,updateTask);

        //assert
        assertEquals(Status.IN_PROGRESS, result.getStatus());



    }
}