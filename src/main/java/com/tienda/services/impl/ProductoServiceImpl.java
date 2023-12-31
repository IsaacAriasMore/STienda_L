package com.tienda.services.impl;

import com.tienda.dao.ProductoDao;
import com.tienda.dao.ProductoDao;
import com.tienda.domain.Producto;
import com.tienda.services.ProductoService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class ProductoServiceImpl implements ProductoService {

    @Autowired
    private ProductoDao productoDao;

    @Override

    @Transactional(readOnly = true)

    public List<Producto> getProductos(boolean activo) {

        var productos = productoDao.findAll();

        if (activo) {
            productos.removeIf(e -> !e.isActivo());
        }

        return productos;

    }

    @Override
    @Transactional(readOnly = true)

    public Producto getProducto(Producto producto) {
        return productoDao.findById(producto.getIdProducto()).orElse(null);
    }

    @Override

    @Transactional
    public void save(Producto producto) {
        productoDao.save(producto);
    }

    @Override
    @Transactional
    public void delete(Producto producto) {
        productoDao.delete(producto);
    }
    
    //Devuelve la lista de productos filtrados...
    @Override
    @Transactional(readOnly = true)

    public List<Producto> consultaQuery(double precioInf, double precioSup) {
        return productoDao.findByPrecioBetweenOrderByDescripcion(precioInf, precioSup);
    }
    //Devuelve la lista de productos filtrados con JPQL...
    @Override
    @Transactional(readOnly = true)

    public List<Producto> consultaJPQL(double precioInf, double precioSup) {
        return productoDao.consultaJPQL(precioInf, precioSup);
    }
    
    //Devuelve la lista de productos filtrados CON SQL...
    @Override
    @Transactional(readOnly = true)

    public List<Producto> consultaSQL(double precioInf, double precioSup) {
        return productoDao.consultaSQL(precioInf, precioSup);
    }

}
