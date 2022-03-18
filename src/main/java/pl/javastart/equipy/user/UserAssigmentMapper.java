package pl.javastart.equipy.user;

import pl.javastart.equipy.components.assigments.Assigment;
import pl.javastart.equipy.components.inventory.asset.Asset;

public class UserAssigmentMapper {
    static UserAssigmentDto toDto(Assigment assigment){
        UserAssigmentDto dto = new UserAssigmentDto();
        Asset asset = assigment.getAsset();
        dto.setId(assigment.getId());
        dto.setAssetId(asset.getId());
        dto.setStart(assigment.getStart());
        dto.setEnd(assigment.getEnd());
        dto.setAssetName(asset.getName());
        dto.setAssetSerialNumber(asset.getSerialNumber());
        return dto;
    }
}
