package ecommerce.category.comando.fabrica;

import ecommerce.category.comando.ComandoSolicitudCrearCategory;
import ecommerce.category.modelo.entidad.Category;
import org.springframework.stereotype.Component;

@Component
public class GenerarSolicitudCrearCategory {
    public Category generar(ComandoSolicitudCrearCategory category){
        return Category.crear(category.getName());
    }
}
