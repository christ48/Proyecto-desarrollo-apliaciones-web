/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.Proyecto.ProyectoFinal.Service;

import com.Proyecto.ProyectoFinal.domain.Item;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author lossa
 */
public interface ItemService {
    List<Item> listaItems = new ArrayList<>();
    
    public List<Item> gets();
    
    public Item get(Item item);
    
    public void deleteItem(Item item);
    
    public void saveItem(Item item);
    
    public void actuaizarItem(Item item);
    
   public void facturar();
    
}
