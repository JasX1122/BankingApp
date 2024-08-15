package org.example.backend.Controller;

import org.example.backend.Entity.Account;
import org.example.backend.Entity.TransactionStatus;
import org.example.backend.Entity.TransactionType;
import org.example.backend.Services.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@RequestMapping("/accounts")
@RestController
public class AccountController {
    @Autowired
    private AccountService accountService;

    @PostMapping("/create")
    public Account createAccount(@RequestBody Account account){
        return accountService.createAccount(account);
    }
    @GetMapping("/getAll")
    public List<Account> getAllAccounts(){
        return accountService.getAllAccounts();
    }
    @GetMapping("/number/{number}")
    public ResponseEntity<Account> getAccountByNumber(@PathVariable Integer number) {
        System.out.println("Account number: " + number);
        Optional<Account> accountOpt = accountService.getAccountByAccountNumber(number);
        System.out.println("Account found: " + accountOpt);
        return accountOpt.map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }
    @GetMapping("/id/{id}")
    public Account getAccountById(@PathVariable String id){
       Account account = accountService.getAccountById(id);
        System.out.println(account);
        return accountService.getAccountById(id);
    }

    // transactions

    @PostMapping("/deposit")
    public Account deposit(String accountId, Double amount, LocalDateTime dateTime){
     return accountService.deposit(accountId,amount,dateTime);
    }

    @PostMapping("/withdraw")
    public String withdraw(String accountId, Double amount, LocalDateTime dateTime){
        return accountService.withdraw(accountId,amount,dateTime);
    }

    @PostMapping("/transfer")
    public String transfer(String fromAccountId,String toAccountId, Double amount, LocalDateTime dateTime){
        return accountService.transfer(fromAccountId,toAccountId,amount,dateTime);
    }
}
