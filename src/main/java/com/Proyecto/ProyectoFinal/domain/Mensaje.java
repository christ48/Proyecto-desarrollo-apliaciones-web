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
@Table(name = "Mensajes")
public class Mensaje implements Serializable{
     private static final long serialVersionUID = 1L;
     
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Id_Mensaje")
    private long Id_Mensaje;
    
     @Column(name="Nombre",length = 50)
     private String Nombre;
     
      @Column(name="Mensaje",length = 150)
      private String Mensaje;
      
      public Mensaje(){
      }
     
     public Mensaje(String Nombre,String Mensaje){
         this.Nombre=Nombre;
         this.Mensaje=Mensaje;
     
     }

    
    
}
