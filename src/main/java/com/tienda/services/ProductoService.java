/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.tienda.services;


import com.tienda.domain.Producto;
import java.util.List;

/**
 *
 * @author ricar
 */
public interface ProductoService {
    
    //Se propone la firma de un metodo para
    //recuperar los registros de la tabla Producto
    
    public List<Producto> getProductos(Boolean activo);
    
    //Se programa el codigo para obtener una Producto
    
    public Producto getProducto (Producto producto);
    
    // Se actualiza o se crea un registro que tenga el mismo idProducto
    
    //Si el objeto tiene un idProducto, lo busca... si lo encuentra
    //lo actualiza si no.. lo crea..
    
    public void save(Producto producto);
    
    //Se elimina el registro que tenga el idProducto pasado por parametro
    
    public void delete(Producto Producto);
    
    
    
    
    
}