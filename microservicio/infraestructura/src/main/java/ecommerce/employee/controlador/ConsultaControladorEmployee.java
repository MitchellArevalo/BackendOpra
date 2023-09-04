package ecommerce.employee.controlador;

import ecommerce.ComandoRespuesta;
import ecommerce.configuracion.JwtTokenUtil;
import ecommerce.employee.comando.ComandoAutenticacion;
import ecommerce.employee.consulta.EmployeeAutenticadoDatos;
import ecommerce.employee.consulta.ManejadorObtenerEmployee;
import ecommerce.employee.consulta.ManejadorObtenerListadoEmployee;
import ecommerce.employees.modelo.entidad.Employee;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/employee")
@Tag(name = "Controlador consulta employee")
public class ConsultaControladorEmployee {
    @Autowired
    AuthenticationManager authManager;

    @Autowired
    JwtTokenUtil jwtUtil;

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

    @PostMapping("/login")
    public ComandoRespuesta<EmployeeAutenticadoDatos> login(@RequestBody ComandoAutenticacion comandoAutenticacion){


        Authentication authentication = authManager
                .authenticate(new UsernamePasswordAuthenticationToken(comandoAutenticacion.getEmail(),
                        comandoAutenticacion.getPassword()));

        Employee employee = (Employee) authentication.getPrincipal();
        String accessToken = jwtUtil.generateAccessToken(employee);
        EmployeeAutenticadoDatos response = new EmployeeAutenticadoDatos(accessToken, employee.getIdEmployee(),
                employee.getName(), employee.getEmail(), employee.getPassword(), employee.getDocument(),
                employee.getAddress(), employee.getPhoneNumber());
        return new ComandoRespuesta<>(response);
    }
}
