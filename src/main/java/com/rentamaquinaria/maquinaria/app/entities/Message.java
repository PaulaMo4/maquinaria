
package com.rentamaquinaria.maquinaria.app.entities;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 *
 * @author gemoreno
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="message")
public class Message implements Serializable {
    @Id
    @GeneratedValue
    private Integer idMessage;
    private String messageText;
    @ManyToOne
    @JoinColumn(name = "id")
    @JsonIgnoreProperties({"messages","reservations"})
    private Machine machine;
    
    @ManyToOne
    @JoinColumn(name = "clientId")
    @JsonIgnoreProperties({"messages","reservations"})
    private Client client;
}
