package com.github.marcelomachadoxd.crudclientes.services;

import com.github.marcelomachadoxd.crudclientes.DTO.ClientDTO;
import com.github.marcelomachadoxd.crudclientes.model.entities.Client;
import com.github.marcelomachadoxd.crudclientes.repositories.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
public class ClientService {

    @Autowired
    private ClientRepository clientRepository;

    @Transactional(readOnly = true)
    public ClientDTO findByID(Long id) {
        Optional<Client> obj = clientRepository.findById(id);
        Client client = obj.orElseThrow(() -> new RuntimeException("Entity not found with id: " + id));
        return new ClientDTO(client);

    }


    @Transactional(readOnly = true)
    public Page<ClientDTO> findAll(PageRequest pageRequest) {
        Page<Client> list = clientRepository.findAll(pageRequest);

        return list.map(ClientDTO::new);
    }
}
