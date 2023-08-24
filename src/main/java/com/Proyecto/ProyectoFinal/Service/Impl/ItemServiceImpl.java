/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.Proyecto.ProyectoFinal.Service.Impl;

import com.Proyecto.ProyectoFinal.Service.ItemService;
import com.Proyecto.ProyectoFinal.domain.Item;
import java.util.List;
import java.util.Objects;
import org.springframework.stereotype.Service;
import com.Proyecto.ProyectoFinal.DAO.FacturaDao;
import com.Proyecto.ProyectoFinal.DAO.HerramientasDao;
import com.Proyecto.ProyectoFinal.DAO.VentaDao;
import com.Proyecto.ProyectoFinal.domain.Herramientas;
import com.Proyecto.ProyectoFinal.domain.Factura;
import com.Proyecto.ProyectoFinal.domain.Venta;
import org.springframework.beans.factory.annotation.Autowired;


/**
 *
 * @author lossa
 */
@Service
public class ItemServiceImpl implements ItemService {
  @Override 
  public List<Item> gets(){
      return listaItems;
  }
    @Override
    public void saveItem(Item item){
        boolean existe=false;
        for(Item i : listaItems){
           if(Objects.equals(i.getIdHerramienta(),item.getIdHerramienta())){
            if(i.getCantidad()< item.getUnidades()){
                i.setCantidad(i.getCantidad()+1);
            }
        }
            existe=true;
            break;
    }
     if(!existe){
         item.setCantidad(1);
         listaItems.add(item);
     }
   }

    @Override
    public void deleteItem(Item item){
        var posicion=-1;
        var existe=false;
        for(Item x :listaItems){
            ++posicion;
            if(Objects.equals(x.getIdHerramienta(), item.getIdHerramienta())){
                existe=true;
                break;
            }
        }
        if(existe){
            listaItems.remove(posicion);
        }
                
    }
    
    @Override
    public Item get(Item item){
        for (Item x: listaItems){
            if(Objects.equals(x.getIdHerramienta(),item.getIdHerramienta())){
                return x;
            }
        }
        return null;
    }
    
    @Override
    public void actuaizarItem(Item item){
    for (Item x: listaItems){
        if(Objects.equals(x.getIdHerramienta(), item.getIdHerramienta())){
            x.setCantidad(item.getCantidad());
            break;
        }
    }
 }
@Autowired 
private FacturaDao facturaDao;

@Autowired
private VentaDao ventaDao;

@Autowired
private HerramientasDao herramientasDao;

@Override
public void facturar(){
    System.out.println("Facturando");
    

String nombreCliente = "chris";
String apellidoCliente = "ApellidoCliente";

Factura factura = new Factura(nombreCliente, apellidoCliente);
factura = facturaDao.save(factura);

double total = 0;
for (Item i : listaItems) {
    double itemTotal = i.getPrecio() * i.getCantidad();
    System.out.println("Producto: " + i.getDescripcion()
            + " Cantidad: " + i.getCantidad()
            + " Total: " + itemTotal);

    Venta venta = new Venta(factura.getId_factura(), i.getIdHerramienta(), i.getPrecio(), i.getCantidad());
    ventaDao.save(venta);

    Herramientas herramientas = herramientasDao.getReferenceById(i.getIdHerramienta());
    herramientas.setUnidades(herramientas.getUnidades() - i.getCantidad());
   herramientasDao.save(herramientas);

    total += itemTotal;
}

factura.setTotal(total);
facturaDao.save(factura);
listaItems.clear();
}


}
