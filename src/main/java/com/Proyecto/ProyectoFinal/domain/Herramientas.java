/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.Proyecto.ProyectoFinal.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import java.io.Serializable;
import lombok.Data;

/**
 *
 * @author lossa
 */
@Data
@Entity
@Table(name = "Herramientas")
public class Herramientas implements Serializable {
     private static final long serialVersionUID = 1L;
     
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Id_Herramienta")
     private long IdHerramienta;
    
    @Column(name="Nombre")
    private String Nombre;
    
    @Column(name="Precio")
    private float Precio;
    
    @Column(name="Unidades")
    private int Unidades;
    
    @Column(name="Descripcion")
    private String Descripcion;
    
    @Column(name="Marcar")
    private String Marcar;
    public Herramientas(){}
    
    public Herramientas(String Nombre, float Precio,int Unidades,String Descripcion,String Marcar){
        this.Nombre=Nombre;
        this.Precio=Precio;
        this.Unidades=Unidades;
        this.Descripcion=Descripcion;
        this.Marcar=Marcar;
    }
    
            
    
}
