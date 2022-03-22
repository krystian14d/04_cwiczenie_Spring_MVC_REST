package pl.javastart.equipy.components.inventory.asset;

import pl.javastart.equipy.components.assignments.Assignment;
import pl.javastart.equipy.user.User;

public class AssetAssigmentMapper {

    static AssetAssigmentDto toDto(Assignment assignment){
        AssetAssigmentDto dto = new AssetAssigmentDto();
        dto.setId(assignment.getId());
        dto.setStart(assignment.getStart());
        dto.setEnd(assignment.getEnd());

        User user = assignment.getUser();
        dto.setUserId(user.getId());
        dto.setFirstName(user.getFirstName());
        dto.setLastName(user.getLastName());
        dto.setPesel(user.getPesel());
        return dto;
    }
}
