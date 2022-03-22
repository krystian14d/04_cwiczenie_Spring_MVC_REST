package pl.javastart.equipy.user;

import pl.javastart.equipy.components.assignments.Assignment;
import pl.javastart.equipy.components.inventory.asset.Asset;

public class UserAssigmentMapper {
    static UserAssigmentDto toDto(Assignment assignment){
        UserAssigmentDto dto = new UserAssigmentDto();
        Asset asset = assignment.getAsset();
        dto.setId(assignment.getId());
        dto.setAssetId(asset.getId());
        dto.setStart(assignment.getStart());
        dto.setEnd(assignment.getEnd());
        dto.setAssetName(asset.getName());
        dto.setAssetSerialNumber(asset.getSerialNumber());
        return dto;
    }
}
