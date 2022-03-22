package pl.javastart.equipy.components.assignments;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
public class AssignmentDto {

    private Long id;
    private LocalDateTime start;
    private LocalDateTime end;
    private Long userId;
    private Long assetId;
}
