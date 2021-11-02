
package com.rentamaquinaria.maquinaria.app.controllers;

import com.rentamaquinaria.maquinaria.app.entities.Admin;
import com.rentamaquinaria.maquinaria.app.services.AdminService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
@RequestMapping("Admin")
public class AdminController {
    
    @Autowired
    private AdminService service;
    /**
     * GET
     * @return 
     */
    @GetMapping("/all")
    public List<Admin> getAdmins(){
        return service.getAll();
    }
    /**
     * POST
     * @param admin
     * @return 
     */
    @PostMapping("/save")
    @ResponseStatus(HttpStatus.CREATED)
    public Admin saveAdmin(@RequestBody Admin admin){
        return service.saveAdmin(admin);
    }
    /**
     * PUT
     * @param admin
     * @return 
     */
    @PutMapping("/update")
    @ResponseStatus(HttpStatus.CREATED)
    public Admin updateAdmin(@RequestBody Admin admin){
        return service.updateAdmin(admin);
    }
    /**
     * DELETE
     * @param adminId
     * @return 
     */
    @DeleteMapping("/{id}")
    public boolean delete(@PathVariable("id") int adminId) {
        return service.deleteAdmin(adminId);
    }
}
