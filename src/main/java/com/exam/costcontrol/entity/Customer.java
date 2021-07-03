package com.exam.costcontrol.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "tb_customer")
@Setter
@Getter
public class Customer {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;

	@Column(name = "username")
	private String username;

	@Column(name = "password")
	private String password;


	@OneToOne(fetch = FetchType.LAZY,cascade=CascadeType.ALL)
	private Account account;
}