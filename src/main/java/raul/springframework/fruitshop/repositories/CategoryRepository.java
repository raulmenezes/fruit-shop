package raul.springframework.fruitshop.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import raul.springframework.fruitshop.domain.Category;

public interface CategoryRepository extends JpaRepository<Category, Long> {

    Category findByName(String name);
}
