package backend.infrastructure.entity;


import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
public class Task {

    @Id
    @GeneratedValue( strategy = GenerationType.IDENTITY )
    private Long id;

    @Column( nullable = false )
    private String name;

    private String description;

    @Column( nullable = false )
    private Status status;

    @Column( nullable = false )
    private Priority priority;

}
