package ecommerce.productos.puerto.dao;

import ecommerce.productos.modelo.entidad.Product;

import java.util.List;

public interface DaoProduct {
    Product getByID(Long id);
    List<Product> getAllProducts();
}
