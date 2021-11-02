/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.rentamaquinaria.maquinaria.app.controllers;


import com.rentamaquinaria.maquinaria.app.entities.Machine;
import com.rentamaquinaria.maquinaria.app.services.MachineService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author gemoreno
 */
@RestController
@RequestMapping("Machine")
public class MachineController {
    
    @Autowired
    private MachineService service;
    /**
     * GET
     * @return 
     */
    @GetMapping("/all")
    public List<Machine> getMachines(){
        return service.getAll();
    }
    /**
     * POST
     * @param machine
     * @return 
     */
    @PostMapping("/save")
    @ResponseStatus(HttpStatus.CREATED)
    public Machine saveMachine(@RequestBody Machine machine){
        return service.saveMachine(machine);
    }
    /**
     * PUT
     * @param machine
     * @return 
     */
    @PutMapping("/update")
    @ResponseStatus(HttpStatus.CREATED)
    public Machine updateMachine(@RequestBody Machine machine){
        return service.updateMachine(machine);
    }
    /**
     * DELETE
     * @param machineId
     * @return 
     */
    @DeleteMapping("/{id}")
    public boolean delete(@PathVariable("id") int machineId) {
        return service.deleteMachine(machineId);
    }
}
