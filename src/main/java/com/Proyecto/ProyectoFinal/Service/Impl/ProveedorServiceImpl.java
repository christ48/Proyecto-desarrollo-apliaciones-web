/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.Proyecto.ProyectoFinal.Service.Impl;

import com.Proyecto.ProyectoFinal.DAO.ProveedorDao;
import com.Proyecto.ProyectoFinal.Service.ProveedorService;
import com.Proyecto.ProyectoFinal.domain.Proveedores;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author lossa
 */
@Service
public class ProveedorServiceImpl implements ProveedorService{
    @Autowired
    private ProveedorDao proveedorDao;
    
    @Transactional(readOnly=true)
    @Override
    public List<Proveedores> getProveedores(){
        return proveedorDao.findAll();
    }
    
    @Override
    @Transactional(readOnly=true)
     public Proveedores getProveedor(Proveedores proveedores){
     return proveedorDao.findById(proveedores.getId_Proveedor()).orElse(null);
     
     
     }
     
     @Override
     @Transactional
     public void saveProveedor(Proveedores proveedor){
            proveedorDao.save(proveedor);
     }
     @Override
     @Transactional
     public void deleteProveedor(Long id_Proveedor){
         proveedorDao.deleteById(id_Proveedor);
     }
    @Override
    @Transactional
    public void updateProveedor(Proveedores proveedor){
        proveedorDao.save(proveedor);
    }
}
