package com.exam.costcontrol.controller;

import com.exam.costcontrol.entity.Account;
import com.exam.costcontrol.exceptions.AccountAlreadyExistException;
import com.exam.costcontrol.repository.AccountRepository;
import com.exam.costcontrol.service.AccountServer;
import lombok.SneakyThrows;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

;


@RestController
public class AccountController {
    @Autowired
    private AccountRepository accountRepository;


    @GetMapping("account/{account_number}")
    public Account getAccount(@PathVariable(name = "account_number") int account_number) {
        return accountRepository.findById(account_number).orElseThrow(AccountAlreadyExistException::new);
    }

    @GetMapping("/accounts")
    public Iterable<Account> getAllAccounts() {
        return accountRepository.findAll();
    }

    @PostMapping("account")
    public Account createAccount(@RequestBody Account account) {
        Account createAccount = accountRepository.save(account);
        account.setOpenDate(account.getOpenDate());
        return createAccount;

    }


    @DeleteMapping("account/{account_number}")
    public void deleteAccountById(@PathVariable(name = "account_number") int account_number) {
        Account foundAccount = accountRepository.findById(account_number).orElseThrow(AccountAlreadyExistException::new);
        accountRepository.delete(foundAccount);
    }

    @PutMapping("account/{account_number}")
    public Account updateAccountBy(@RequestBody Account account) {
        Account accountNew = accountRepository.findById(account.getAccountNumber()).orElseThrow(AccountAlreadyExistException::new);
        accountRepository.save(accountNew);
        return accountNew;
    }
}
