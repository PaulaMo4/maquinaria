/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.rentamaquinaria.maquinaria.app.services;

import com.rentamaquinaria.maquinaria.app.entities.Machine;
import com.rentamaquinaria.maquinaria.app.repositories.MachineRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author gemoreno
 */
@Service
public class MachineService {
    
    @Autowired
    private MachineRepository machineRepository;
    /**
     * GET
     * @return 
     */
    public List<Machine> getAll(){
        return machineRepository.getAll();
    }
    /**
     * Buscar cliente por Id
     * @param machineId
     * @return 
     */
    public Optional<Machine> getMachine(int machineId){
        return machineRepository.getMachine(machineId);
    }
    /**
     * POST
     * @param machine
     * @return 
     */
    public Machine saveMachine(Machine machine){
        if(machine.getId()==null){
            return machineRepository.save(machine);
        }else{
            Optional<Machine> resultado = machineRepository.getMachine(machine.getId());
            if(resultado.isPresent()){
                return machine;
            }else{
                return machineRepository.save(machine);
            }
        }
    }
    /**
     * UPDATE
     * @param machine
     * @return 
     */
    public Machine updateMachine(Machine machine){
        if(machine.getId()!=null){
            Optional<Machine> resultado = machineRepository.getMachine(machine.getId());
            if(resultado.isPresent()){
                if(machine.getName()!=null){
                    resultado.get().setName(machine.getName());
                }
                if(machine.getBrand()!=null){
                    resultado.get().setBrand(machine.getBrand());
                }
                if(machine.getYear()!=null){
                    resultado.get().setYear(machine.getYear());
                }
                if(machine.getDescription()!=null){
                    resultado.get().setDescription(machine.getDescription());
                }
                if(machine.getCategory()!=null){
                    resultado.get().setCategory(machine.getCategory());
                }
                machineRepository.save(resultado.get());
                return resultado.get();
            }else{
                return machine;
            } 
        }else{
            return machine;
        }
    }
    /**
     * DELETE
     * @param machineId
     * @return 
     */
    public boolean deleteMachine(int machineId) {
        Boolean aBoolean = getMachine(machineId).map(machine -> {
        machineRepository.delete(machine);
        return true;
        }).orElse(false);
        return aBoolean;
    }
}
