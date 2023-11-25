package com.app.kuri.Controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.kuri.Dto.CustomerDto;
import com.app.kuri.Service.CustomerService;
import com.app.kuri.Utils.ApiResponse;
import com.app.kuri.Utils.CustomHttpStatus;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/customer")
public class CustomerController {

    @Autowired
    private CustomerService customerService;
    
    @PostMapping("/createCustomer")
    public ResponseEntity<ApiResponse> createCustomer(@RequestHeader("X-TenantSchema") String schema, @Valid @RequestBody CustomerDto customerDto) {
        Map<String, Object> data = new HashMap<String, Object>();
        data.put("data", customerService.createCustomer(schema, customerDto));
        return ResponseEntity.ok(new ApiResponse(data, "New user registered successfully!", CustomHttpStatus.SUCCESS.asStatus()));
    }
}
