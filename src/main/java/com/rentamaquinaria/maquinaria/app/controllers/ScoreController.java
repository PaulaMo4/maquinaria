/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.rentamaquinaria.maquinaria.app.controllers;

import com.rentamaquinaria.maquinaria.app.entities.Score;
import com.rentamaquinaria.maquinaria.app.services.ScoreService;
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
@RequestMapping("Score")
public class ScoreController {
    
    @Autowired
    private ScoreService service;
    /**
     * GET
     * @return 
     */
    @GetMapping("/all")
    public List<Score> getScores(){
        return service.getAll();
    }
    /**
     * POST
     * @param score
     * @return 
     */
    @PostMapping("/save")
    @ResponseStatus(HttpStatus.CREATED)
    public Score saveScore(@RequestBody Score score){
        return service.saveScore(score);
    }
    /**
     * PUT
     * @param score
     * @return 
     */
    @PutMapping("/update")
    @ResponseStatus(HttpStatus.CREATED)
    public Score updateScore(@RequestBody Score score){
        return service.updateScore(score);
    }
    /**
     * DELETE
     * @param scoreId
     * @return 
     */
    @DeleteMapping("/{id}")
    public boolean delete(@PathVariable("id") int scoreId) {
        return service.deleteScore(scoreId);
    }
}
