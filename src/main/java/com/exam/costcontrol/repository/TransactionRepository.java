package com.exam.costcontrol.repository;


import com.exam.costcontrol.entity.Account;
import com.exam.costcontrol.entity.Transaction;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TransactionRepository extends PagingAndSortingRepository<Transaction, Integer>,
        JpaSpecificationExecutor<Transaction> {




}

