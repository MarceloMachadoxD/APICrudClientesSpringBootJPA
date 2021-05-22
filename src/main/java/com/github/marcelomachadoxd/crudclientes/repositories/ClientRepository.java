package com.github.marcelomachadoxd.crudclientes.repositories;


import com.github.marcelomachadoxd.crudclientes.model.entities.Client;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClientRepository extends JpaRepository<Client, Long> {
}
