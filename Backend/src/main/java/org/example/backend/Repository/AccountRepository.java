package org.example.backend.Repository;

import org.example.backend.Entity.Account;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface AccountRepository extends MongoRepository<Account, String> {
    public Optional<Account> findByAccountNumber(Integer accountNumber);
}
