package org.example.backend.Services;

import org.example.backend.Entity.Account;
import org.example.backend.Entity.TransactionStatus;
import org.example.backend.Entity.TransactionType;
import org.example.backend.Repository.AccountRepository;
import org.example.backend.Repository.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class AccountService {
    @Autowired
    private AccountRepository accountRepository;
    @Autowired
    private ClientRepository clientRepository;
    @Autowired
    private TransactionService transactionService;

    public Account createAccount(Account account) {
        if (account.getClientID() == null) {
            throw new IllegalArgumentException("Client ID must not be null");
        }

        if (!clientRepository.existsById(account.getClientID())) {
            throw new IllegalArgumentException("Invalid client ID: " + account.getClientID());
        }

        return accountRepository.save(account);
    }
    public List<Account> getAllAccounts() {
        return accountRepository.findAll();
    }

    public Account getAccountById(String id) {
        return accountRepository.findById(id).orElse(null);
    }
    public Optional<Account> getAccountByAccountNumber(Integer accountNumber) {
        return accountRepository.findByAccountNumber(accountNumber);
    }

    //Transactions

    public Account deposit(String accountId, Double amount, LocalDateTime dateTime) {
        Account account = getAccountById(accountId);
        account.setBalance(account.getBalance() + amount);
        accountRepository.save(account);


        transactionService.createTransaction(accountId,amount,dateTime,TransactionType.Deposit, TransactionStatus.Success);

        return account;
    }

    public String withdraw(String accountId, Double amount, LocalDateTime dateTime) {
        Optional<Account> optionalAccount = accountRepository.findById(accountId);

        if(optionalAccount.isPresent()){

            Account account = optionalAccount.get();
            if(account.getBalance() > amount){
                account.setBalance(account.getBalance() - amount);
                accountRepository.save(account);

                transactionService.createTransaction(accountId,amount,dateTime,TransactionType.Withdrawal, TransactionStatus.Success);

            }else{
                transactionService.createTransaction(accountId,amount,dateTime,TransactionType.Withdrawal, TransactionStatus.Failed);
            }


        }
        else{
            System.out.println("Account not found");
        }
        return "done";
    }

    public String transfer(String fromAccountId, String toAccountId, Double amount, LocalDateTime dateTime) {
        Optional<Account> fromAccount = accountRepository.findById(fromAccountId);
        Optional<Account> toAccount = accountRepository.findById(toAccountId);
        if(!fromAccount.isPresent()){
            System.out.println("Sender not found");
        }
        if(!toAccount.isPresent()){
            System.out.println("Receiver not found");
        }

        Account fromAc = fromAccount.get();
        Account toAc = toAccount.get();

        if(fromAc.getBalance() > amount){
            fromAc.setBalance(fromAc.getBalance() - amount);
            toAc.setBalance(toAc.getBalance() + amount);
            accountRepository.save(fromAc);
            accountRepository.save(toAc);

            transactionService.createTransaction(fromAccountId,amount,dateTime,TransactionType.Transfer,TransactionStatus.Success);
            transactionService.createTransaction(toAccountId,amount,dateTime,TransactionType.Transfer,TransactionStatus.Success);
        }
        else{
            System.out.println("Insufficient balance");
        }
        return "done";
    }
}
