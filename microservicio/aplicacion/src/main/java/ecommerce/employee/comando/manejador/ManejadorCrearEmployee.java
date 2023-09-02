package ecommerce.employee.comando.manejador;

import ecommerce.ComandoRespuesta;
import ecommerce.employee.comando.ComandoSolicitudCrearEmployee;
import ecommerce.employee.comando.fabrica.GenerarSolicitudCrearEmployee;
import ecommerce.employees.servicios.ServicioCrearEmployee;
import ecommerce.manejador.ManejadorComandoRespuesta;
import org.springframework.stereotype.Component;

@Component
public class ManejadorCrearEmployee implements ManejadorComandoRespuesta<ComandoSolicitudCrearEmployee, ComandoRespuesta<Long>> {
    private final GenerarSolicitudCrearEmployee generarSolicitudCrearEmployee;
    private final ServicioCrearEmployee servicioCrearEmployee;

    public ManejadorCrearEmployee(GenerarSolicitudCrearEmployee generarSolicitudCrearEmployee, ServicioCrearEmployee servicioCrearEmployee) {
        this.generarSolicitudCrearEmployee = generarSolicitudCrearEmployee;
        this.servicioCrearEmployee = servicioCrearEmployee;
    }


    @Override
    public ComandoRespuesta<Long> ejecutar(ComandoSolicitudCrearEmployee comando) {
        return new ComandoRespuesta<>(servicioCrearEmployee.ejecutar(generarSolicitudCrearEmployee.crear(comando)));
    }
}
