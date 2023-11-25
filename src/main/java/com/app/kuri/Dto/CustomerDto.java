package com.app.kuri.Dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CustomerDto {
    private Long id;
    private String customerName;
    private String description;
    private String address;
    private String city;
    private String state;
    private String country;
    private String zipCode;
    private String phone;
    private String email;
    private String password;
    private String role;
    private String taxId;
    private String field1;
    private String field2;
    private String schema;
    private boolean isActive;
}