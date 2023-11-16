package com.app.kuri.Dto;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.UUID;

@Getter
@Setter
public class OrgDto {
    private Long id;
    private String orgName;
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
    private String schema;
    private boolean isActive;
}
