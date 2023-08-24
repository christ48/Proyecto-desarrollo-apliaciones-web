/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.Proyecto.ProyectoFinal.Controller;

import com.Proyecto.ProyectoFinal.Service.EmpleadoService;
import com.Proyecto.ProyectoFinal.domain.Empleados;
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
public class EmpleadoController {
    @Autowired
    private EmpleadoService empledoService;
    
    @GetMapping("/MostrarEmpleados")
    public String mostarEmpleados(Model model){
        List<Empleados> empleados=empledoService.getEmpleados();
        model.addAttribute("empleado",empleados);
        model.addAttribute("TotalEmpleados", empleados.size());
        return"Empleado/ListaEmpleados";
    }
   @PostMapping("/EmpleadoNuevo")
public String GuardarNuevo(@ModelAttribute Empleados empleado){
    empledoService.saveEmpleado(empleado);
    return "redirect:/MostrarEmpleados";
}

    
    @PostMapping("/EmpleadoGuardar")
    public String GuardarEmpleado(@ModelAttribute Empleados empleado){
        empledoService.saveEmpleado(empleado);
        return"redirect:/MostrarEmpleados";
        
    }
    @GetMapping("/EliminarEmpleado/{id_Empleado}")
    public String EliminarEmpleado(@PathVariable("id_Empleado")Long id_Empleado){
        empledoService.DeleteEmpleado(id_Empleado);
        return"redirect:/MostrarEmpleados";
        
    }
    
    @PostMapping("/ActualizarEmpleado")
    public String ActualizarEmpleado(Empleados empleado,Model model){
        empledoService.saveEmpleado(empleado);
        return"redirect:/MostrarEmpleados";
    }
  @GetMapping("/ModificarEmpleado/{id_Empleado}")
public String ModificarEmpleado(@PathVariable("id_Empleado") Empleados empleados, Model model) {
    Empleados empleado = empledoService.getEmpleado(empleados);
    model.addAttribute("empleado", empleado);
    return "Empleado/ActualizarEmpleado";
}

    
    
    
}
