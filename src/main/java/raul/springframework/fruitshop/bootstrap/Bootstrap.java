package raul.springframework.fruitshop.bootstrap;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import raul.springframework.fruitshop.domain.Category;
import raul.springframework.fruitshop.domain.Customer;
import raul.springframework.fruitshop.repositories.CategoryRepository;
import raul.springframework.fruitshop.repositories.CustomerRepository;

@Component
public class Bootstrap implements CommandLineRunner{

    private CategoryRepository categoryRespository;
    private CustomerRepository customerRepository;

    public Bootstrap(CategoryRepository categoryRespository, CustomerRepository customerRepository) {
        this.categoryRespository = categoryRespository;
        this.customerRepository = customerRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        loadCategories();
        loadCustomers();
    }

    private void loadCategories() {
        Category fruits = new Category();
        fruits.setName("Fruits");

        Category dried = new Category();
        dried.setName("Dried");

        Category fresh = new Category();
        fresh.setName("Fresh");

        Category exotic = new Category();
        exotic.setName("Exotic");

        Category nuts = new Category();
        nuts.setName("Nuts");

        categoryRespository.save(fruits);
        categoryRespository.save(dried);
        categoryRespository.save(fresh);
        categoryRespository.save(exotic);
        categoryRespository.save(nuts);

        System.out.println("Category Data Loaded = " + categoryRespository.count() );
    }

    private void loadCustomers() {
        Customer customer1 = new Customer();
        customer1.setId(1l);
        customer1.setFirstName("Michale");
        customer1.setLastName("Weston");

        Customer customer2 = new Customer();
        customer2.setId(2l);
        customer2.setFirstName("Sam");
        customer2.setLastName("Axe");

        Customer customer3 = new Customer();
        customer2.setId(3l);
        customer3.setFirstName("Joe");
        customer3.setLastName("Newman");

        customerRepository.save(customer1);
        customerRepository.save(customer2);
        customerRepository.save(customer3);


        System.out.println("Customer Data Loaded = " + customerRepository.count() );
    }
}