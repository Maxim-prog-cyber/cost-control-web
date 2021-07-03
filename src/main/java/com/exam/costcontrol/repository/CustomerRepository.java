package com.exam.costcontrol.repository;

import com.exam.costcontrol.entity.Account;
import com.exam.costcontrol.entity.Customer;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerRepository extends PagingAndSortingRepository<Customer, Integer>,
        JpaSpecificationExecutor<Customer> {
}
