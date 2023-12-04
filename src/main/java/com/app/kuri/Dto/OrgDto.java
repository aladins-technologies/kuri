package com.app.kuri.Dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class OrgDto {
    private Long org_id;
    private String name;
    private String description;
    private byte[] logo;
    private String address;
    private String city;
    private String state;
    private String country;
    private String zipCode;
    private String phone;
    private String email;
    private String taxId;
    private String field1;
    private String field2;
    private boolean isActive;
}
