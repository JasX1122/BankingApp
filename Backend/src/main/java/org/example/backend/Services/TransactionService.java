package org.example.backend.Services;

import org.example.backend.Entity.Transaction;
import org.example.backend.Entity.TransactionStatus;
import org.example.backend.Entity.TransactionType;
import org.example.backend.Repository.TransactionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class TransactionService {
    @Autowired
    private TransactionRepository transactionRepository;

    public Transaction createTransaction(String accountId, double amount, LocalDateTime time, TransactionType type, TransactionStatus status) {
        Transaction newTransaction = new Transaction();
        newTransaction.setAccountId(accountId);
        newTransaction.setAmount(amount);
        newTransaction.setTransactionDate(time);
        newTransaction.setTXType(type);
        newTransaction.setTXStatus(status);
        return transactionRepository.save(newTransaction);

    }
}
