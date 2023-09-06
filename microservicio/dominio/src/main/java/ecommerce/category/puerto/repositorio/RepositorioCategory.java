package ecommerce.category.puerto.repositorio;

import ecommerce.category.modelo.entidad.Category;

public interface RepositorioCategory {
    Long crear(Category category);

    void eliminar(Long id);

    void update(Category category, Long id);
}
