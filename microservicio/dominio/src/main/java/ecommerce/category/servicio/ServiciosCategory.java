package ecommerce.category.servicio;

import ecommerce.category.modelo.entidad.Category;
import ecommerce.category.puerto.repositorio.RepositorioCategory;

public class ServiciosCategory {
    private final RepositorioCategory repositorioCategory;

    public ServiciosCategory(RepositorioCategory repositorioCategory) {
        this.repositorioCategory = repositorioCategory;
    }

    public Long crear(Category category){
        return this.repositorioCategory.crear(category);
    }
}
