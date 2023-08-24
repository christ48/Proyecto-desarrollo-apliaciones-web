/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.Proyecto.ProyectoFinal.Service.Impl;
import com.Proyecto.ProyectoFinal.DAO.RolDao;
import com.Proyecto.ProyectoFinal.DAO.UsuarioDao;
import com.Proyecto.ProyectoFinal.domain.Usuarios;
import com.Proyecto.ProyectoFinal.Service.UsuarioService;
import com.Proyecto.ProyectoFinal.domain.Rol;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

        
/**
 *
 * @author lossa
 */
@Service
public class UsuarioServiceImpl implements UsuarioService {
    
    @Autowired
    private UsuarioDao usuarioDao;
    
    @Autowired
    private RolDao rolDao;
    
    @Override
    @Transactional(readOnly=true)
    public List<Usuarios> getUsuarios(){
        return usuarioDao.findAll();
    }
   
@Override
@Transactional(readOnly = true)
public Usuarios getUsuario(Usuarios usuario) {
    return usuarioDao.findById(usuario.getId_usuario()).orElse(null);
}

@Override
@Transactional(readOnly = true)
public Usuarios getUsuarioPorUsername(String username) {
    return usuarioDao.findByUsername(username);
}

@Override
@Transactional(readOnly = true)
public Usuarios getUsuarioPorUsernameYPassword(String username, String password) {
    return usuarioDao.findByUsernameAndPassword(username, password);
}

@Override
@Transactional(readOnly = true)
public Usuarios getUsuarioPorUsernameOCorreo(String username, String correo) {
    return usuarioDao.findByUsernameOrCorreo(username, correo);
}

@Override
@Transactional(readOnly = true)
public boolean existeUsuarioPorUsernameOCorreo(String username, String correo) {
    return usuarioDao.existsByUsernameOrCorreo(username, correo);
}


@Override
@Transactional
public void save(Usuarios usuario, boolean crearRolUser){
    usuario=usuarioDao.save(usuario);
    if(crearRolUser){
        Rol rol=new Rol();
        rol.setNombre("ROLE_USER");
        rol.setIdUsuario(usuario.getId_usuario());
        rolDao.save(rol);
        
    }
}
@Override
@Transactional
public void delete(Usuarios usuario){
    usuarioDao.delete(usuario);
}
}