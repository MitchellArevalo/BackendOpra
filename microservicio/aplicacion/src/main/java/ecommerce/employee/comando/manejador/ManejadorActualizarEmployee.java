package ecommerce.employee.comando.manejador;

import ecommerce.employee.comando.ComandoActualizarEmployee;
import ecommerce.employee.comando.fabrica.GenerarSolicitudActualizarEmployee;
import ecommerce.employees.servicios.ServicioActualizarEmployee;
import org.springframework.stereotype.Component;

@Component
public class ManejadorActualizarEmployee  {
    private final GenerarSolicitudActualizarEmployee generarSolicitudActualizarEmployee;
    private final ServicioActualizarEmployee servicioActualizarEmployee;

    public ManejadorActualizarEmployee(GenerarSolicitudActualizarEmployee generarSolicitudActualizarEmployee, ServicioActualizarEmployee servicioActualizarEmployee) {
        this.generarSolicitudActualizarEmployee = generarSolicitudActualizarEmployee;
        this.servicioActualizarEmployee = servicioActualizarEmployee;
    }

    public void ejecutar(ComandoActualizarEmployee comando, Long id) {
        servicioActualizarEmployee.ejecutar(generarSolicitudActualizarEmployee.actualizar(comando), id);
    }
}
