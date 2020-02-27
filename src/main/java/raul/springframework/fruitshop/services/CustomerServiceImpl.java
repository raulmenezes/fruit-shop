package raul.springframework.fruitshop.services;

import org.springframework.stereotype.Service;
import raul.springframework.fruitshop.api.v1.mapper.CustomerMapper;
import raul.springframework.fruitshop.api.v1.model.CustomerDTO;
import raul.springframework.fruitshop.domain.Customer;
import raul.springframework.fruitshop.repositories.CustomerRepository;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CustomerServiceImpl implements CustomerService {

    CustomerMapper customerMapper;
    CustomerRepository customerRepository;

    public CustomerServiceImpl(CustomerMapper customerMapper, CustomerRepository customerRepository) {
        this.customerMapper = customerMapper;
        this.customerRepository = customerRepository;
    }

    @Override
    public List<CustomerDTO> getAllCustomers() {
        return customerRepository
                .findAll()
                .stream()
                .map(customer -> {
                    CustomerDTO customerDTO = customerMapper.customerToCustomerDTO(customer);
                    customerDTO.setCustomerUrl("api/v1/customer/" + customer.getId());
                    return customerDTO;
                })
                .collect(Collectors.toList());
    }

    @Override
    public CustomerDTO getCustomerById(Long id) {
        return customerRepository.findById(id)
                .map(customerMapper::customerToCustomerDTO)
                .orElseThrow(RuntimeException::new);
    }

    @Override
    public CustomerDTO createCustomer(CustomerDTO customerDTO) {
        return saveAndReturnDTO(customerMapper.customerDtoToCustomer(customerDTO));
    }

    public CustomerDTO saveAndReturnDTO(Customer customer) {
        Customer savedCustomer = customerRepository.save(customer);

        CustomerDTO returnDto = customerMapper.customerToCustomerDTO(savedCustomer);

        returnDto.setCustomerUrl("api/v1/customer/" + savedCustomer.getId());

        return returnDto;
    }

    @Override
    public CustomerDTO updateCustomer(CustomerDTO customerDTO, Long id) {
        Customer customer = customerMapper.customerDtoToCustomer(customerDTO);
        customer.setId(id);
        return saveAndReturnDTO(customer);
    }
}
