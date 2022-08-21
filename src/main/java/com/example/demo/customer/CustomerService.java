package com.example.demo.customer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import javax.swing.text.html.Option;
import javax.transaction.Transactional;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class CustomerService {

    private final CustomerRepository customerRepository;

    @Autowired
    public CustomerService(CustomerRepository customerRepository){
        this.customerRepository = customerRepository;
    }

    public List<Customer> getCustomers(){
        return customerRepository.findAll();
    }

    public void addNewCustomer(Customer customer){
        Optional<Customer> customerOptional = customerRepository.findCustomerByEmail(customer.getEmail());
        if(customerOptional.isPresent()){
            throw new IllegalStateException("duplicate email");
        }
        customerRepository.save(customer);
    }

    public void deleteCustomer(Long customerId){
        boolean exists = customerRepository.existsById(customerId);
        if(!exists){
            throw new IllegalStateException("customer with id " + customerId + " does not exist");
        }
        customerRepository.deleteById(customerId);
    }

    @Transactional
    public void updateCustomer(Long customerId,String name, String email, String department, Integer employeeId){
        Customer customer = customerRepository.findById(customerId).orElseThrow(() -> new IllegalStateException("customer with id " + customerId + "doesnot exist"));

        if(name!=null && name.length() > 0 && !Objects.equals(customer.getName(), name)){
            customer.setName(name);
        }

        if(email!=null && email.length() > 0 && !Objects.equals(customer.getEmail(), email)){
            Optional<Customer> customerOptional = customerRepository.findCustomerByEmail(email);
            if(customerOptional.isPresent()){
                throw new IllegalStateException("email taken");
            }
            customer.setEmail(email);
        }

        if(department!=null && department.length() > 0 && !Objects.equals(customer.getDepartment(), department)){
            customer.setDepartment(department);
        }

        if(employeeId!=null  && !Objects.equals(customer.getEmployeeId(), employeeId)){
            customer.setEmployeeId(employeeId);
        }
    }
}
