/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.Proyecto.ProyectoFinal.DAO;

import com.Proyecto.ProyectoFinal.domain.Empleados;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author lossa
 */
public interface EmpleadoDao extends JpaRepository <Empleados,Long> {
    
}
