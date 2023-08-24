/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.Proyecto.ProyectoFinal.Controller;
import com.Proyecto.ProyectoFinal.domain.Usuarios;
import com.Proyecto.ProyectoFinal.Service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
/**
 *
 * @author lossa
 */
@Controller 
@RequestMapping("/usuario")
public class UsuarioController {
    @Autowired
    private UsuarioService usuarioService;

    @GetMapping("/listado")
    public String inicio(Model model){
        var usuarios= usuarioService.getUsuarios();
        model.addAttribute("usuarios",usuarios);
        model.addAttribute("totalUsuarios",usuarios.size());
        return "/usuario/listado";
    }
    @GetMapping("/UsuarioNuevo")
    public String usuarioNuevo(Usuarios usuario){
        return "/usuario/modifica";
    }
    @PostMapping("/GuardarUsuario")
    public String usuarioGuardar(Usuarios usuario){
    var codigo=new BCryptPasswordEncoder();
    usuario.setPassword(codigo.encode(usuario.getPassword()));
    usuarioService.save(usuario, true);
    return "Redirect:/";
    }
    @GetMapping("/eliminarUsuario/{id_usuario}")
    public String usuarioEliminar(Usuarios usuario){
        usuarioService.delete(usuario);
        return "redirect:/usuario/listado";
        
    }
    @GetMapping("/modificarUsuario/{id_usuario}")
    public String usuarioModificar(Usuarios usuario,Model model){
        usuario = usuarioService.getUsuario(usuario);
        model.addAttribute("usuario",usuario);
        return"/usuario/modifica";
    }
}