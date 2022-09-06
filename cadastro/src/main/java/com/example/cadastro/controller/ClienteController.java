package com.example.cadastro.controller;


import javax.validation.Valid;

import com.example.cadastro.model.Cliente;
import com.example.cadastro.model.Parametros;
import com.example.cadastro.service.ClienteService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class ClienteController {

    @Autowired
    private ClienteService clienteService;

    @PostMapping("/cliente")
    public Cliente incluir(@Valid @RequestBody Cliente cliente) {
        return clienteService.inserirCliente(cliente);
    }

    @PutMapping("/cliente/{id}")
    public Cliente alterar(@PathVariable Long id,
            @Valid @RequestBody Cliente cliente) {
        return clienteService.alterarCliente(cliente, id);
    }

    @DeleteMapping("/cliente/{id}")
    public Cliente excluir(@PathVariable Long id) {
        return clienteService.excluirCliente(id);
    }
    
    @PostMapping("/cliente/localizar")
    public List<Cliente> localizar(@Valid @RequestBody Parametros parametros){
        return clienteService.localizarCliente(parametros);
    }
}
