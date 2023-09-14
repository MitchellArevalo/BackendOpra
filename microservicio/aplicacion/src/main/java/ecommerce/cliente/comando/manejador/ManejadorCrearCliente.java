package ecommerce.cliente.comando.manejador;

import ecommerce.ComandoRespuesta;
import ecommerce.cliente.comando.ComandoSolicitudCrearCliente;
import ecommerce.cliente.comando.fabrica.GenerarSolicitudACliente;
import ecommerce.cliente.servicio.ServiciosCliente;
import ecommerce.manejador.ManejadorComandoRespuesta;
import org.springframework.stereotype.Component;

@Component
public class ManejadorCrearCliente implements ManejadorComandoRespuesta<ComandoSolicitudCrearCliente, ComandoRespuesta<Long>> {
    private final GenerarSolicitudACliente generarSolicitudACliente;
    private final ServiciosCliente serviciosCliente;

    public ManejadorCrearCliente(GenerarSolicitudACliente generarSolicitudACliente, ServiciosCliente serviciosCliente) {
        this.generarSolicitudACliente = generarSolicitudACliente;
        this.serviciosCliente = serviciosCliente;
    }


    @Override
    public ComandoRespuesta<Long> ejecutar(ComandoSolicitudCrearCliente comandoSolicitudCrearCliente) {
        return new ComandoRespuesta<>(
                serviciosCliente.crear(generarSolicitudACliente.crear(comandoSolicitudCrearCliente))
        );
    }
}
