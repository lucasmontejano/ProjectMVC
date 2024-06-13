package com.example.projectmaromo.domain.client;

import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Repository interface for managing {@link Client} entities.
 *
 * <p>This interface extends {@link JpaRepository} to provide CRUD operations for {@link Client} entities.</p>
 *
 * @see Client
 * @see JpaRepository
 */
public interface ClientRepository extends JpaRepository<Client, Long> {
}
