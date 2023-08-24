/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.Proyecto.ProyectoFinal.DAO;
import com.Proyecto.ProyectoFinal.domain.Usuarios;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author lossa
 */
public interface UsuarioDao extends JpaRepository<Usuarios,Long> {
        Usuarios findByUsername(String username);
       Usuarios findByUsernameAndPassword(String username,String Password);
       Usuarios findByUsernameOrCorreo(String username,String correo);
       boolean existsByUsernameOrCorreo(String username,String correo);
       
       
    
}
