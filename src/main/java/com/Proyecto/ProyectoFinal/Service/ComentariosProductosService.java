/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.Proyecto.ProyectoFinal.Service;

import com.Proyecto.ProyectoFinal.domain.ComentariosProducto;
import java.util.List;

/**
 *
 * @author lossa
 */
public interface ComentariosProductosService {
    public List<ComentariosProducto> getComentarios();
    
    public ComentariosProducto  getComentariosProductos(ComentariosProducto comentariosProducto);
    
    void saveComentarioProducto(ComentariosProducto comentariosProducto);
    
    void deleteComentarioProducto(Long idComenProd);
    
    void updateComentarioProducto(ComentariosProducto comentariosProducto);
    
    
}


