package org.example.backend.Services;

import org.example.backend.Entity.Client;
import org.example.backend.Repository.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.List;

@Service
public class ClientService {
    @Autowired
    private ClientRepository clientRepository;


    public Client CreateClient(Client client) {
                return clientRepository.save(client);
    }

    public Client GetClientById(String id) {
        return clientRepository.findById(id).orElse(null);  // Finds by String ID
    }

    public List<Client> GetAllClients() {
        return clientRepository.findAll();
    }

    public Client UpdateClient(String id,Client client) {
        Client ExistingClient = clientRepository.findById(id).orElse(null);
        if (ExistingClient != null) {
            ExistingClient.setAddress(client.getAddress());
            ExistingClient.setCity(client.getCity());
            ExistingClient.setZip(client.getZip());
            ExistingClient.setPhone(client.getPhone());
        }
        else{
            System.out.println("Client not found");
        }
        return clientRepository.save(client);
    }
    public Client findByEmail(String email) {
        Client client =  clientRepository.findByEmail(email); // working
        return client;
    }
    public String findId(String email) {
        Client client = clientRepository.findByEmail(email);
        System.out.println(client);
        if (client != null) {
            String id = client.getId();  // Use instance method to get ID
            System.out.println("Client ID: " + id);
            return id;
        } else {
            System.out.println("Client not found");
            return null;  // Or throw an exception, depending on your use case
        }
    }
}
