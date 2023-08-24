/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.Proyecto.ProyectoFinal.Service.Impl;

import com.Proyecto.ProyectoFinal.DAO.ComentariosProductosDao;
import com.Proyecto.ProyectoFinal.Service.ComentariosProductosService;
import com.Proyecto.ProyectoFinal.domain.ComentariosProducto;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author lossa
 */
@Service
public class ComentariosProductosServiceImpl implements ComentariosProductosService {
    
@Autowired
private ComentariosProductosDao comentariosProductosDao; 
    
@Transactional(readOnly=true)
@Override
public List<ComentariosProducto> getComentarios(){
    
    return comentariosProductosDao.findAll();
}
@Override
@Transactional(readOnly=true)
public ComentariosProducto  getComentariosProductos(ComentariosProducto comentariosProducto){
    return comentariosProductosDao.findById(comentariosProducto.getIdComenProd()).orElse(null);
    
    
    
}
@Override
@Transactional
public void saveComentarioProducto(ComentariosProducto comentariosProducto){
    comentariosProductosDao.save(comentariosProducto);


}
@Override
@Transactional
public void deleteComentarioProducto(Long idComenProd){
    comentariosProductosDao.deleteById(idComenProd);
}
@Override
@Transactional
public void updateComentarioProducto(ComentariosProducto comentariosProducto){
    comentariosProductosDao.save(comentariosProducto);
}

}