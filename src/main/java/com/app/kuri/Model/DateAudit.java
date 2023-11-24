package com.app.kuri.Model;

import java.io.Serializable;
import java.time.OffsetDateTime;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.Column;
import jakarta.persistence.EntityListeners;
import jakarta.persistence.MappedSuperclass;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@MappedSuperclass
@EntityListeners(AuditingEntityListener.class)
@JsonIgnoreProperties(
        value = {"created", "updated"},
        allowGetters = true
)
public class DateAudit implements Serializable {

   @Column(updatable = false)
    @CreationTimestamp
    private OffsetDateTime created;

    @UpdateTimestamp
    private OffsetDateTime updated;
}
