package com.app.kuri.Model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.UUID;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(uniqueConstraints = {@UniqueConstraint(columnNames = {"orgName", "schema"})})
public class Org extends DateAudit {

    @Column(columnDefinition = "VARCHAR(225)", unique = true)
    private final UUID uuid = UUID.randomUUID();

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(updatable = false, nullable = false)
    private Long id;

    @Column(length = 100, nullable = false)
    private String orgName;

    private String description;

    private byte[] logo;

    @Column(nullable = false)
    private String address;

    @Column(length = 50)
    private String city;

    @Column(length = 50)
    private String state;

    @Column(length = 10)
    private String zipCode;

    @Column(length = 20)
    private String phone;

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
