/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.Proyecto.ProyectoFinal.Service;

import com.Proyecto.ProyectoFinal.domain.Empleados;
import java.util.List;

/**
 *
 * @author lossa
 */
public interface EmpleadoService {
    public List<Empleados> getEmpleados();
   
    public Empleados getEmpleado(Empleados empleado);
    
     void saveEmpleado(Empleados empleado);
     
     void DeleteEmpleado(Long id_Empleado);
     
     void updateEmpleado(Empleados empleado);
     
     
    
}
