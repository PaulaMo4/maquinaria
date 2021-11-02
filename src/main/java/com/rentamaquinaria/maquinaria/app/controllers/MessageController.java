/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.rentamaquinaria.maquinaria.app.controllers;

import com.rentamaquinaria.maquinaria.app.entities.Message;
import com.rentamaquinaria.maquinaria.app.services.MessageService;
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
@RequestMapping("Message")
public class MessageController {
    
     @Autowired
    private MessageService service;
    /**
     * GET
     * @return 
     */
    @GetMapping("/all")
    public List<Message> getMessages(){
        return service.getAll();
    }
    /**
     * POST
     * @param message
     * @return 
     */
    @PostMapping("/save")
    @ResponseStatus(HttpStatus.CREATED)
    public Message saveMessage(@RequestBody Message message){
        return service.saveMessage(message);
    }
    /**
     * PUT
     * @param message
     * @return 
     */
    @PutMapping("/update")
    @ResponseStatus(HttpStatus.CREATED)
    public Message updateMessage(@RequestBody Message message){
        return service.updateMessage(message);
    }
    /**
     * DELETE
     * @param messageId
     * @return 
     */
    @DeleteMapping("/{id}")
    public boolean delete(@PathVariable("id") int messageId) {
        return service.deleteMessage(messageId);
    }
}
