/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.Proyecto.ProyectoFinal.domain;

import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 *
 * @author lossa
 */
@Data
@EqualsAndHashCode(callSuper=false)
public class Item extends Herramientas {
    private int cantidad;
    public Item(){}
    
    public Item(Herramientas herramientas){
        super.setIdHerramienta((herramientas.getIdHerramienta()));
        
        super.setDescripcion(herramientas.getDescripcion());
        
        super.setMarcar(herramientas.getMarcar());
        
        super.setPrecio(herramientas.getPrecio());
        
        super.setUnidades(herramientas.getUnidades());
        
        super.setNombre(herramientas.getNombre());
        this.cantidad=0;
        
        
    }
    
}
