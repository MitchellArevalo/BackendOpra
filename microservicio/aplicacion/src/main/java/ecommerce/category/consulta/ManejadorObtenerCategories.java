package ecommerce.category.consulta;

import ecommerce.category.modelo.entidad.Category;
import ecommerce.category.puerto.dao.DaoCategory;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ManejadorObtenerCategories {
    private final DaoCategory daoCategory;

    public ManejadorObtenerCategories(DaoCategory daoCategory) {
        this.daoCategory = daoCategory;
    }

    public List<Category> ejecutar(){
        return this.daoCategory.getAllCategories();
    }
}
