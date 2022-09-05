/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.cadastro.repository;

import com.example.cadastro.model.Cliente;
import com.example.cadastro.model.Endereco;
import java.util.List;
import java.util.Set;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
//import org.springframework.data.jpa.repository.Query;

public interface ClienteRepository extends JpaRepository<Cliente, Long> {

    /*
SELECT cliente.nome, cliente.cpf, endereco.endereco
FROM cliente
JOIN endereco ON cliente.id = endereco.cliente_id
WHERE cliente.nome 
LIKE '%mariana%' AND cliente.cpf LIKE '%111.111.111-13%' AND endereco.endereco LIKE '%mariana%';
     */
    
//    @Query("SELECT c.nome, c.cpf, e.endereco FROM cliente c JOIN endereco e ON c.id = e.cliente_id WHERE c.nome LIKE %?1% AND c.cpf LIKE %?2% AND e.endereco LIKE %?3%")
//    public List<Cliente> localizarCliente(String nome, String cpf, String endereco);
    
    public List<Cliente> findByCpf(String cpf);
    
    public List<Cliente> findByNome(String nome);
    
    //public Set<Endereco> findByEndereco(String endereco);

    
    
    
    
    //usamos assim no PI
//    @Query("SELECT u FROM Usuario u WHERE u.nome like %?1%")
//    public List<Cliente> search(String keyword);
}
