package pl.javastart.equipy.components.inventory.category;


import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("/api/categories")
public class CategoryResource {

    private CategoryService categoryService;

    @GetMapping("/names")
    public List<String> findAllCategoryNames(){
        return categoryService.findAllCategoryNames();
    }
}
