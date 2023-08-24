/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.Proyecto.ProyectoFinal.Service.Impl;
import com.Proyecto.ProyectoFinal.domain.Mensaje;
import com.Proyecto.ProyectoFinal.DAO.MensajeDao;
import com.Proyecto.ProyectoFinal.Service.MensajeService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author lossa
 */
@Service
public class MensajeServiceImpl implements MensajeService {
    
     @Autowired
     private MensajeDao mensajeDao;
     
     @Transactional(readOnly = true)
     @Override
     public List<Mensaje>getMensajes(){
         return mensajeDao.findAll();
     }
    @Override
    @Transactional(readOnly = true)
    public Mensaje getMensaje(Mensaje mensaje){
        return mensajeDao.findById(mensaje.getId_Mensaje()).orElse(null);
    }
        @Override
        @Transactional
        public void saveMensaje(Mensaje mensaje){
            mensajeDao.save(mensaje);
    }
     @Override
     @Transactional
     public void deleteMensaje(Long Id_Mensaje){
         mensajeDao.deleteById(Id_Mensaje);
     
     }
     @Override
     @Transactional
     public void updatMensaje(Mensaje mensaje){
         mensajeDao.save(mensaje);
     }
   
   }



