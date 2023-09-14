package ecommerce.cliente.comando.manejador;

import ecommerce.cliente.comando.ComandoSolicitudActualizarCliente;
import ecommerce.cliente.comando.fabrica.GenerarSolicitudActualizarCliente;
import ecommerce.cliente.servicio.ServiciosCliente;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

@Component
public class ManejadorActualizarCliente {
    private final ServiciosCliente serviciosCliente;
    private final GenerarSolicitudActualizarCliente generarSolicitudActualizarCliente;

    public ManejadorActualizarCliente(ServiciosCliente serviciosCliente, GenerarSolicitudActualizarCliente generarSolicitudActualizarCliente) {
        this.serviciosCliente = serviciosCliente;
        this.generarSolicitudActualizarCliente = generarSolicitudActualizarCliente;
    }
    public ResponseEntity<String> actualizar(ComandoSolicitudActualizarCliente comandoSolicitudActualizarCliente, Long id){
        try {
            this.serviciosCliente.update(generarSolicitudActualizarCliente.generar(comandoSolicitudActualizarCliente), id);
            return ResponseEntity.ok("Client was updated succesfully");
        }catch (Exception e){
            return new ResponseEntity<>("Error updating the client \n" + e, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
