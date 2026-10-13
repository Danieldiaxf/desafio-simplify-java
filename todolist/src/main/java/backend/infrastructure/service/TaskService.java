package backend.infrastructure.service;

import backend.infrastructure.Mapstruct.TaskMapper;
import backend.infrastructure.dtos.req.TaskRequestDto;
import backend.infrastructure.dtos.resp.TaskResponseDto;
import backend.infrastructure.entity.Status;
import backend.infrastructure.entity.Priority;
import backend.infrastructure.entity.Task;
import backend.infrastructure.repository.TaskRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@RequiredArgsConstructor
@Service
public class TaskService {

    private final TaskRepository repository;
    private final TaskMapper mapper;


    public void createTask( TaskRequestDto task ) {

        if( task == null ){
            throw new RuntimeException( "Error registering new task!." );
        }

        if( task.getName( ) == null || task.getStatus( ) == null || task.getPriority( ) == null ){
            throw new RuntimeException( "Error registering new task! Check the required fields." );
        }

        Task toTask = mapper.toTaskEntity( task );


        repository.save( toTask );

    }

    public Optional<TaskResponseDto> findTaskById( Long id ) {

        if( id == null || !repository.existsById( id ) ){
            throw new RuntimeException( "Task not found by id!" );
        }

        return mapper.toOptionalResponse( repository.findById( id ) );

    }

    public List<TaskResponseDto> findTaskByPriority( Priority priority ) {

        if( priority == null || !repository.existsTaskByPriority( priority ) ){
            throw new RuntimeException( "Task not found by priority!" );
        }

        return mapper.toListTaskResponseDto( repository.findByPriority( priority ) );

    }

    public List<TaskResponseDto> findTaskByDone( Status status) {

        if( status == null || !repository.existsTaskByDone(status) ) {
            throw new RuntimeException( "Task not found by Status!" );
        }

        return mapper.toListTaskResponseDto( repository.findTaskByDone(status) );

    }

    public Optional<TaskResponseDto> findTaskByName( String name ) {

        if( name == null ||!repository.existsTaskByName( name ) ) {
            throw new RuntimeException( "Task not found by name!" );
        }

        return mapper.toOptionalResponse( repository.findTaskByName( name ) );
    }




}
