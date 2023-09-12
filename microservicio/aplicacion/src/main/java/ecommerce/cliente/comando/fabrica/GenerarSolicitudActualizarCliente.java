package ecommerce.cliente.comando.fabrica;

import ecommerce.cliente.comando.ComandoSolicitudActualizarCliente;
import ecommerce.cliente.modelo.entidad.Cliente;
import org.springframework.stereotype.Component;

@Component
public class GenerarSolicitudActualizarCliente {
    public Cliente generar(ComandoSolicitudActualizarCliente cliente){
        return Cliente.actualizar(cliente.getName(), cliente.getEmail(), cliente.getDocument(), cliente.getAddress(), cliente.getPhoneNumber());
    }
}
