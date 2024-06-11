package com.example.projectmaromo.domain.client;

import jakarta.persistence.Entity;
import jakarta.persistence.*;
import lombok.*;

@Table(name = "client")
@Entity(name = "client")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(of = "id")
public class Client {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    private String name;

    private String email;

    private String cpf;

    private String phone;

    private String address;

    private String city;

    public Client(RequestClient requestClient) {
        this.name = requestClient.name();
        this.email = requestClient.email();
        this.cpf = requestClient.cpf();
        this.phone = requestClient.phone();
        this.address = requestClient.address();
        this.city = requestClient.city();
    }
}


