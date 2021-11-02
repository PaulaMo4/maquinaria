/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.rentamaquinaria.maquinaria.app.repositories.crud;

import com.rentamaquinaria.maquinaria.app.entities.Client;
import org.springframework.data.repository.CrudRepository;

/**
 *
 * @author gemoreno
 */
public interface ClientCrudRepository extends CrudRepository<Client,Integer>{
    
}
