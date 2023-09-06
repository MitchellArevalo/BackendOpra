package ecommerce.category.puerto.dao;

import ecommerce.category.modelo.entidad.Category;

import java.util.List;

public interface DaoCategory {
    List<Category> getAllCategories();
    Category getCategoryByID(Long id);
}
