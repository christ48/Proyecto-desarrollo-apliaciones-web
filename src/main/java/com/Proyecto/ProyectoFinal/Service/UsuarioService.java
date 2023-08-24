/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.Proyecto.ProyectoFinal.Service;
import com.Proyecto.ProyectoFinal.domain.Usuarios;
import java.util.List;
/**
 *
 * @author lossa
 */
public interface UsuarioService {
    // Se obtiene un listado de usuarios en un List
    public List<Usuarios> getUsuarios();
    
    // Se obtiene un Usuario, a partir del id de un usuario
    public Usuarios getUsuario(Usuarios usuario);
    
    // Se obtiene un Usuario, a partir del username de un usuario
    public Usuarios getUsuarioPorUsername(String username);

    // Se obtiene un Usuario, a partir del username y el password de un usuario
    public Usuarios getUsuarioPorUsernameYPassword(String username, String password);
    
    // Se obtiene un Usuario, a partir del username y el password de un usuario
    public Usuarios getUsuarioPorUsernameOCorreo(String username, String correo);
    
    // Se valida si existe un Usuario considerando el username
    public boolean existeUsuarioPorUsernameOCorreo(String username, String correo);
    
    // Se inserta un nuevo usuario si el id del usuario esta vacío
    // Se actualiza un usuario si el id del usuario NO esta vacío
    public void save(Usuarios usuario,boolean crearRolUser);
    
    // Se elimina el usuario que tiene el id pasado por parámetro
    public void delete(Usuarios usuario);
    
    
}
