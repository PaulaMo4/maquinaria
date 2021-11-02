
package com.rentamaquinaria.maquinaria.app.repositories;

import com.rentamaquinaria.maquinaria.app.entities.Client;
import com.rentamaquinaria.maquinaria.app.repositories.crud.ClientCrudRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Paula Moreno
 */
@Repository
public class ClientRepository {
    
    @Autowired
    private ClientCrudRepository clientCrudRepository;
    
    /**
     * Select
     * @return Lista de clientes
     */
    public List<Client> getAll(){
        return (List<Client>) clientCrudRepository.findAll();
    }
    /**
     * Insert
     * @param client
     * @return 
     */
    public Client save(Client client){
	        return clientCrudRepository.save(client);
    }
    /**
     * Buscar registro
     * @param clientId
     * @return 
     */
    public Optional<Client> getClient(int clientId){
        return clientCrudRepository.findById(clientId);
    }
    /**
     *Delete
     * @param client 
     */
    public void delete(Client client){
	        clientCrudRepository.delete(client);
	    }
}