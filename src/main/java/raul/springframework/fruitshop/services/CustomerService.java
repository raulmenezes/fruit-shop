package raul.springframework.fruitshop.services;

import raul.springframework.fruitshop.api.v1.model.CustomerDTO;

import java.util.List;

public interface CustomerService {

    List<CustomerDTO> getAllCustomers();

    CustomerDTO getCustomerById(Long id);

    CustomerDTO createCustomer(CustomerDTO customerDTO);

    CustomerDTO updateCustomer(CustomerDTO customerDTO, Long id);

    CustomerDTO patchCustomer(CustomerDTO customerDTO, Long id);

    void deleteCustomer(Long id);

}
