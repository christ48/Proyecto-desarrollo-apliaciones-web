/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.Proyecto.ProyectoFinal.Controller;

import com.Proyecto.ProyectoFinal.domain.Usuarios;
import com.Proyecto.ProyectoFinal.Service.RegistroService;
import jakarta.mail.MessagingException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;



@Controller
@Slf4j
@RequestMapping("/registro")
public class RegistroController {

    @Autowired
    private RegistroService registroService;

    @GetMapping("/nuevo")
    public String nuevo(Model model, Usuarios usuario) {
        model.addAttribute("usuario", usuario);
        return "/registro/nuevo";
    }

    @GetMapping("/recordar")
    public String recordar(Model model, Usuarios usuario) {
        return "/registro/recordar";
    }

    @PostMapping("/crearUsuario")
    public String crearUsuario(Model model, Usuarios usuario) 
            throws MessagingException {
         model = registroService.crearUsuario(model, usuario);
        return "/registro/salida";
    }

    @GetMapping("/activacion/{usuario}/{id}")
    public String activar(
            Model model, 
            @PathVariable(value = "usuario") String usuario, 
            @PathVariable(value = "id") String id) {
        model = registroService.activar(model, usuario, id);
        if (model.containsAttribute("usuario")) {
            return "/registro/activa";
        } else {
            return "/registro/salida";
        }
    }

    @PostMapping("/activar")
    public String activar(
            Usuarios usuario 
            ){
        registroService.activar(usuario);
        return "redirect:/";
    }

    @PostMapping("/recordarUsuario")
    public String recordarUsuario(Model model, Usuarios usuario) 
            throws MessagingException {
        model = registroService.recordarUsuario(model, usuario);
        return "/registro/salida";
    }
}