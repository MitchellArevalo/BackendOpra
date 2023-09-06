package ecommerce.category.consulta;

import ecommerce.category.modelo.entidad.Category;
import ecommerce.category.puerto.dao.DaoCategory;
import org.springframework.stereotype.Component;

@Component
public class ManejadorObtenerCategoryByID{
    private final DaoCategory daoCategory;

    public ManejadorObtenerCategoryByID(DaoCategory daoCategory) {
        this.daoCategory = daoCategory;
    }

    public Category ejecutar(Long id){
        return daoCategory.getCategoryByID(id);
    }
}
