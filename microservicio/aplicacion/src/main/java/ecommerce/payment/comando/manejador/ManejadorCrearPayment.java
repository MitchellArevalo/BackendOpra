package ecommerce.payment.comando.manejador;

import ecommerce.ComandoRespuesta;
import ecommerce.manejador.ManejadorComandoRespuesta;
import ecommerce.payment.comando.ComandoSolicitudCrearPayment;
import ecommerce.payment.comando.fabrica.GenerarSolicitudCrearPayment;
import ecommerce.payment.servicio.ServiciosPayment;
import org.springframework.stereotype.Component;

@Component
public class ManejadorCrearPayment implements ManejadorComandoRespuesta<ComandoSolicitudCrearPayment, ComandoRespuesta<Long>> {
    private final ServiciosPayment serviciosPayment;
    private final GenerarSolicitudCrearPayment generarSolicitudCrearPayment;

    public ManejadorCrearPayment(ServiciosPayment serviciosPayment, GenerarSolicitudCrearPayment generarSolicitudCrearPayment) {
        this.serviciosPayment = serviciosPayment;
        this.generarSolicitudCrearPayment = generarSolicitudCrearPayment;
    }

    @Override
    public ComandoRespuesta<Long> ejecutar(ComandoSolicitudCrearPayment comando) {
        return new ComandoRespuesta<>(this.serviciosPayment.crear(generarSolicitudCrearPayment.generar(comando)));
    }
}
