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
import java.util.Calendar;
import java.util.Date;
import lombok.Data;

/**
 *
 * @author lossa
 */
@Data
@Entity
@Table(name="factura")
public class Factura implements Serializable {
  @Id
  @GeneratedValue(strategy= GenerationType.IDENTITY)
  @Column(name= "id_factura")
  private long id_factura;
  
  @Column(name="fecha")
  private Date fecha;
  
  @Column(name="nombre_cliente")
  private String nombre_cliente;
  
  @Column(name="apellido_cliente")
  private String apellido_cliente;
  
  @Column(name="total")
  private double total;
   
  @Column(name="estado")
  private int  estado;
  
  public Factura(){}
  
  public Factura(String nombre_cliente,String apellido_cliente){
      this.nombre_cliente=nombre_cliente;
      this.apellido_cliente=apellido_cliente;
      this.fecha=Calendar.getInstance().getTime();
      this.estado=1;
  }
}
