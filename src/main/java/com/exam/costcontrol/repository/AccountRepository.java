package com.exam.costcontrol.repository;

import com.exam.costcontrol.entity.Account;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface AccountRepository extends PagingAndSortingRepository<Account, Integer>,
        JpaSpecificationExecutor<Account> {







}
