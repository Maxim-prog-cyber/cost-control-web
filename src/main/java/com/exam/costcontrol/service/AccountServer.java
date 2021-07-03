package com.exam.costcontrol.service;

import com.exam.costcontrol.entity.Account;
import com.exam.costcontrol.repository.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;

@Service
public class AccountServer {

    @Autowired
    private AccountRepository accountRepository;
    @Autowired
    private EntityManager entityManager;




    public void updateBalance(double balance, double result){
        Account account = entityManager.find(Account.class,balance);
        account.setBalance(result);
        entityManager.merge(account);
    }

    public  double getBalance(int accountNumber){
        Account account = entityManager.find(Account.class,accountNumber);
        return account.getBalance();

    }













}
