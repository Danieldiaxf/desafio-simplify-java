package backend.infrastructure.dtos.req;

import backend.infrastructure.entity.Status;
import backend.infrastructure.entity.Priority;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class TaskRequestDto {

    @JsonProperty(required = true)
    private Long id;
    @JsonProperty(required = true)
    private String name;
    @JsonProperty(required = true)
    private String description;
    @JsonProperty(required = true)
    private Status status;
    @JsonProperty(required = true)
    private Priority priority;

}
