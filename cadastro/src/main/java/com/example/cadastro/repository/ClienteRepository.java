/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.cadastro.repository;

import com.example.cadastro.model.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author maris
 */
public interface ClienteRepository extends JpaRepository<Cliente, Long>{
    
}
