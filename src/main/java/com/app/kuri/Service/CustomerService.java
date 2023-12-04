package com.app.kuri.Service;

import java.util.HashSet;
import java.util.Set;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.app.kuri.Dto.CustomerDto;
import com.app.kuri.Exception.CustomerException;
import com.app.kuri.Model.Authority;
import com.app.kuri.Model.Customer;
import com.app.kuri.Repository.AuthorityRepository;
import com.app.kuri.Repository.CustomerRepository;

@Service
public class CustomerService {
    
    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private CustomerRepository customerRepo;

    @Autowired
    private AuthorityRepository authorityRepo;

    
    @Transactional
    public Customer createCustomer(String schema, CustomerDto customerDto) {

        String hashedPwd = null;
        if(customerDto.getPassword() != null && customerDto.getPassword().length() > 5){
            //TODO add additional checks for a strong password

            Set<String> authorities = new HashSet<>();
            authorities.add("ROLE_ADMIN");
            authorities.add("ROLE_USER");
            authorities.add("ROLE_SUPERUSER");
            customerDto.setAuthorities(authorities);
            hashedPwd = passwordEncoder.encode(customerDto.getPassword());
            customerDto.setPassword(hashedPwd);

        } else{
            throw new CustomerException("Please provide a valid password");
        }

        Customer mappedCustomer = modelMapper.map(customerDto, Customer.class);
        mappedCustomer.setSchema(schema);
        Customer newCustomer = customerRepo.save(mappedCustomer);

        if(newCustomer != null && newCustomer.getCustomer_id() > 0){
            customerDto.getAuthorities().forEach(auth -> createAuthorities(schema, newCustomer, auth));  
        }
        return newCustomer;
    }

    public Authority createAuthorities(String schema, Customer newCustomer, String auth) {
        return authorityRepo.save(getAuthorityModel(schema, newCustomer, auth));
    }

    public Authority getAuthorityModel(String schema, Customer newCustomer, String auth) {
        Authority authority = new Authority();
        authority.setCustomer(newCustomer);
        authority.setName(auth);
        authority.setActive(true);
        return authority;
    }

}
