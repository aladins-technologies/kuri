package com.app.kuri.Model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.UUID;

@Data
@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
@Table(uniqueConstraints = {@UniqueConstraint(columnNames = {"chitName", "schema"})})
public class Chit extends DateAudit {

    public enum Type{
        LOT,
        AUCTION
    }

    public enum Scheme{
        WEEKLY,
        ONCE_IN_TWO_WEEKS,
        MONTHLY,
        ONCE_IN_TWO_MONTHS
    }

    @Column(columnDefinition = "VARCHAR(225)", unique = true)
    private final UUID uuid = UUID.randomUUID();

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(updatable = false, nullable = false)
    private Long id;

    @NotEmpty(message = "Name cannot be empty")
    @Size(min = 3, message = "Name must contain at least 3 letters")
    @Column(length = 100, nullable = false)
    private String chitName;

    private String description;

    @NotEmpty(message = "Chit type cannot be empty")
    @Column(nullable = false)
    private Type type;

    @NotEmpty(message = "Scheme cannot be empty")
    @Column(nullable = false)
    private Scheme scheme;

    @Column(nullable = false)
    private LocalDate startDate;                //first draw date, can be a past date to add already running chits

    @Column(updatable = true)
    private LocalDate nextDrawDate;             //calculated based on startDate and Scheme, updated after a draw

    @Column(nullable = false, updatable = true)
    private BigDecimal divisionAmount;          //payable by each member in a period, updated after a draw if type is auction

    @Column(nullable = false, columnDefinition = "Decimal(10,2) default '0.00'")
    private BigDecimal profitStrategy;          //0 - no profit, 0.5 - Half of divisionAmount, 1 - equal to divisionAmount ...

    @Column(updatable = true)
    private int[] profitTenures;                //tenures for profit collection

    @Column(updatable = true)
    private BigDecimal profitAmount;            //total profit amount from this chit

    @Column(updatable = true)
    private int numberOfMembers;                //Calculated after adding members

    @Column(updatable = true)
    private int numberOfTenures;                //calculated from profitTenures and numberOfMembers

    @Column(updatable = true)
    private BigDecimal priceAmount;             //calculated from divisionAmount and numberOfMembers

    @Column(nullable = false)
    private int paymentStrategy;                //number of days after draw day

    @Column(nullable = false)
    private int collectionStrategy;             //number of days before payment day

    @Column(nullable = false, length = 50)
    private String schema;

    @Column(nullable = false, columnDefinition = "boolean default true")
    private boolean isActive;
}
