package ecommerce.outputsproducts.controlador;

import ecommerce.inputproducts.consulta.ManejadorObtenerInputProductById;
import ecommerce.inputproducts.consulta.ManejadorObtenerInputsProductByIdProduct;
import ecommerce.inputproducts.consulta.ManejadorObtenerListaDeInputProducts;
import ecommerce.inputs.modelo.entidad.InputProduct;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
@RestController
@RequestMapping("/outputs")
@Tag(name = "Controlador consulta outputs")
public class ConsultaControladorOutputProduct {
    private final ManejadorObtenerListaDeInputProducts manejadorObtenerListaDeInputProducts;
    private final ManejadorObtenerInputProductById manejadorObtenerInputProductById;
    private final ManejadorObtenerInputsProductByIdProduct manejadorObtenerInputsProductByIdProduct;

    public ConsultaControladorOutputProduct(ManejadorObtenerListaDeInputProducts manejadorObtenerListaDeInputProducts, ManejadorObtenerInputProductById manejadorObtenerInputProductById, ManejadorObtenerInputsProductByIdProduct manejadorObtenerInputsProductByIdProduct) {
        this.manejadorObtenerListaDeInputProducts = manejadorObtenerListaDeInputProducts;
        this.manejadorObtenerInputProductById = manejadorObtenerInputProductById;
        this.manejadorObtenerInputsProductByIdProduct = manejadorObtenerInputsProductByIdProduct;
    }

    @GetMapping()
    @Operation(summary = "Visualizar todos", description = "Metodo utilizado para consultar los datos de personas")
    public List<InputProduct> obtenerListaInputProducts(){
        return manejadorObtenerListaDeInputProducts.ejecutar();
    }
    @GetMapping("/{id}")
    public InputProduct obtenerInputProduct(@PathVariable("id") Long id){
        return manejadorObtenerInputProductById.ejecutar(id);
    }

    @GetMapping("/product/{id}")
    public List<InputProduct> obtenerListaInputsByIdProduct(@PathVariable("id") Long id){
        return manejadorObtenerInputsProductByIdProduct.ejecutar(id);
    }
}
