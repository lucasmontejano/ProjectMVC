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

/**
 * REST controller for managing clients.
 *
 * <p>This class provides endpoints for CRUD operations on clients.</p>
 *
 * @version 1.0
 * @since 2024-06-13
 */
@RestController
@RequestMapping("/clients")
public class ClientController {

    @Autowired
    private ClientRepository clientRepository;

    /**
     * Gets all clients.
     *
     * @return a {@link ResponseEntity} containing the list of all clients
     */
    @GetMapping
    public ResponseEntity getAllClients() {
        var allClients = clientRepository.findAll();
        return ResponseEntity.ok(allClients);
    }

    /**
     * Gets a client by ID.
     *
     * @param id the ID of the client to retrieve
     * @return a {@link ResponseEntity} containing the client if found, or a 404 Not Found status
     */
    @GetMapping("/{id}")
    public ResponseEntity getClientById(@PathVariable Long id) {
        Optional<Client> client = clientRepository.findById(id);
        return client.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    /**
     * Adds a new client.
     *
     * @param data the data of the client to add
     * @return a {@link ResponseEntity} with a 200 OK status
     */
    @PostMapping
    public ResponseEntity addClient(@RequestBody @Valid RequestClient data) {
        Client newClient = new Client(data);
        clientRepository.save(newClient);
        return ResponseEntity.ok().build();
    }

    /**
     * Updates an existing client.
     *
     * @param id   the ID of the client to update
     * @param data the new data for the client
     * @return a {@link ResponseEntity} containing the updated client, or a 404 Not Found status
     * @throws EntityNotFoundException if the client is not found
     */
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

    /**
     * Deletes a client by ID.
     *
     * @param id the ID of the client to delete
     * @return a {@link ResponseEntity} with a 204 No Content status
     */
    @DeleteMapping("/{id}")
    public ResponseEntity deleteClient(@PathVariable Long id) {
        clientRepository.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}