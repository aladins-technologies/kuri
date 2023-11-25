package com.app.kuri.Service;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.app.kuri.Dto.CustomerDto;
import com.app.kuri.Exception.CustomerException;
import com.app.kuri.Model.Customer;
import com.app.kuri.Repository.CustomerRepository;

@Service
public class CustomerService {
    
    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private CustomerRepository customerRepo;

    public Customer createCustomer(String schema, CustomerDto customerDto) {

        String hashedPwd = null;
        if(customerDto.getPassword() != null && customerDto.getPassword().length() > 5){
            //TODO add additional checks for a strong password
            hashedPwd = passwordEncoder.encode(customerDto.getPassword());
            customerDto.setPassword(hashedPwd);

        } else{
            throw new CustomerException("Please provide a valid password");
        }

        Customer newCustomer = modelMapper.map(customerDto, Customer.class);
        newCustomer.setSchema(schema);
        return customerRepo.save(newCustomer);
    }
}
