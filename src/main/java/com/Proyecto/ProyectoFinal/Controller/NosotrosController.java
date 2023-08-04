/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.Proyecto.ProyectoFinal.Controller;
import com.Proyecto.ProyectoFinal.domain.Mensaje;
import org.springframework.stereotype.Controller;
import com.Proyecto.ProyectoFinal.Service.MensajeService;
import java.util.List;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
/**
 *
 * @author lossa
 */
@Controller
@Slf4j
public class NosotrosController {
    @Autowired
    private MensajeService mensajeService;
     
     @GetMapping("/Nosotros")
     public String MostrarMensaje(Model model){
     List <Mensaje> mensaje=mensajeService.getMensajes();
     model.addAttribute("mensaje",mensaje);
     model.addAttribute("Total Mensajes",mensaje.size());
     return "/Nosotros";
     
     }
     @PostMapping("/Nosotros/guardar")
     public String MensajeGuardar(Mensaje mensaje){
         mensajeService.saveMensaje(mensaje);
         return "redirect:/Nosotros";
     
     }
    
     @GetMapping("/mensajeEliminar/{Id_Mensaje}")
     public String MensajeEliminar(@PathVariable("Id_Mensaje") Long Id_Mensaje, Model model){
         mensajeService.deleteMensaje(Id_Mensaje);
         return"redirect:/Nosotros";
     
     }



}
