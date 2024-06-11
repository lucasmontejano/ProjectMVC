package com.example.projectmaromo.domain.client;

public record  RequestClient (
        Long id,
        String name,
        String email,
        String cpf,
        String phone,
        String address,
        String city
) {}
