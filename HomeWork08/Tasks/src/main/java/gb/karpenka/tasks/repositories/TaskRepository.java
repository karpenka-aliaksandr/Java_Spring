package gb.karpenka.tasks.repositories;

import gb.karpenka.tasks.model.Task;
import gb.karpenka.tasks.model.Status;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TaskRepository extends JpaRepository<Task, Long> {

    List<Task> findByStatus(Status status);

}
