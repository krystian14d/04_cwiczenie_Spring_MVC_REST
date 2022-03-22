package pl.javastart.equipy.components.assignments;

import pl.javastart.equipy.components.inventory.asset.Asset;
import pl.javastart.equipy.user.User;

public class AssignmentMapper {

    static AssignmentDto toDto(Assignment assignment){
        AssignmentDto dto = new AssignmentDto();
        dto.setId(assignment.getId());
        dto.setStart(assignment.getStart());
        dto.setEnd(assignment.getEnd());
        User user = assignment.getUser();
        dto.setUserId(user.getId());
        Asset asset = assignment.getAsset();
        dto.setAssetId(asset.getId());
        return dto;
    }
}
