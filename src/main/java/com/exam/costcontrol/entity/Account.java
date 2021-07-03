package com.exam.costcontrol.entity;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Date;

@Entity
@Table(name="tb_account")
@EqualsAndHashCode
@ToString
@Getter
@Setter
public class Account {
	@Id
	@Column(name = "account_number")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int accountNumber;

	@Column(name = "account_name")
	private String accountName;

	@Column(name = "local_date", insertable = false)
	private LocalDate openDate;

	@Column(name = "balance")
	private double balance;


}

