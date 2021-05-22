package com.github.marcelomachadoxd.crudclientes.resource;

import com.github.marcelomachadoxd.crudclientes.DTO.ClientDTO;
import com.github.marcelomachadoxd.crudclientes.services.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/clients")
public class ClientResource {

    @Autowired
    private ClientService clientService;


    @GetMapping(value = "/{id}")
    public ResponseEntity<ClientDTO> findByID(@PathVariable Long id) {
        ClientDTO clientDTO = clientService.findByID(id);
        return ResponseEntity.ok().body(clientDTO);
    }


}
