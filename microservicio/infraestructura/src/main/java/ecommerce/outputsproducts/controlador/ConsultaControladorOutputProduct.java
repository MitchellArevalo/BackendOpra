package ecommerce.outputsproducts.controlador;

import ecommerce.inputs.modelo.entidad.InputProduct;
import ecommerce.outputproducts.consulta.ManejadorObtenerListaDeOutputProducts;
import ecommerce.outputproducts.consulta.ManejadorObtenerOutputProductById;
import ecommerce.outputproducts.consulta.ManejadorObtenerOutputsProductByIdProduct;
import ecommerce.outputproducts.modelo.entidad.OutputProduct;
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
    private final ManejadorObtenerListaDeOutputProducts manejadorObtenerListaDeOutputProducts;
    private final ManejadorObtenerOutputProductById manejadorObtenerOutputProductById;
    private final ManejadorObtenerOutputsProductByIdProduct manejadorObtenerOutputsProductByIdProduct;

    public ConsultaControladorOutputProduct(ManejadorObtenerListaDeOutputProducts manejadorObtenerListaDeOutputProducts, ManejadorObtenerOutputProductById manejadorObtenerOutputProductById, ManejadorObtenerOutputsProductByIdProduct manejadorObtenerOutputsProductByIdProduct) {
        this.manejadorObtenerListaDeOutputProducts = manejadorObtenerListaDeOutputProducts;
        this.manejadorObtenerOutputProductById = manejadorObtenerOutputProductById;
        this.manejadorObtenerOutputsProductByIdProduct = manejadorObtenerOutputsProductByIdProduct;
    }


    @GetMapping()
    @Operation(summary = "Visualizar todos", description = "Metodo utilizado para consultar los datos de personas")
    public List<OutputProduct> obtenerListaInputProducts(){
        return manejadorObtenerListaDeOutputProducts.ejecutar();
    }
    @GetMapping("/{id}")
    public OutputProduct obtenerInputProduct(@PathVariable("id") Long id){
        return manejadorObtenerOutputProductById.ejecutar(id);
    }

    @GetMapping("/product/{id}")
    public List<OutputProduct> obtenerListaInputsByIdProduct(@PathVariable("id") Long id){
        return manejadorObtenerOutputsProductByIdProduct.ejecutar(id);
    }
}
