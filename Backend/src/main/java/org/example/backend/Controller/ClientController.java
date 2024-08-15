package org.example.backend.Controller;

import org.example.backend.Entity.Client;
import org.example.backend.Services.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RequestMapping("GetValues")
@RestController
public class ClientController {
    @Autowired
    private ClientService clientService;

    @PostMapping("register")
    public Client addClient(@RequestBody Client client) {
        return clientService.CreateClient(client);
    }

    @GetMapping("/{id}")
    public Client getClient(@PathVariable String id) {
        return clientService.GetClientById(id);
    }

    @GetMapping
    public List<Client> getAllClients() {
        return clientService.GetAllClients();
    }

    @PutMapping("/{id}")
    public Client updateClient(@PathVariable String id, @RequestBody Client client) {
        return clientService.UpdateClient(id, client);
    }

    @GetMapping("byEmail/{email}")
    public Client getClientByEmail(@PathVariable String email) {
        return clientService.findByEmail(email);
    }

    @GetMapping("IdByEmail/{email}")
    public String getClientIdByEmail(@PathVariable String email) {
        return clientService.findId(email);
    }
}


