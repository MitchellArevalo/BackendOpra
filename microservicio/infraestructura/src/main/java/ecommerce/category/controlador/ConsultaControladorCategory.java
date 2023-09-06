package ecommerce.category.controlador;

import ecommerce.category.consulta.ManejadorObtenerCategories;
import ecommerce.category.consulta.ManejadorObtenerCategoryByID;
import ecommerce.category.modelo.entidad.Category;
import ecommerce.employees.modelo.entidad.Employee;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/category")
@Tag(name = "Controlador consulta category")
public class ConsultaControladorCategory {
    private final ManejadorObtenerCategories getAllCategories;
    private final ManejadorObtenerCategoryByID getCategoryByID;

    public ConsultaControladorCategory(ManejadorObtenerCategories getAllCategories, ManejadorObtenerCategoryByID getCategoryByID) {
        this.getAllCategories = getAllCategories;
        this.getCategoryByID = getCategoryByID;
    }

    @GetMapping()
    @Operation(summary = "Visualizar todos", description = "Metodo utilizado para consultar los datos de categories ")
    public List<Category> obtenerCategorias(){
        return getAllCategories.ejecutar();
    }
    @GetMapping("/{id}")
    public Category obtenerCategoria(@PathVariable("id") Long id){
        return getCategoryByID.ejecutar(id);
    }

}
