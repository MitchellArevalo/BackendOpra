package ecommerce.productos.puerto.repositorio;

import ecommerce.productos.modelo.entidad.Product;

public interface RepositorioProduct {
    Long crear(Product product);
    void update(Product product, Long id);
    void delete(Long id);
}
