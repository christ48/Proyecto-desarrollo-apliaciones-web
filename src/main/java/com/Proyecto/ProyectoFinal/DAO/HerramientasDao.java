/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.Proyecto.ProyectoFinal.DAO;

import org.springframework.data.jpa.repository.JpaRepository;
import com.Proyecto.ProyectoFinal.domain.Herramientas;
import java.util.List;
/**
 *
 * @author lossa
 */
public interface HerramientasDao extends JpaRepository<Herramientas, Long> {
  
}

