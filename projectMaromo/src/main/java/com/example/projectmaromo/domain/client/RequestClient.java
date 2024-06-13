package com.example.projectmaromo.domain.client;

/**
 * Record representing a client request.
 *
 * <p>This record encapsulates the data required for client-related operations.</p>
 *
 * @param id      the ID of the client
 * @param name    the name of the client
 * @param email   the email of the client
 * @param cpf     the CPF (Cadastro de Pessoas Físicas) of the client
 * @param phone   the phone number of the client
 * @param address the address of the client
 * @param city    the city of the client
 */
public record RequestClient (
        Long id,
        String name,
        String email,
        String cpf,
        String phone,
        String address,
        String city
) {}
