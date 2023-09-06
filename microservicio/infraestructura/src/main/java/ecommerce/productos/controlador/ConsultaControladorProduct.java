package ecommerce.productos.controlador;

import ecommerce.employees.modelo.entidad.Employee;
import ecommerce.productos.consulta.ManejadorObtenerListaProducts;
import ecommerce.productos.consulta.ManejadorObtenerProductByID;
import ecommerce.productos.modelo.entidad.Product;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/product")
@Tag(name = "Controlador consulta product")
public class ConsultaControladorProduct {
    private final ManejadorObtenerProductByID obtenerProductByID;
    private final ManejadorObtenerListaProducts listaProducts;

    public ConsultaControladorProduct(ManejadorObtenerProductByID obtenerProductByID, ManejadorObtenerListaProducts listaProducts) {
        this.obtenerProductByID = obtenerProductByID;
        this.listaProducts = listaProducts;
    }

    @GetMapping()
    @Operation(summary = "Visualizar todos", description = "Metodo utilizado para consultar los datos de products")
    public List<Product> obtenerProducts(){
        return listaProducts.ejecutar();
    }
    @GetMapping("/{id}")
    public Product obtenerProduct(@PathVariable("id") Long id){
        return obtenerProductByID.ejecutar(id);
    }

}
