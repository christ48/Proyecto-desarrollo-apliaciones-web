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
import lombok.Data;

/**
 *
 * @author lossa
 */
@Data
@Entity
@Table(name="proveedores")
public class Proveedores {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id_Proveedor")
    private Long id_Proveedor;
    
    @Column(name="Nombre")
    private String Nombre;
    
    @Column(name="Apellido")
    private String Apellido;
    
    @Column(name="Email")
    private String Email;
    
    @Column(name="telefono")
    private String telefono;
    
    public Proveedores(){}
    
    public Proveedores(String Nombre, String Apellido,String Email,String telefono){
        this.Nombre=Nombre;
        this.Apellido=Apellido;
        this.Email=Email;
        this.telefono=telefono;
    }
}
