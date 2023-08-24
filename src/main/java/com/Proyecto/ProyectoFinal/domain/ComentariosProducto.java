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
@Table(name="ComentarioProducto")
public class ComentariosProducto {
  @Id
  @GeneratedValue(strategy= GenerationType.IDENTITY)
  @Column(name= "idComenProd")
  private long idComenProd;
  
  @Column(name="NombreComentario")
    private String NombreComentario;
  
  @Column(name="comentarioProduco")
  private String comentarioProduco;
  
  @Column(name="id_herramienta")
  private long id_herramienta;
  
  public ComentariosProducto(){}
  
  public ComentariosProducto(String NombreComentario,String comentarioProduco, long id_herramienta){
  this.NombreComentario=NombreComentario;
  this.comentarioProduco=comentarioProduco;
  this.id_herramienta=id_herramienta;
  
  }
}
