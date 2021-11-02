
package com.rentamaquinaria.maquinaria.app.repositories;

import com.rentamaquinaria.maquinaria.app.entities.Machine;
import com.rentamaquinaria.maquinaria.app.repositories.crud.MachineCrudRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 *
 * @author gemoreno
 */
@Repository
public class MachineRepository {
    
    @Autowired
    private MachineCrudRepository machineCrudRepository;
    
    /**
     * Select
     * @return Lista de máquinas
     */
    public List<Machine> getAll(){
        return (List<Machine>) machineCrudRepository.findAll();
    }
    /**
     * Insert
     * @param machine
     * @return 
     */
    public Machine save(Machine machine){
	        return machineCrudRepository.save(machine);
    }
    /**
     * Buscar registro
     * @param machineId
     * @return 
     */
    public Optional<Machine> getMachine(int machineId){
        return machineCrudRepository.findById(machineId);
    }
    /**
     *Delete
     * @param machine 
     */
    public void delete(Machine machine){
	        machineCrudRepository.delete(machine);
	    }
}
