/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.Proyecto.ProyectoFinal.Service.Impl;

import com.Proyecto.ProyectoFinal.DAO.EmpleadoDao;
import com.Proyecto.ProyectoFinal.Service.EmpleadoService;
import com.Proyecto.ProyectoFinal.domain.Empleados;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author lossa
 */
@Service
public class EmpleadoServiceImpl implements EmpleadoService {
    @Autowired
    private EmpleadoDao empleadoDao;
    
    @Transactional(readOnly=true)
    @Override
    public  List<Empleados> getEmpleados(){
    return empleadoDao.findAll();
    }
    @Override
    @Transactional(readOnly=true)
    public Empleados getEmpleado(Empleados empleados){
        return empleadoDao.findById(empleados.getId_Empleado()).orElse(null);
        
    }
    @Override
    @Transactional
    public void saveEmpleado(Empleados empleado){
        empleadoDao.save(empleado);
    }
    @Override
    @Transactional
    public void DeleteEmpleado(Long id_Empleado){
        empleadoDao.deleteById(id_Empleado);
    }
    
    @Override
    @Transactional
    public void updateEmpleado(Empleados empleado){
        empleadoDao.save(empleado);
    }
}
