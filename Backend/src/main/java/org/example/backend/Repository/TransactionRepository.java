package org.example.backend.Repository;

import org.example.backend.Entity.Transaction;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TransactionRepository extends MongoRepository<Transaction, String> {
    public Transaction findByAccountId(String accountId);

}
