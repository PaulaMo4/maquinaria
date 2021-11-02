
package com.rentamaquinaria.maquinaria.app.services;


import com.rentamaquinaria.maquinaria.app.entities.Client;
import com.rentamaquinaria.maquinaria.app.repositories.ClientRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Paula Moreno
 */
@Service
public class ClientService {
    
    @Autowired
    private ClientRepository clientRepository;
    /**
     * GET
     * @return 
     */
    public List<Client> getAll(){
        return clientRepository.getAll();
    }
    /**
     * Buscar cliente por Id
     * @param clientId
     * @return 
     */
    public Optional<Client> getClient(int clientId){
        return clientRepository.getClient(clientId);
    }
    /**
     * POST
     * @param client
     * @return 
     */
    public Client saveClient(Client client){
        if(client.getIdClient()==null){
            return clientRepository.save(client);
        }else{
            Optional<Client> resultado = clientRepository.getClient(client.getIdClient());
            if(resultado.isPresent()){
                return client;
            }else{
                return clientRepository.save(client);
            }
        }
    }
    /**
     * UPDATE
     * @param client
     * @return 
     */
    public Client updateClient(Client client){
        if(client.getIdClient()!=null){
            Optional<Client> resultado = clientRepository.getClient(client.getIdClient());
            if(resultado.isPresent()){
                if(client.getEmail()!=null){
                    resultado.get().setEmail(client.getEmail());
                }
                if(client.getPassword()!=null){
                    resultado.get().setPassword(client.getPassword());
                }
                if(client.getName()!=null){
                    resultado.get().setName(client.getName());
                }
                if(client.getAge()!=null){
                    resultado.get().setAge(client.getAge());
                }
                clientRepository.save(resultado.get());
                return resultado.get();
            }else{
                return client;
            } 
        }else{
            return client;
        }
    }
    /**
     * DELETE
     * @param clientId
     * @return 
     */
    public boolean deleteClient(int clientId) {
        Boolean aBoolean = getClient(clientId).map(client -> {
        clientRepository.delete(client);
        return true;
        }).orElse(false);
        return aBoolean;
    }
}
