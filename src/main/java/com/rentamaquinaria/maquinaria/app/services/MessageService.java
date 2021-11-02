
package com.rentamaquinaria.maquinaria.app.services;

import com.rentamaquinaria.maquinaria.app.entities.Message;
import com.rentamaquinaria.maquinaria.app.repositories.MessageRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author gemoreno
 */
@Service
public class MessageService {
    
    @Autowired
    private MessageRepository messageRepository;
    /**
     * GET
     * @return 
     */
    public List<Message> getAll(){
        return messageRepository.getAll();
    }
    /**
     * Buscar mensaje por Id
     * @param messageId
     * @return 
     */
    public Optional<Message> getMessage(int messageId){
        return messageRepository.getMessage(messageId);
    }
    /**
     * POST
     * @param message
     * @return 
     */
    public Message saveMessage(Message message){
        if(message.getIdMessage()==null){
            return messageRepository.save(message);
        }else{
            Optional<Message> resultado = messageRepository.getMessage(message.getIdMessage());
            if(resultado.isPresent()){
                return message;
            }else{
                return messageRepository.save(message);
            }
        }
    }
    /**
     * UPDATE
     * @param message
     * @return 
     */
    public Message updateMessage(Message message){
        if(message.getIdMessage()!=null){
            Optional<Message> resultado = messageRepository.getMessage(message.getIdMessage());
            if(resultado.isPresent()){
                if(message.getMessageText()!=null){
                    resultado.get().setMessageText(message.getMessageText());
                }
                messageRepository.save(resultado.get());
                return resultado.get();
            }else{
                return message;
            } 
        }else{
            return message;
        }
    }
    /**
     * DELETE
     * @param messageId
     * @return 
     */
    public boolean deleteMessage(int messageId) {
        Boolean aBoolean = getMessage(messageId).map(message -> {
        messageRepository.delete(message);
        return true;
        }).orElse(false);
        return aBoolean;
    }
}
