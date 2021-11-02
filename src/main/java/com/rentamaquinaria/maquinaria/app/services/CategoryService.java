/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.rentamaquinaria.maquinaria.app.services;

import com.rentamaquinaria.maquinaria.app.entities.Category;
import com.rentamaquinaria.maquinaria.app.repositories.CategoryRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author gemoreno
 */
@Service
public class CategoryService {
    
    @Autowired
    private CategoryRepository categoryRepository;
    /**
     * GET
     * @return 
     */
    public List<Category> getAll(){
        return categoryRepository.getAll();
    }
    /**
     * Buscar categoria por Id
     * @param categoryId
     * @return 
     */
    public Optional<Category> getCategory(int categoryId){
        return categoryRepository.getCategory(categoryId);
    }
    /**
     * POST
     * @param category
     * @return 
     */
    public Category saveCategory(Category category){
        if(category.getId()==null){
            return categoryRepository.save(category);
        }else{
            Optional<Category> resultado = categoryRepository.getCategory(category.getId());
            if(resultado.isPresent()){
                return category;
            }else{
                return categoryRepository.save(category);
            }
        }
    }
    /**
     * UPDATE
     * @param category
     * @return 
     */
    public Category updateCategory(Category category){
        if(category.getId()!=null){
            Optional<Category> resultado = categoryRepository.getCategory(category.getId());
            if(resultado.isPresent()){
                if(category.getName()!=null){
                    resultado.get().setName(category.getName());
                }
                if(category.getDescription()!=null){
                    resultado.get().setDescription(category.getDescription());
                }
                categoryRepository.save(resultado.get());
                return resultado.get();
            }else{
                return category;
            } 
        }else{
            return category;
        }
    }
    /**
     * DELETE
     * @param categoryId
     * @return 
     */
    public boolean deleteCategory(int categoryId) {
        Boolean aBoolean = getCategory(categoryId).map(category -> {
        categoryRepository.delete(category);
        return true;
        }).orElse(false);
        return aBoolean;
    }
}
