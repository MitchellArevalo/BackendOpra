package ecommerce.productos.modelo.dto;

import ecommerce.category.modelo.entidad.Category;
import ecommerce.dominio.ValidadorArgumento;
import ecommerce.productos.modelo.entidad.Product;

import java.math.BigDecimal;

public class ProductoDTO {
    private Long id;
    private String name;
    private Long category;
    private String itemCode;
    private String size;
    private BigDecimal cost;
    private BigDecimal salesPrice;
    private String description;
    private String image;
    private Integer stock;
    private Long cantidadProductosVendidos;

    public ProductoDTO(Long id, String name, Long category, String itemCode, String size, BigDecimal cost, BigDecimal salesPrice, String description, String image, Integer stock, Long cantidadProductosVendidos) {
        this.id = id;
        this.name = name;
        this.category = category;
        this.itemCode = itemCode;
        this.size = size;
        this.cost = cost;
        this.salesPrice = salesPrice;
        this.description = description;
        this.image = image;
        this.stock = stock;
        this.cantidadProductosVendidos = cantidadProductosVendidos;
    }
    public static ProductoDTO reconstruir (Long id, String name, Long category, String itemCode, String size, BigDecimal cost, BigDecimal salesPrice, String description, String image, Integer stock, Long cantidadProductosVendidos) {
        ValidadorArgumento.validarObligatorio(id, "Debes ingresar el id para reconstruir");
        ValidadorArgumento.validarObligatorio(name, "Debes ingresar el name para reconstruir");
        ValidadorArgumento.validarObligatorio(category, "Debes ingresar el category para reconstruir");
        ValidadorArgumento.validarObligatorio(itemCode, "Debes ingresar el itemCode para reconstruir");
        ValidadorArgumento.validarObligatorio(size, "Debes ingresar el size para reconstruir");
        ValidadorArgumento.validarObligatorio(cost, "Debes ingresar el cost para reconstruir");
        ValidadorArgumento.validarObligatorio(salesPrice, "Debes ingresar el salesPrice para reconstruir");
        ValidadorArgumento.validarObligatorio(description, "Debes ingresar el description para reconstruir");
        ValidadorArgumento.validarObligatorio(image, "Debes ingresar el image para reconstruir");
        ValidadorArgumento.validarObligatorio(stock, "Debes ingresar el stock para reconstruir");
        ValidadorArgumento.validarObligatorio(cantidadProductosVendidos, "Debes ingresar la cantidad de productos vendidos para reconstruir");
        return new ProductoDTO(id, name, category, itemCode,size,cost,salesPrice,description,image,stock, cantidadProductosVendidos);
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Long getCategory() {
        return category;
    }

    public String getItemCode() {
        return itemCode;
    }

    public String getSize() {
        return size;
    }

    public BigDecimal getCost() {
        return cost;
    }

    public BigDecimal getSalesPrice() {
        return salesPrice;
    }

    public String getDescription() {
        return description;
    }

    public String getImage() {
        return image;
    }

    public Integer getStock() {
        return stock;
    }

    public Long getCantidadProductosVendidos() {
        return cantidadProductosVendidos;
    }
}
