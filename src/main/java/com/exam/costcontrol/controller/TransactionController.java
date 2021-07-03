package com.exam.costcontrol.controller;

import com.exam.costcontrol.entity.Transaction;
import com.exam.costcontrol.entity.enums.TransactionType;
import com.exam.costcontrol.repository.AccountRepository;
import com.exam.costcontrol.repository.TransactionRepository;
import com.exam.costcontrol.service.AccountServer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;

@RestController
public class TransactionController {

    @Autowired
    private TransactionRepository transactionRepository;
    @Autowired
    private AccountServer accountServer;
    @Autowired
    private AccountRepository accountRepository;


    @GetMapping("transactions")
    public Iterable<Transaction> getTransactionList() {
        return transactionRepository.findAll();
    }

    @PostMapping("transaction")//транзакция(пополнение или снятие)
    public Transaction createTransaction(@RequestBody Transaction transaction) {
        if (transaction.getType().equals(TransactionType.EXPENSES)) {
            double sumTotal = transaction.getPlusMoney();
            double accountBalance = accountServer.getBalance(transaction.getAccount().getAccountNumber());
            double resultPlus = sumTotal + accountBalance;
            Transaction transactionExpenses = new Transaction();
            transactionExpenses.setPlusMoney(resultPlus);
            transactionExpenses.setMinusMoney(transaction.getMinusMoney());
            transactionRepository.save(transactionExpenses);
            accountServer.updateBalance(accountBalance, resultPlus);
            return transactionExpenses;
        }
        if (transaction.getType().equals(TransactionType.REVENUES)) {
            double minusTotal = transaction.getMinusMoney();
            double accountBalance = accountServer.getBalance(transaction.getAccount().getAccountNumber());
            if (minusTotal > accountBalance) {
                System.out.println("Недостаточно сдеств");
                return null;
            }
            double resultMinus = accountBalance - minusTotal;
            Transaction transactionRevenues = new Transaction();
            transactionRevenues.setPlusMoney(resultMinus);
            transactionRevenues.setMinusMoney(transaction.getPlusMoney());
            transactionRepository.save(transactionRevenues);
            accountServer.updateBalance(accountBalance, resultMinus);
            return transactionRevenues;
        }
        return null;
    }

    @PostMapping("transaction/return")
    public Transaction returnMoney(@RequestBody Transaction transaction) {
        double accountBalancePlus = accountServer.getBalance(transaction.getAccount().getAccountNumber());
        double result = accountBalancePlus - transaction.getPlusMoney();

        Transaction transactionReturn = new Transaction();
        transactionReturn.setDescription("Возврат");
        transactionReturn.setMinusMoney(transaction.getMinusMoney());
        transactionReturn.setPlusMoney(result);
        transactionRepository.save(transactionReturn);
        accountServer.updateBalance(accountBalancePlus, result);
        return transactionReturn;
    }
}
