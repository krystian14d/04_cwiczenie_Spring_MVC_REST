package pl.javastart.equipy.components.inventory.asset;

import lombok.Getter;
import lombok.Setter;
import pl.javastart.equipy.components.inventory.category.Category;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Getter
@Setter
@Entity
public class Asset {

    @Id
    private Long id;
    private String name;
    private String description;
    @Column(unique = true)
    private String serialNumber;
    @ManyToOne
    @JoinColumn(name = "category_id")
    private Category category;

}
