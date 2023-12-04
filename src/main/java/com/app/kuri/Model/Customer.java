package com.app.kuri.Model;

import java.util.Set;
import java.util.UUID;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.persistence.UniqueConstraint;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Table(uniqueConstraints = {@UniqueConstraint(columnNames = {"email", "schema"})})
public class Customer extends DateAudit{

    @Column(unique = true)
    private final UUID uuid = UUID.randomUUID();

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(updatable = false, nullable = false)
    private Long customer_id;

    @NotEmpty(message = "Name cannot be empty")
    @Size(min = 3, message = "Name must contain at least 3 letters")
    @Column(length = 100, nullable = false)
    private String name;

    @JsonIgnore
    @OneToMany(mappedBy="customer", fetch=FetchType.EAGER)
    private Set<Authority> authorities;

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
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private String password;

    @Column(length = 10)
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
