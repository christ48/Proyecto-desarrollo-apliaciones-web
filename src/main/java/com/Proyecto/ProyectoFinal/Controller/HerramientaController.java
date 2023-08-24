/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.Proyecto.ProyectoFinal.Controller;

import com.Proyecto.ProyectoFinal.Service.ComentariosProductosService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import com.Proyecto.ProyectoFinal.domain.Herramientas;
import com.Proyecto.ProyectoFinal.Service.HerramientaService;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 *
 * @author lossa
 */
@Controller
@Slf4j
public class HerramientaController {

    @Autowired
    private HerramientaService herramientaService;
    @Autowired
    private ComentariosProductosService comentarioPservice;

   @GetMapping("/mostrarProductos")
    public String mostrarProductos(@RequestParam(name = "vista", required = false, defaultValue = "Herramientas") String vista, Model model) {
    List<Herramientas> herramientas = herramientaService.getHerramientas();
    model.addAttribute("herramientas", herramientas);
    model.addAttribute("totalProductos", herramientas.size());
    if ("ProductosHerramientas".equals(vista)) {
        return "Herramientas/ProductosHerramientas";
    } else {
        return "Herramientas/Herramientas";
    }
}


   @PostMapping("/Herramientas/guardar")
    public String HerramientaGuardar(@ModelAttribute Herramientas herramienta) {
    herramientaService.saveHerramienta(herramienta);
     return "redirect:/mostrarProductos?vista=Herramientas/Herramientas";
}


@PostMapping("/Herramientas/nuevo")
public String herramientaGuardar(@ModelAttribute Herramientas herramienta){
    herramientaService.saveHerramienta(herramienta);
    return "redirect:/mostrarProductos?vista=Herramientas";
}

    @GetMapping("/Herramientaeliminar/{IdHerramienta}")
    public String HerramientaEliminar(@PathVariable("IdHerramienta") Long IdHerramienta) {
        herramientaService.deleteHerramienta(IdHerramienta);
        return "redirect:/mostrarProductos?vista=Herramientas/Herramientas";
    }

    @GetMapping("/ActualizarHerramienta/{IdHerramienta}")
    public String HerramientaActualizar(@PathVariable("IdHerramienta")Herramientas herramientas, Model model) {
        Herramientas herramienta = herramientaService.getHerramienta(herramientas);
        model.addAttribute("herramienta", herramienta);
        return "Herramientas/ActualizarHerramienta";
    }
    
@GetMapping("/ProductoSeleccionado/{IdHerramienta}")
public String ProductoSeleccionado(@PathVariable("IdHerramienta") Herramientas herramientas, Model model) {
    Herramientas herramienta = herramientaService.getHerramienta(herramientas);
    model.addAttribute("herramienta", herramienta);
    return "Herramientas/ProductoSeleccionado";
}

@GetMapping("/listadoHerramientas")
public String ListadoHerramient(Model model){
    var herramientas =herramientaService.getHerramientas();
    model.addAttribute("Herramientas",herramientas);
    return "Herramientas/listado";
}


    
}

