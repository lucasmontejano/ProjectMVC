package com.example.projectmaromo.controllers;

import com.example.projectmaromo.domain.client.Client;
import com.example.projectmaromo.domain.client.ClientRepository;
import com.example.projectmaromo.domain.client.RequestClient;
import jakarta.persistence.EntityNotFoundException;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/clients")
public class ClientController {

    @Autowired
    private ClientRepository clientRepository;

    @GetMapping
    public ResponseEntity getAllClients() {
        var allClients = clientRepository.findAll();
        return ResponseEntity.ok(allClients);
    }

    @GetMapping("/{id}")
    public ResponseEntity getClientById(@PathVariable Long id) {
        Optional<Client> client = clientRepository.findById(id);
        return client.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity addClient(@RequestBody @Valid RequestClient data) {
        Client newClient = new Client(data);
        clientRepository.save(newClient);
        return ResponseEntity.ok().build();
    }

    @PutMapping("/{id}")
    @Transactional
    public ResponseEntity updateClient(@PathVariable Long id, @RequestBody @Valid RequestClient data) {
        Optional<Client> optionalClient = clientRepository.findById(id);

        if (optionalClient.isPresent()) {
            Client client = optionalClient.get();

            client.setName(data.name());
            client.setEmail(data.email());
            client.setCpf(data.cpf());
            client.setPhone(data.phone());
            client.setAddress(data.address());
            client.setCity(data.city());
            return ResponseEntity.ok(client);
        } else {
            throw new EntityNotFoundException();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity deleteClient(@PathVariable Long id) {
        clientRepository.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
