/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.Proyecto.ProyectoFinal.Controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import com.Proyecto.ProyectoFinal.domain.Herramientas;
import com.Proyecto.ProyectoFinal.Service.HerramientaService;
import com.Proyecto.ProyectoFinal.Service.Impl.FirebaseStorageServiceImpl;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;


/**
 *
 * @author lossa
 */
@Controller
@Slf4j
public class HerramientaController {

    @Autowired
    private HerramientaService herramientaService;

   @GetMapping("/mostrarProductos")
    public String mostrarProductos(@RequestParam(name = "vista", required = false, defaultValue = "Herramientas") String vista, Model model) {
    List<Herramientas> herramientas = herramientaService.getHerramientas();
    model.addAttribute("herramientas", herramientas);
    
    if ("ProductosHerramientas".equals(vista)) {
        return "ProductosHerramientas";
    } else {
        model.addAttribute("totalProductos", herramientas.size());
        return "Herramientas";
    }
}


   @PostMapping("/Herramientas/guardar")
    public String HerramientaGuardar(@ModelAttribute Herramientas herramienta) {
    herramientaService.saveHerramienta(herramienta);
     return "redirect:/mostrarProductos?vista=Herramientas";
}

    @Autowired
    private FirebaseStorageServiceImpl firebaseStorageService;
@PostMapping("/guardar")
public String herramientaGuardar(Herramientas herramienta,
                                 @RequestParam("imagenFile") MultipartFile imagenFile) {
    if (!imagenFile.isEmpty()) {
        herramientaService.saveHerramienta(herramienta);
         String rutaImagen = firebaseStorageService.cargaImagen(
                imagenFile,
                "herramienta",
                herramienta.getIdHerramienta());

        herramienta.setRuta_Imagen(rutaImagen);

        herramientaService.saveHerramienta(herramienta);
    } else {
        herramientaService.saveHerramienta(herramienta);
    }

    return "redirect:/Herramientas";
}


    @GetMapping("/eliminar/{IdHerramienta}")
    public String HerramientaEliminar(@PathVariable("IdHerramienta") Long IdHerramienta) {
        herramientaService.deleteHerramienta(IdHerramienta);
        return "redirect:/mostrarProductos?vista=Herramientas";
    }

    @GetMapping("/ActualizarHerramienta/{IdHerramienta}")
    public String HerramientaActualizar(@PathVariable("IdHerramienta") Long IdHerramienta, Model model) {
        Herramientas herramienta = herramientaService.getHerramienta(IdHerramienta);
        model.addAttribute("herramienta", herramienta);
        return "ActualizarHerramienta";
    }
    
    @GetMapping("/ProductoSeleccionado/{IdHerramienta}")
    public String ProductoSeleccionado(@PathVariable("IdHerramienta") Long IdHerramienta, Model model) {
        Herramientas herramienta = herramientaService.getHerramienta(IdHerramienta);
        model.addAttribute("herramienta", herramienta);
        return "ProductoSeleccionado";
    }
    
}

