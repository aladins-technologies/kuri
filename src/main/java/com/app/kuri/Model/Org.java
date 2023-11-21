package com.app.kuri.Model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import java.util.UUID;

@Data
@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
@Table(uniqueConstraints = {@UniqueConstraint(columnNames = {"orgName", "schema"})})
public class Org extends DateAudit {

    @Column(columnDefinition = "VARCHAR(225)", unique = true)
    private final UUID uuid = UUID.randomUUID();

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(updatable = false, nullable = false)
    private Long id;

    @NotEmpty(message = "Name cannot be empty")
    @Size(min = 3, message = "Name must contain at least 3 letters")
    @Column(length = 100, nullable = false)
    private String orgName;

    private String description;

    private byte[] logo;

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

    @Column(length = 50)
    private String taxId;

    private String field1;

    private String field2;

    @Column(nullable = false, length = 50)
    private String schema;

    @Column(nullable = false, columnDefinition = "boolean default true")
    private boolean isActive;
}
