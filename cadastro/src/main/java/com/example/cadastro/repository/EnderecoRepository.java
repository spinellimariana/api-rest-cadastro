package com.example.cadastro.repository;

import com.example.cadastro.model.Endereco;
import java.util.Set;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EnderecoRepository extends JpaRepository<Endereco, Long> {
    
    Set<Endereco> findByClienteId(Long clienteId);
    
    Set<Endereco> findByEndereco(String endereco);
    
}
