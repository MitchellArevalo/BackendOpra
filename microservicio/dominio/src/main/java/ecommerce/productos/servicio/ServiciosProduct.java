package ecommerce.productos.servicio;

import ecommerce.productos.modelo.entidad.Product;
import ecommerce.productos.puerto.repositorio.RepositorioProduct;

public class ServiciosProduct {
    private final RepositorioProduct repositorioProduct;

    public ServiciosProduct(RepositorioProduct repositorioProduct) {
        this.repositorioProduct = repositorioProduct;
    }

    public Long crear(Product product){
        return this.repositorioProduct.crear(product);
    }

    public void update(Product product, Long id){ this.repositorioProduct.update(product,id);}
    public void delete(Long id){ this.repositorioProduct.delete(id);}
}
