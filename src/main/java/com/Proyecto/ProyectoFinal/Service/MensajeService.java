/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.Proyecto.ProyectoFinal.Service;
import com.Proyecto.ProyectoFinal.domain.Mensaje;
import java.util.List;
/**
 *
 * @author lossa
 */
public interface MensajeService {
    List<Mensaje> getMensajes();
    
    Mensaje getMensaje(Mensaje mensaje);
    
    void saveMensaje(Mensaje mensaje);
    
    void deleteMensaje(Long Id_Mensaje);
    
    void updatMensaje(Mensaje mensaje);
    
}
