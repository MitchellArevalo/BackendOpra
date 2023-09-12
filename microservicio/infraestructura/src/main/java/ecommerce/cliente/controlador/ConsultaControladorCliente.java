package ecommerce.cliente.controlador;

import ecommerce.cliente.consulta.ManejadorObtenerCliente;
import ecommerce.cliente.consulta.ManejadorObtenerListaClientes;
import ecommerce.cliente.modelo.entidad.Cliente;
import ecommerce.modules.modelo.entidad.Modulo;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/client")
@Tag(name = "Controlador  consulta cliente")
public class ConsultaControladorCliente {
    private final ManejadorObtenerCliente manejadorObtenerCliente;
    private final ManejadorObtenerListaClientes manejadorObtenerListaClientes;

    public ConsultaControladorCliente(ManejadorObtenerCliente manejadorObtenerCliente, ManejadorObtenerListaClientes manejadorObtenerListaClientes) {
        this.manejadorObtenerCliente = manejadorObtenerCliente;
        this.manejadorObtenerListaClientes = manejadorObtenerListaClientes;
    }

    @GetMapping()
    @Operation(summary = "Visualizar todos", description = "Metodo utilizado para consultar los clients")
    public List<Cliente> obtenerModulos(){
        return manejadorObtenerListaClientes.getAllClients();
    }
    @GetMapping("/{id}")
    public Cliente obtenerModulo(@PathVariable("id") Long id){
        return manejadorObtenerCliente.getClientById(id);
    }
}
