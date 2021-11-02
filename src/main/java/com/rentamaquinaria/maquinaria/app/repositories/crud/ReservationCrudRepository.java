
package com.rentamaquinaria.maquinaria.app.repositories.crud;

import com.rentamaquinaria.maquinaria.app.entities.Reservation;
import org.springframework.data.repository.CrudRepository;

/**
 *
 * @author gemoreno
 */
public interface ReservationCrudRepository extends CrudRepository<Reservation,Integer> {
    
}
