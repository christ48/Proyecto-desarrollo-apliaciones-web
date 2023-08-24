/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.Proyecto.ProyectoFinal.Service;

/**
 *
 * @author lossa
 */

import com.Proyecto.ProyectoFinal.domain.Usuarios;
import jakarta.mail.MessagingException;
import org.springframework.ui.Model;


public interface RegistroService {

    public Model activar(Model model, String usuario, String clave);

    public Model crearUsuario(Model model, Usuarios usuario) throws MessagingException;
    
    public void activar(Usuarios usuario);
    
    public Model recordarUsuario(Model model, Usuarios usuario) throws MessagingException;
}