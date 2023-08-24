/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.Proyecto.ProyectoFinal.Service;

import com.Proyecto.ProyectoFinal.domain.Proveedores;
import java.util.List;

/**
 *
 * @author lossa
 */
public interface ProveedorService {
    public List<Proveedores> getProveedores();
    
    public Proveedores getProveedor(Proveedores proveedores);
    
    void saveProveedor(Proveedores proveedor);
    
    void deleteProveedor(Long id_Proveedor);
    
    void updateProveedor(Proveedores proveedor);
    
    

    
    
}
