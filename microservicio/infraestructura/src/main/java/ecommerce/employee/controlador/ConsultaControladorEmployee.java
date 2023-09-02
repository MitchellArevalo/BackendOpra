package ecommerce.employee.controlador;

import ecommerce.employee.consulta.ManejadorObtenerEmployee;
import ecommerce.employee.consulta.ManejadorObtenerListadoEmployee;
import ecommerce.employees.modelo.entidad.Employee;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/employee")
@Tag(name = "Controlador consulta employee")
public class ConsultaControladorEmployee {
    private final ManejadorObtenerEmployee manejadorObtenerEmployee;
    private final ManejadorObtenerListadoEmployee manejadorObtenerListadoEmployee;

    public ConsultaControladorEmployee(ManejadorObtenerEmployee manejadorObtenerEmployee, ManejadorObtenerListadoEmployee manejadorObtenerListadoEmployee) {
        this.manejadorObtenerEmployee = manejadorObtenerEmployee;
        this.manejadorObtenerListadoEmployee = manejadorObtenerListadoEmployee;
    }

    @GetMapping()
    @Operation(summary = "Visualizar todos", description = "Metodo utilizado para consultar los datos de personas")
    public List<Employee> obtenerClientes(){
        return manejadorObtenerListadoEmployee.ejecutar();
    }
    @GetMapping("/{id}")
    public Employee obtenerCliente(@PathVariable("id") Long id){
        return manejadorObtenerEmployee.ejecutar(id);
    }
}
