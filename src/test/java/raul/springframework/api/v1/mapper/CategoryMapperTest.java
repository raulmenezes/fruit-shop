package raul.springframework.api.v1.mapper;

import org.junit.jupiter.api.Test;
import raul.springframework.fruitshop.api.v1.mapper.CategoryMapper;
import raul.springframework.fruitshop.api.v1.model.CategoryDTO;
import raul.springframework.fruitshop.domain.Category;

import static org.junit.Assert.assertEquals;

public class CategoryMapperTest {


    private static final String NAME = "Raul";
    private static final Long ID = 1L;

    CategoryMapper categoryMapper = CategoryMapper.INSTANCE;

    @Test
    public void categoryToCategoryDTO() throws Exception {
        // Given
        Category category = new Category();
        category.setName(NAME);
        category.setId(ID);

        // When
        CategoryDTO categoryDTO = categoryMapper.categoryToCategoryDTO(category);

        // Assert
        assertEquals(NAME, categoryDTO.getName());
        assertEquals(Long.valueOf(ID), categoryDTO.getId());

    }
}
