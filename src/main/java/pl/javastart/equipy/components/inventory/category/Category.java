package pl.javastart.equipy.components.inventory.category;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import pl.javastart.equipy.components.inventory.asset.Asset;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@EqualsAndHashCode
@Entity
public class Category {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(unique = true)
    private String name;
    private String description;
    @OneToMany(mappedBy = "category")
    private Set<Asset> assets = new HashSet<>();
}
