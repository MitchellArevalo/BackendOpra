package ecommerce.productos.puerto.repositorio;

import ecommerce.productos.modelo.entidad.Product;

import java.math.BigDecimal;

public interface RepositorioProduct {
    Long crear(Product product);
    void update(Product product, Long id);
    void delete(Long id);

    void addToStock(Long id, BigDecimal quantityStock);
    void removeToStock(Long id, BigDecimal quantityStock);

    void updateSalesPriceProduct(Long id, BigDecimal salesPriceProduct);
    void updateCostPriceProduct(Long id, BigDecimal costPriceProduct);
}
