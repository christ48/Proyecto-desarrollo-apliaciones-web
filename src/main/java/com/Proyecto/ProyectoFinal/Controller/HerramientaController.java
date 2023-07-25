/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.Proyecto.ProyectoFinal.Controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import com.Proyecto.ProyectoFinal.domain.Herramientas;
import com.Proyecto.ProyectoFinal.Service.HerramientaService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;


/**
 *
 * @author lossa
 */
@Controller
@Slf4j
public class HerramientaController {

    @Autowired
    private HerramientaService herramientaService;

    @GetMapping("/Herramientas")
    public String mostrarProductos(Model model) {
        List<Herramientas> herramientas = herramientaService.getHerramientas();
        model.addAttribute("herramientas", herramientas);
        model.addAttribute("totalProductos",herramientas.size());
        return "Herramientas";
    }

    @PostMapping("Herramientas/guardar")
    public String HerramientaGuardar(Herramientas herramienta) {
        herramientaService.saveHerramienta(herramienta);
        return "redirect:/Herramientas";
    }

    @PostMapping("/guardar")
    public String HerramientaActualizar(Herramientas herramienta) {
        herramientaService.saveHerramienta(herramienta);
        return "redirect:/Herramientas";
    }

    @GetMapping("/eliminar/{IdHerramienta}")
    public String HerramientaEliminar(@PathVariable("IdHerramienta") Long IdHerramienta) {
        herramientaService.deleteHerramienta(IdHerramienta);
        return "redirect:/Herramientas"; 
    }

    @GetMapping("/ActualizarHerramienta/{IdHerramienta}")
    public String HerramientaActualizar(@PathVariable("IdHerramienta") Long IdHerramienta, Model model) {
        Herramientas herramienta = herramientaService.getHerramienta(IdHerramienta);
        model.addAttribute("herramienta", herramienta);
        return "ActualizarHerramienta";
    }
}

