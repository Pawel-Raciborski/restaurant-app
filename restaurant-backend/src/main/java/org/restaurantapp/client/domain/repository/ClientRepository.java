package org.restaurantapp.client.domain.repository;

import org.restaurantapp.client.domain.Client;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClientRepository extends JpaRepository<Client, Integer> {
}
