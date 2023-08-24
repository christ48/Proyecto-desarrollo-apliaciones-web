/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.Proyecto.ProyectoFinal.Controller;

import com.Proyecto.ProyectoFinal.Service.ProveedorService;
import com.Proyecto.ProyectoFinal.domain.Proveedores;
import java.util.List;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
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
public class ProveedorController {
    @Autowired
    private ProveedorService proveedorService;
    
   @GetMapping("/ListaProveedores")
   public String mostrarProveedores(Model model){
       List<Proveedores> proveedores=proveedorService.getProveedores();
       model.addAttribute("proveedores", proveedores);
       model.addAttribute("totalProveedor", proveedores.size());
       return("/Proveedores/listaP");
   }
   @PostMapping("/Proveedores/nuevoProveedor")
   public String ProveedorNuevo(@ModelAttribute Proveedores proveedores){
      proveedorService.saveProveedor(proveedores);
      return"redirect:/ListaProveedores";
   }
@GetMapping("/ProveedoresEliminar/{id_Proveedor}")
public String EliminarProveedor(@PathVariable("id_Proveedor") Long id_Proveedor) {
    proveedorService.deleteProveedor(id_Proveedor);
    return "redirect:/ListaProveedores"; // Cambio aquí
}

   @PostMapping("/ActualizarProveedor")
   public String ActualizarProveedor(Proveedores proveedores,Model model){
       proveedorService.saveProveedor(proveedores);
       return"redirect:/ListaProveedores";
   }
   @GetMapping("/ModificarProveedor/{id_Proveedor}")
   public String ModificarProveedor(@PathVariable("id_Proveedor")Proveedores proveedores,Model model){
       Proveedores proveedore=proveedorService.getProveedor(proveedores);
       model.addAttribute("proveedor", proveedore);
       return "Proveedores/ActualizarProveedor";
   }
   


}
