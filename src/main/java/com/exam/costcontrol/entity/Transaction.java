package com.exam.costcontrol.entity;

import com.exam.costcontrol.entity.enums.TransactionType;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;

@Entity
@Table(name = "tbl_transaction")
@Setter
@Getter
@EqualsAndHashCode
@ToString
public class Transaction {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_transaction")
    private int idTransaction;

    @Column(name = "time_date", insertable = false)
    private LocalDate date;

    @Column(name = "description")
    private String description;

    @Column(name = "plusMoney")
    private double plusMoney;

    @Column(name = "minusMoney")
    private double minusMoney;

    @NotNull
    @Column
    @Enumerated(value = EnumType.STRING)
    private TransactionType type;
    @ManyToOne
    @JoinColumn(name="account_number")
    private Account account;




}
