package com.example.projectmaromo.domain.client;

import jakarta.persistence.Entity;
import jakarta.persistence.*;
import lombok.*;

/**
 * Entity representing a client.
 *
 * <p>This class maps to the "client" table in the database and contains client details.</p>
 *
 * @version 1.0
 * @since 2024-06-13
 */
@Table(name = "client")
@Entity(name = "client")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(of = "id")
public class Client {

    /**
     * The unique identifier for the client.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    /**
     * The name of the client.
     */
    private String name;

    /**
     * The email of the client.
     */
    private String email;

    /**
     * The CPF (Cadastro de Pessoas Físicas) of the client.
     */
    private String cpf;

    /**
     * The phone number of the client.
     */
    private String phone;

    /**
     * The address of the client.
     */
    private String address;

    /**
     * The city of the client.
     */
    private String city;

    /**
     * Constructs a new {@code Client} from a {@code RequestClient}.
     *
     * @param requestClient the {@code RequestClient} containing client data
     */
    public Client(RequestClient requestClient) {
        this.name = requestClient.name();
        this.email = requestClient.email();
        this.cpf = requestClient.cpf();
        this.phone = requestClient.phone();
        this.address = requestClient.address();
        this.city = requestClient.city();
    }
}
