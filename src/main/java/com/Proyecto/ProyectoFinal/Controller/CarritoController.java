/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.Proyecto.ProyectoFinal.Controller;

import com.Proyecto.ProyectoFinal.Service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import com.Proyecto.ProyectoFinal.Service.HerramientaService;
import com.Proyecto.ProyectoFinal.domain.Factura;
import com.Proyecto.ProyectoFinal.domain.Item;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import com.Proyecto.ProyectoFinal.domain.Herramientas;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;


/**
 *
 * @author lossa
 */
@Controller

public class CarritoController {
    @Autowired 
    private ItemService itemSerivce;

    @Autowired
    private HerramientaService herramientasService;
    
    
    @GetMapping("/Iventario")
    public String inventario(Model model){
        var herramientas= herramientasService.getHerramientas();
        model.addAttribute("herramientas",herramientas);
        
       return "/carrito/Inventario";
    
    }
    @GetMapping("/carrito/listado")
    public String listadoCarrito(Model model){
        var items= itemSerivce.gets();
        model.addAttribute("items",items);
        var carriTotalVenta=0;
        for(Item x: items){
            carriTotalVenta+= (x.getCantidad()*x.getPrecio());
            
            
        }
        model.addAttribute("CarritoTotal",carriTotalVenta);
        return"/carrito/listado";
        
        
    }
    
    @GetMapping("/carrito/agregar/{IdHerramienta}")
    public ModelAndView agregarHerramienta(Model model,Item item){
        Item item2= itemSerivce.get(item);
        if (item2==null){
            Herramientas herramientas= herramientasService.getHerramienta(item);
            item2=new Item(herramientas);
            
            
        }
        itemSerivce.saveItem(item2);
        var lista= itemSerivce.gets();
        var totalCarritos=0;
        var carritoTotalVenta=0;
        for(Item x: lista){
            totalCarritos+= x.getCantidad();
            carritoTotalVenta+=(x.getCantidad()*x.getPrecio());
            
        }
        model.addAttribute("listaItems",lista);
        model.addAttribute("listaTotal",totalCarritos);
        model.addAttribute("carritoTotal",carritoTotalVenta);
        return new ModelAndView("/carrito/fragmentos :: verCarrito");
    }
   @GetMapping("/carrito/modificar{IdHerramienta}")
   public String modifacarCarrito(Item item,Model model){
       item= itemSerivce.get(item);
       model.addAttribute("item",item);
       return "/carrito/modificar";
   }

   @GetMapping("/eliminarCarrito/{IdHerramienta}")
   public String eliminarCarrito(Item item){
       itemSerivce.deleteItem(item);
       return "redirect:/carrito/listado";
       
   }
   @GetMapping("/facturar/carrito")
   public String facturarCarrito(Model model,Factura factura){
       model.addAttribute("mensaje", "Factura generada con éxito. ID: " + factura.getId_factura());
       itemSerivce.facturar();
       return"redirect:/";
   }
        
}

