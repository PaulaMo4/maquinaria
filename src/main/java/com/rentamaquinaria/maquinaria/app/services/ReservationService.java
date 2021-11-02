/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.rentamaquinaria.maquinaria.app.services;

import com.rentamaquinaria.maquinaria.app.entities.Reservation;
import com.rentamaquinaria.maquinaria.app.repositories.ReservationRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
/**
 *
 * @author gemoreno
 */
@Service
public class ReservationService {
    
    @Autowired
    private ReservationRepository reservationRepository;
    /**
     * GET
     * @return 
     */
    public List<Reservation> getAll(){
        return reservationRepository.getAll();
    }
    /**
     * Buscar cliente por Id
     * @param reservationId
     * @return 
     */
    public Optional<Reservation> getReservation(int reservationId){
        return reservationRepository.getReservation(reservationId);
    }
    /**
     * POST
     * @param reservation
     * @return 
     */
    public Reservation saveReservation(Reservation reservation){
        if(reservation.getIdReservation()==null){
            return reservationRepository.save(reservation);
        }else{
            Optional<Reservation> resultado = reservationRepository.getReservation(reservation.getIdReservation());
            if(resultado.isPresent()){
                return reservation;
            }else{
                return reservationRepository.save(reservation);
            }
        }
    }
    /**
     * UPDATE
     * @param reservation
     * @return 
     */
    public Reservation updateReservation(Reservation reservation){
        if(reservation.getIdReservation()!=null){
            Optional<Reservation> resultado = reservationRepository.getReservation(reservation.getIdReservation());
            if(resultado.isPresent()){
                if(reservation.getStartDate()!=null){
                    resultado.get().setStartDate(reservation.getStartDate());
                }
                if(reservation.getDevolutionDate()!=null){
                    resultado.get().setDevolutionDate(reservation.getDevolutionDate());
                }
                if(reservation.getStatus()!=null){
                    resultado.get().setStatus(reservation.getStatus());
                }
                reservationRepository.save(resultado.get());
                return resultado.get();
            }else{
                return reservation;
            } 
        }else{
            return reservation;
        }
    }
    /**
     * DELETE
     * @param reservationId
     * @return 
     */
    public boolean deleteReservation(int reservationId) {
        Boolean aBoolean = getReservation(reservationId).map(reservation -> {
        reservationRepository.delete(reservation);
        return true;
        }).orElse(false);
        return aBoolean;
    }
}
