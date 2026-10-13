package backend.infrastructure.Controller;


import backend.infrastructure.dtos.req.TaskRequestDto;
import backend.infrastructure.dtos.resp.TaskResponseDto;
import backend.infrastructure.entity.Status;
import backend.infrastructure.entity.Priority;
import backend.infrastructure.service.TaskService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@RestController
@RequestMapping("/task")
public class TaskController {

    private final TaskService taskService;

    @PostMapping
    @ResponseStatus( HttpStatus.NO_CONTENT )
    public void createTask( @RequestBody TaskRequestDto taskDto ) {
        taskService.createTask( taskDto );
    }


    @GetMapping("id/{id}")
    @ResponseStatus( HttpStatus.ACCEPTED )
    public Optional<TaskResponseDto> findTaskById( @PathVariable Long id ) {
        return taskService.findTaskById( id );
    }

    @GetMapping("priority/{priority}")
    @ResponseStatus( HttpStatus.ACCEPTED )
    public List<TaskResponseDto> findTaskByPriority( @PathVariable Priority priority ) {
        return taskService.findTaskByPriority( priority );
    }

    @GetMapping("done/{status}")
    @ResponseStatus( HttpStatus.ACCEPTED )
    public List<TaskResponseDto> findByDone( @PathVariable Status status) {
        return taskService.findTaskByDone(status);
    }

    @GetMapping("name/{name}")
    @ResponseStatus( HttpStatus.ACCEPTED )
    public List<TaskResponseDto> findByDone( @PathVariable String name ) {
        return taskService.findTaskByName( name );
    }


}
