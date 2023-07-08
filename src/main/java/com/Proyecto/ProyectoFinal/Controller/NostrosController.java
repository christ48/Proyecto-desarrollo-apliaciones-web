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
public class NostrosController {
      @GetMapping("/")
    public String inicio() {
        return "index";
    }

    @GetMapping("/Nosotros")
    public String nosotros() {
        return "Nosotros";
    }

    @GetMapping("/productos")
    public String productos() {
        return "productos";
    }

}