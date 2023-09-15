package ecommerce.productos.modelo.entidad;

import ecommerce.category.modelo.entidad.Category;
import ecommerce.dominio.ValidadorArgumento;

import java.math.BigDecimal;

public class Product {
    private Long id;
    private String name;
    private Category category;
    private String itemCode;
    private String size;
    private BigDecimal cost;
    private BigDecimal salesPrice;
    private String description;
    private String image;
    private Integer stock;

    public Product(Long id, String name, Category category, String itemCode, String size, BigDecimal cost, BigDecimal salesPrice, String description, String image, Integer stock) {
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
    }
    public static Product reconstruir (Long id, String name, Category category, String itemCode, String size, BigDecimal cost, BigDecimal salesPrice, String description, String image, Integer stock) {
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
        return new Product(id, name, category, itemCode,size,cost,salesPrice,description,image,stock);
    }

    public Product(String name, Category category, String itemCode, String size, String description, String image) {
        this.name = name;
        this.category = category;
        this.itemCode = itemCode;
        this.size = size;
        this.description = description;
        this.image = image;
        this.stock = 0;
        setCost(new BigDecimal(90));
        setSalesPrice(new BigDecimal(270));
    }
    public static Product crear(String name, Category category, String itemCode, String size, String description, String image) {
        ValidadorArgumento.validarObligatorio(name, "Debes ingresar el nombre para crear producto");
        ValidadorArgumento.validarObligatorio(category, "Debes ingresar la category para crear producto");
        ValidadorArgumento.validarObligatorio(itemCode, "Debes ingresar el itemCode para crear producto");
        ValidadorArgumento.validarObligatorio(size, "Debes ingresar el size para crear producto");
        ValidadorArgumento.validarObligatorio(description, "Debes ingresar la description para crear producto");
        ValidadorArgumento.validarObligatorio(image, "Debes ingresar la image para crear producto");
        return new Product(name, category, itemCode,size,description,image);
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Category getCategory() {
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

    public void setCost(BigDecimal cost) {
        this.cost = cost;
    }

    public void setSalesPrice(BigDecimal salesPrice) {
        this.salesPrice = salesPrice;
    }

}
