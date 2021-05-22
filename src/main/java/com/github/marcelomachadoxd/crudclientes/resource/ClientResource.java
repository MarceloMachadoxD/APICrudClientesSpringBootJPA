package com.github.marcelomachadoxd.crudclientes.resource;

import com.github.marcelomachadoxd.crudclientes.DTO.ClientDTO;
import com.github.marcelomachadoxd.crudclientes.model.entities.Client;
import com.github.marcelomachadoxd.crudclientes.services.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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


    @GetMapping
    public ResponseEntity<Page<ClientDTO>> findAll(

        @RequestParam(value = "page", defaultValue = "0")Integer page,
        @RequestParam(value = "linesPerPage", defaultValue = "5") Integer linesPerPage,
        @RequestParam(value = "direction", defaultValue = "ASC") String direction,
        @RequestParam(value = "orderBy", defaultValue = "id") String orderBy

        ){
        PageRequest pageRequest = PageRequest.of(page, linesPerPage, Sort.Direction.valueOf(direction), orderBy);

        Page<ClientDTO> list = clientService.findAll(pageRequest);
        return ResponseEntity.ok().body(list);
    }


}
