package raul.springframework.fruitshop.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import raul.springframework.fruitshop.domain.Customer;

public interface CustomerRepository extends JpaRepository<Customer, Long> {

}
