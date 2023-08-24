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
import java.util.Date;
import lombok.Data;

/**
 *
 * @author lossa
 */
@Data
@Entity
@Table(name="empleados")
public class Empleados {
  @Id
  @GeneratedValue(strategy= GenerationType.IDENTITY)
  @Column(name= "id_Empleado")
  private long id_Empleado;
  
  @Column(name="Nombre")
  private String Nombre;
  
  @Column(name="Apellido")
  private String Apellido;
  
  @Column(name="Email")
  private String Email;
  
  @Column(name="Telefono")
  private String Telefono;
  
  @Column(name="Salario")
  private float Salario;
  
  
  
  public Empleados(){}
  
  public Empleados(String Nombre,String Apellido,String Email, String Telefono, float Salario){
  
      this.Nombre=Nombre;
      this.Apellido=Apellido;
      this.Email=Email;
      this.Telefono=Telefono;
      this.Salario=Salario;
  }
  
}
