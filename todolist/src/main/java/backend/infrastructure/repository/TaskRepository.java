package backend.infrastructure.repository;



import backend.infrastructure.entity.Status;
import backend.infrastructure.entity.Priority;
import backend.infrastructure.entity.Task;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface TaskRepository extends JpaRepository<Task, Long> {

    public List<Task> findTaskByDone( Status status);

    public List<Task> findByPriority( Priority priority );

    public Optional<Task> findTaskByName( String name );

    public Boolean existsTaskByName( String name );

    public Boolean existsTaskByPriority( Priority priority );

    public Boolean existsTaskByDone( Status status);
}
