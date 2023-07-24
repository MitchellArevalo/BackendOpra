package ecommerce.cliente.comando.fabrica;

import ecommerce.cliente.comando.ComandoSolicitudCrearCliente;
import ecommerce.cliente.modelo.entidad.Cliente;
import org.springframework.stereotype.Component;

@Component
public class GenerarSolicitudACliente {
    public Cliente crear(ComandoSolicitudCrearCliente comandoSolicitudCrearCliente){
        return Cliente.crear(comandoSolicitudCrearCliente.getNombre(), comandoSolicitudCrearCliente.getEmail(), comandoSolicitudCrearCliente.getDocumento(),
                comandoSolicitudCrearCliente.getDireccion(), comandoSolicitudCrearCliente.getNumeroTelefonico(), comandoSolicitudCrearCliente.getUsername(),
                comandoSolicitudCrearCliente.getContrasena());
    }
}
