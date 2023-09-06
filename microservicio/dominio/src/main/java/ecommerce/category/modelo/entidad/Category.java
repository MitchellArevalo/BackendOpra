package ecommerce.category.modelo.entidad;

import ecommerce.dominio.ValidadorArgumento;

public class Category {

    private Long id;
    private String nameCategory;

    public Category(Long id, String nameCategory) {
        this.id = id;
        this.nameCategory = nameCategory;
    }

    public static Category  reconstruir(Long id, String nameCategory) {
        ValidadorArgumento.validarObligatorio(id, "Debes ingresar el id para reconstruir");
        ValidadorArgumento.validarObligatorio(nameCategory, "Debes ingresar el nombre para reconstruir");
        return new Category(id, nameCategory);
    }

    public Category(String nameCategory) {
        this.nameCategory = nameCategory;
    }
    public static Category crear(String nameCategory) {
        ValidadorArgumento.validarObligatorio(nameCategory, "Debes ingresar el nombre de la categoria para crear");
        return new Category(nameCategory);
    }

    public String getNameCategory() {
        return nameCategory;
    }
    public Long getId() {
        return id;
    }

}
