/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.rentamaquinaria.maquinaria.app.services;

import com.rentamaquinaria.maquinaria.app.entities.Admin;
import com.rentamaquinaria.maquinaria.app.repositories.AdminRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Paula Moreno.
 */
@Service
public class AdminService {
    
    @Autowired
    private AdminRepository adminRepository;
    /**
     * GET
     * @return 
     */
    public List<Admin> getAll(){
        return adminRepository.getAll();
    }
    /**
     * Buscar cliente por Id
     * @param adminId
     * @return 
     */
    public Optional<Admin> getAdmin(int adminId){
        return adminRepository.getAdmin(adminId);
    }
    /**
     * POST
     * @param admin
     * @return 
     */
    public Admin saveAdmin(Admin admin){
        if(admin.getIdAdmin()==null){
            return adminRepository.save(admin);
        }else{
            Optional<Admin> resultado = adminRepository.getAdmin(admin.getIdAdmin());
            if(resultado.isPresent()){
                return admin;
            }else{
                return adminRepository.save(admin);
            }
        }
    }
    /**
     * UPDATE
     * @param admin
     * @return 
     */
    public Admin updateAdmin(Admin admin){
        if(admin.getIdAdmin()!=null){
            Optional<Admin> resultado = adminRepository.getAdmin(admin.getIdAdmin());
            if(resultado.isPresent()){
                if(admin.getName()!=null){
                    resultado.get().setName(admin.getName());
                }
                if(admin.getEmail()!=null){
                    resultado.get().setEmail(admin.getEmail());
                }
                if(admin.getPassword()!=null){
                    resultado.get().setPassword(admin.getPassword());
                }
                adminRepository.save(resultado.get());
                return resultado.get();
            }else{
                return admin;
            } 
        }else{
            return admin;
        }
    }
    /**
     * DELETE
     * @param adminId
     * @return 
     */
    public boolean deleteAdmin(int adminId) {
        Boolean aBoolean = getAdmin(adminId).map(admin -> {
        adminRepository.delete(admin);
        return true;
        }).orElse(false);
        return aBoolean;
    }
}