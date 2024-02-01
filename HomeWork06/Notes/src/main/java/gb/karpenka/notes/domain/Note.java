package gb.karpenka.notes.domain;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NonNull;
import org.springframework.cglib.core.Local;

import java.time.LocalDateTime;

@Data
@Entity
@Table(name = "notes")
public class Note {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String title;

    @Column(nullable = false)
    private String content;

    @Column(columnDefinition = "TIMESTAMP")
    private LocalDateTime creationDateTime;
}
