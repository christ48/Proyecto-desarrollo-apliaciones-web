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
@Table(name="venta")
public class Venta implements Serializable{
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name="id_venta")
    private Long id_venta;
    
    @Column(name="id_factura")
    private Long id_factura;
    
    @Column(name="id_herramienta")
    private Long id_herramienta;
    
    @Column(name="precio")
    private double precio;
    
    @Column(name="cantidad")
    private int cantidad;
    public Venta(){}
    public Venta(Long id_factura,Long id_herramienta,double precio,int cantidad){
        this.id_factura=id_factura;
        this.id_herramienta=id_herramienta;
        this.precio=precio;
        this.cantidad=cantidad;
    }
}
