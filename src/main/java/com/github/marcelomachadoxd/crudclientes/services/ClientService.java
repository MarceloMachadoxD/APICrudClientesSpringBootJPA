package com.github.marcelomachadoxd.crudclientes.services;

import com.github.marcelomachadoxd.crudclientes.DTO.ClientDTO;
import com.github.marcelomachadoxd.crudclientes.model.entities.Client;
import com.github.marcelomachadoxd.crudclientes.repositories.ClientRepository;
import com.github.marcelomachadoxd.crudclientes.services.exception.DatabaseException;
import com.github.marcelomachadoxd.crudclientes.services.exception.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityNotFoundException;
import java.util.Optional;

@Service
public class ClientService {

    @Autowired
    private ClientRepository clientRepository;

    @Transactional(readOnly = true)
    public ClientDTO findByID(Long id) {

        try {
            Optional<Client> obj = clientRepository.findById(id);
            Client client = obj.orElseThrow(() -> new EntityNotFoundException("Entity not found with id: " + id));
            return new ClientDTO(client);
        } catch (EntityNotFoundException e){
            throw new ResourceNotFoundException("id not found " + id);
        }


    }


    @Transactional(readOnly = true)
    public Page<ClientDTO> findAll(PageRequest pageRequest) {
        Page<Client> list = clientRepository.findAll(pageRequest);

        return list.map(ClientDTO::new);
    }

    @Transactional(readOnly = false)
    public void deleteClientByID(Long id) {
        try {
            clientRepository.deleteById(id);
        } catch (EmptyResultDataAccessException e){
            throw new ResourceNotFoundException("Error deleting id " + id);
        } catch (DataIntegrityViolationException e){
            throw new DatabaseException("Integrity  violation trying to delete client" + id);
        }

    }

    @Transactional(readOnly = false)
    public ClientDTO insert(ClientDTO clientDTO) {
        Client client = new Client();

        copyDTOtoEntity(clientDTO, client);

        client = clientRepository.save(client);
        return new ClientDTO(client);
    }

    @Transactional(readOnly = false)
    public ClientDTO update(Long id, ClientDTO clientDTO) {
        try {
            Client client = clientRepository.getOne(id);

            copyDTOtoEntity(clientDTO, client);

            return new ClientDTO(client);
        } catch (EntityNotFoundException e){
            throw new ResourceNotFoundException("Not found id " + clientDTO.getId());
        }

    }

    private void copyDTOtoEntity(ClientDTO clientDTO, Client client){
        client.setName(clientDTO.getName());
        client.setCpf(clientDTO.getCpf());
        client.setBirtDate(clientDTO.getBirthDate());
        client.setChildren(clientDTO.getChildren());
        client.setIncome(client.getIncome());
    }
}
