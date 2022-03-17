package pl.javastart.equipy.components.inventory.asset;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AssetDto {

    private Long id;
    private String name;
    private String description;
    private String serialNumber;
    private String category;
}
