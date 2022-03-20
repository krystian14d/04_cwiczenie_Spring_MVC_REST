package pl.javastart.equipy.components.inventory.asset;

import pl.javastart.equipy.components.assigments.Assigment;
import pl.javastart.equipy.user.User;

public class AssetAssigmentMapper {

    static AssetAssigmentDto toDto(Assigment assigment){
        AssetAssigmentDto dto = new AssetAssigmentDto();
        dto.setId(assigment.getId());
        dto.setStart(assigment.getStart());
        dto.setEnd(assigment.getEnd());

        User user = assigment.getUser();
        dto.setUserId(user.getId());
        dto.setFirstName(user.getFirstName());
        dto.setLastName(user.getLastName());
        dto.setPesel(user.getPesel());
        return dto;
    }
}
