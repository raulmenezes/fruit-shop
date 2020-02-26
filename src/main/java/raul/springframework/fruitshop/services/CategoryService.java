package raul.springframework.fruitshop.services;

import raul.springframework.fruitshop.api.v1.model.CategoryDTO;
import raul.springframework.fruitshop.domain.Category;

import java.util.List;

public interface CategoryService {

    List<CategoryDTO> getAllCategories();

    CategoryDTO getCategoryByName(String name);
}
