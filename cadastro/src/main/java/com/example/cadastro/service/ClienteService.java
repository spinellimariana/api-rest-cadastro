package com.example.cadastro.service;

import java.util.Optional;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.cadastro.exception.NotFoundException;
import com.example.cadastro.model.Cliente;
import com.example.cadastro.model.Endereco;
import com.example.cadastro.model.Parametros;
import com.example.cadastro.repository.ClienteRepository;
import com.example.cadastro.repository.EnderecoRepository;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Service
public class ClienteService {

    @Autowired
    private ClienteRepository clienteRepository;

    @Autowired
    private EnderecoRepository enderecoRepository;

    public Cliente findOne(Long id) throws NotFoundException {
        Optional<Cliente> cliente = clienteRepository.findById(id);

        if (!cliente.isPresent()) {
            new NotFoundException("Cliente não encontrato no ID: " + id);
        }

        return cliente.get();
    }

    public List<Cliente> localizarCliente(Parametros parametros) {
        String cNome = parametros.getNome();
        String cCpf = parametros.getCpf();
        String cEndereco = parametros.getEndereco();
        
        Cliente cli = new Cliente();

        List<Cliente> cliente = new ArrayList();
        //List<Endereco> endereco = new ArrayList();

        if (!cCpf.isBlank() || !cCpf.isEmpty()) {
            List<Cliente> clienteCpf = clienteRepository.findByCpf(cCpf);
            cliente.addAll(clienteCpf);
        }

        if (!cNome.isBlank() || !cNome.isEmpty()) {
            List<Cliente> clienteNome = clienteRepository.findByNome(cNome);
            cliente.addAll(clienteNome);
        }

        if (!cEndereco.isBlank() || !cEndereco.isEmpty()) {
            Set<Endereco> clienteEndereco = enderecoRepository.findByEndereco(cEndereco);
            cli.setEndereco(clienteEndereco);
            cli.getId();
            cli.getNome();
            cli.getEndereco();
            cli.getCpf();
            cliente.add(cli);
        }

        return cliente;

    }

    public Cliente inserirCliente(Cliente cliente) {
        Set<Endereco> endereco = cliente.getEndereco();
        cliente.setEndereco(null);
        clienteRepository.save(cliente);

        for (Endereco end : endereco) {
            end.setCliente(cliente);
            enderecoRepository.save(end);
        }

        cliente.setEndereco(endereco);

        return cliente;
    }

    public Cliente alterarCliente(Cliente cliente, Long id) {
        findOne(id);
        Set<Endereco> enderecoNovo = cliente.getEndereco();
        cliente.setEndereco(null);
        cliente.setId(id);
        clienteRepository.save(cliente);

        Set<Endereco> enderecoAntigo = enderecoRepository.findByClienteId(id);
        for (Endereco end : enderecoAntigo) {
            enderecoRepository.delete(end);
        }

        for (Endereco endNovo : enderecoNovo) {
            endNovo.setCliente(cliente);
            enderecoRepository.save(endNovo);
        }

        cliente.setEndereco(enderecoNovo);

        return cliente;
    }

    public Cliente excluirCliente(Long id) {
        Cliente cliente = findOne(id);
        clienteRepository.delete(cliente);
        return cliente;

    }
}
