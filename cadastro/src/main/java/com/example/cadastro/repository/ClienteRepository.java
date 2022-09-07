package com.example.cadastro.repository;

import com.example.cadastro.model.Cliente;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface ClienteRepository extends JpaRepository<Cliente, Long> {

    /*
    select de teste no SQL - funcionando
SELECT cliente.nome, cliente.cpf, endereco.endereco
FROM cliente
JOIN endereco ON cliente.id = endereco.cliente_id
WHERE cliente.nome 
LIKE %?1% AND cliente.cpf LIKE %?2% AND endereco.endereco LIKE %?3%;
     */
    
//    @Query(value = "SELECT c.id, c.nome, c.cpf, e.endereco "
//            + "FROM cliente c "
//            + "INNER JOIN endereco e ON c.id = e.cliente_id"
//            + "WHERE c.nome LIKE ?1 OR c.cpf = ?2 OR e.endereco LIKE ?3", nativeQuery = true)
//    public List<Cliente> search(String nome, String cpf, String endereco);

    
    //COMENTÁRIOS: tentei fazer da maneira acima, que julgo ser mais correta, mas a query não funcionou
    
    public List<Cliente> findByCpf(String cpf);

    public List<Cliente> findByNome(String nome);

}
