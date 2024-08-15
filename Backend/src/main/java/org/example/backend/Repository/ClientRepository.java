package org.example.backend.Repository;

import org.example.backend.Entity.Client;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClientRepository extends MongoRepository<Client, String> {

    public Client findIdByEmail(String email);
    public Client findByEmail(String email);
}
