/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.rentamaquinaria.maquinaria.app.services;

import com.rentamaquinaria.maquinaria.app.entities.Score;
import com.rentamaquinaria.maquinaria.app.repositories.ScoreRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author gemoreno
 */
@Service
public class ScoreService {
    
    @Autowired
    private ScoreRepository scoreRepository;
    /**
     * GET
     * @return 
     */
    public List<Score> getAll(){
        return scoreRepository.getAll();
    }
    /**
     * Buscar cliente por Id
     * @param scoreId
     * @return 
     */
    public Optional<Score> getScore(int scoreId){
        return scoreRepository.getScore(scoreId);
    }
    /**
     * POST
     * @param score
     * @return 
     */
    public Score saveScore(Score score){
        if(score.getIdScore()==null){
            return scoreRepository.save(score);
        }else{
            Optional<Score> resultado = scoreRepository.getScore(score.getIdScore());
            if(resultado.isPresent()){
                return score;
            }else{
                return scoreRepository.save(score);
            }
        }
    }
    /**
     * UPDATE
     * @param score
     * @return 
     */
    public Score updateScore(Score score){
        if(score.getIdScore()!=null){
            Optional<Score> resultado = scoreRepository.getScore(score.getIdScore());
            if(resultado.isPresent()){
                if(score.getMessageText()!=null){
                    resultado.get().setMessageText(score.getMessageText());
                }
                if(score.getStars()!=null){
                    resultado.get().setStars(score.getStars());
                }
                scoreRepository.save(resultado.get());
                return resultado.get();
            }else{
                return score;
            } 
        }else{
            return score;
        }
    }
    /**
     * DELETE
     * @param scoreId
     * @return 
     */
    public boolean deleteScore(int scoreId) {
        Boolean aBoolean = getScore(scoreId).map(score -> {
        scoreRepository.delete(score);
        return true;
        }).orElse(false);
        return aBoolean;
    }
}
