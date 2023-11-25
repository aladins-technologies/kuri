package com.app.kuri.Model;

import java.util.UUID;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class Customer extends DateAudit{

    @Column(unique = true)
    private final UUID uuid = UUID.randomUUID();

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(updatable = false, nullable = false)
    private Long id;

    @NotEmpty(message = "Name cannot be empty")
    @Size(min = 3, message = "Name must contain at least 3 letters")
    @Column(length = 100, nullable = false)
    private String customerName;

    private String description;

    @NotEmpty(message = "Address cannot be empty")
    @Size(min = 5, message = "Address must contain at least 5 letters")
    @Column(nullable = false)
    private String address;

    @Column(length = 50)
    private String city;

    @Column(length = 50)
    private String state;

    @Column(length = 50)
    private String country;

    @Column(length = 10)
    private String zipCode;

    @Pattern(regexp = "^\\+?[0-9-]*$", message = "Invalid phone number format")
    @Size(min = 10, max = 15, message = "Invalid phone number")
    @Column(length = 15)
    private String phone;

    @Email(message = "Invalid email format")
    @Column(length = 50)
    private String email;

    @JsonIgnore
    private String password;

    @Column(length = 10)                                                                //TODO make this as Enum
    private String role;

    @Column(length = 50)
    private String taxId;

    private String field1;

    private String field2;

    @Column(nullable = false, length = 50)
    private String schema;

    @Column(nullable = false, columnDefinition = "BOOLEAN DEFAULT true")
    private boolean isActive;
    
}
