/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.Proyecto.ProyectoFinal.Service.Impl;

/**
 *
 * @author lossa
 */
import com.Proyecto.ProyectoFinal.domain.Herramientas;
import com.Proyecto.ProyectoFinal.DAO.HerramientasDao;
import com.Proyecto.ProyectoFinal.Service.HerramientaService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class HerramientasServiceImpl implements HerramientaService{
     
       @Autowired
       private HerramientasDao herramientasDao;
       
       @Transactional(readOnly = true)
       @Override
       public List<Herramientas>getHerramientas(){
           return herramientasDao.findAll();
       }
       
       
       @Override
       @Transactional(readOnly = true)
       public Herramientas getHerramienta(Long IdHerramienta){
          return herramientasDao.findById(IdHerramienta).orElse(null);
       
       }
       @Override
       @Transactional
       public void saveHerramienta (Herramientas herramienta){
           herramientasDao.save(herramienta);
       
       }
        @Override
       @Transactional
        public void deleteHerramienta(Long IdHerramienta){
            herramientasDao.deleteById(IdHerramienta);
        }
       @Override
       @Transactional
       public void updateHerramienta(Herramientas herramienta){
           herramientasDao.save(herramienta);
       }
               
       
    
}
