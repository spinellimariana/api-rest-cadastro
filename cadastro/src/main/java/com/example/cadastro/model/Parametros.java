/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.cadastro.model;

import javax.persistence.NoResultException;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 *
 * @author maris
 */
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Parametros {

    private String nome;
    private String cpf;
    private String endereco;
    

}
