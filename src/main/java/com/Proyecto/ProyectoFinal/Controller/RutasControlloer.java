/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.Proyecto.ProyectoFinal.Controller;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;


@Controller
@Slf4j
public class RutasControlloer {
      @GetMapping("/")
    public String inicio() {
        return "index";
    }


    @GetMapping("/productos")
    public String productos() {
        return "productos";
    }
    
    @GetMapping("/Maquinaria")
    public String Maquinaria() {
        return "Maquinaria";
    }

    @GetMapping("/carrito")
    public String carrito() {
        return "carrito";
    }
     @GetMapping("/Productos/prueba")
     public String prueba(){
         return"prueba";
     }
    
}