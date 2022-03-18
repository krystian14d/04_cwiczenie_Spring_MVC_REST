package pl.javastart.equipy.user;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
public class UserAssigmentDto {

    private Long id;
    private LocalDateTime start;
    private LocalDateTime end;
    private Long assetId;
    private String assetName;
    private String assetSerialNumber;
}
