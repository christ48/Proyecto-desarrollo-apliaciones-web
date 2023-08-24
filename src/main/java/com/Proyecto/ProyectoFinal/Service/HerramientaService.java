/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.Proyecto.ProyectoFinal.Service;

/**
 *
 * @author lossa
 */
import com.Proyecto.ProyectoFinal.domain.Herramientas;
import java.util.List;
public interface HerramientaService {
    public List<Herramientas> getHerramientas();
    
    public Herramientas getHerramienta(Herramientas herramientas);
    
    void saveHerramienta(Herramientas herramienta);
    
    void deleteHerramienta(Long IdHerramienta);
    
    void updateHerramienta(Herramientas herramienta);
    
    public Herramientas getHerramientaById(Long idHerramienta);
    
   

}
