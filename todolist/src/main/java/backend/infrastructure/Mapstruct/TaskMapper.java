package backend.infrastructure.Mapstruct;

import backend.infrastructure.dtos.req.TaskRequestDto;
import backend.infrastructure.dtos.resp.TaskResponseDto;
import backend.infrastructure.entity.Task;
import org.mapstruct.Mapper;

import java.util.List;
import java.util.Optional;

/*
    Transforma Task em TaskRequestDto ou TaskResponseDto
 */
@Mapper(componentModel = "spring")
public interface TaskMapper {

    // Request DTO -> Task Entity.
    Task toTaskEntity(TaskRequestDto taskDto);

    // Task Entity -> ResponseDTO.
    TaskResponseDto toResponseDto(Task savedTask);

    // Task List -> ResponseDTO List.
    List<TaskResponseDto> toListTaskResponseDto(List<Task> list);

    // Optional<Task> -> Optional<ResponseDto>
    default Optional<TaskResponseDto> toOptionalResponse(Optional<Task> task) {
        return task.map(this::toResponseDto);
    }
}
