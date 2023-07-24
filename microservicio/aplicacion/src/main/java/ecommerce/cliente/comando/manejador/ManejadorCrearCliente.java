package ecommerce.cliente.comando.manejador;

import ecommerce.ComandoRespuesta;
import ecommerce.cliente.comando.ComandoSolicitudCrearCliente;
import ecommerce.cliente.comando.fabrica.GenerarSolicitudACliente;
import ecommerce.cliente.servicio.ServicioCrearCliente;
import ecommerce.manejador.ManejadorComandoRespuesta;
import org.springframework.stereotype.Component;

@Component
public class ManejadorCrearCliente implements ManejadorComandoRespuesta<ComandoSolicitudCrearCliente, ComandoRespuesta<Long>> {
    private final GenerarSolicitudACliente generarSolicitudACliente;
    private final ServicioCrearCliente servicioCrearCliente;

    public ManejadorCrearCliente(GenerarSolicitudACliente generarSolicitudACliente, ServicioCrearCliente servicioCrearCliente) {
        this.generarSolicitudACliente = generarSolicitudACliente;
        this.servicioCrearCliente = servicioCrearCliente;
    }


    @Override
    public ComandoRespuesta<Long> ejecutar(ComandoSolicitudCrearCliente comandoSolicitudCrearCliente) {
        return new ComandoRespuesta<>(
                servicioCrearCliente.ejecutar(generarSolicitudACliente.crear(comandoSolicitudCrearCliente))
        );
    }
}
