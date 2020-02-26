package raul.springframework.services;


import raul.springframework.fruitshop.api.v1.mapper.CategoryMapper;
import raul.springframework.fruitshop.api.v1.model.CategoryDTO;
import raul.springframework.fruitshop.domain.Category;
import raul.springframework.fruitshop.repositories.CategoryRepository;
import raul.springframework.fruitshop.services.CategoryService;
import raul.springframework.fruitshop.services.CategoryServiceImpl;

import java.util.List;
import java.util.Arrays;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;
import static org.mockito.ArgumentMatchers.anyString;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

public class CategoryServiceTest {

    private static final Long ID = 2L;
    private static final String NAME = "James";

    CategoryService categoryService;

    @Mock
    CategoryRepository categoryRepository;


    @Before
    public void setUp() throws Exception {
        MockitoAnnotations.initMocks(this);

        categoryService = new CategoryServiceImpl(CategoryMapper.INSTANCE, categoryRepository);
    }

    @Test
    public void getAllCategories() throws Exception {

        // Given
        List<Category> categories = Arrays.asList(new Category(), new Category(), new Category());

        when(categoryRepository.findAll()).thenReturn(categories);

        // When
        List<CategoryDTO> categoryDTOS = categoryService.getAllCategories();

        // Assert
        assertEquals(3, categoryDTOS.size());

    }

    @Test
    public void  getCategoryByName() throws Exception{

        // Given
        Category category = new Category();
        category.setId(ID);
        category.setName(NAME);

        when(categoryRepository.findByName(anyString())).thenReturn(category);

        // When
        CategoryDTO categoryDTO = categoryService.getCategoryByName(NAME);

        // Assert
        assertEquals(ID, categoryDTO.getId());
        assertEquals(NAME, categoryDTO.getName());
    }
}