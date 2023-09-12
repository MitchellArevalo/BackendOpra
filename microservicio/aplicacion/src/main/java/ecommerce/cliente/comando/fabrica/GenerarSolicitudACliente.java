package ecommerce.cliente.comando.fabrica;

import ecommerce.cliente.comando.ComandoSolicitudCrearCliente;
import ecommerce.cliente.modelo.entidad.Cliente;
import org.springframework.stereotype.Component;

@Component
public class GenerarSolicitudACliente {
    public Cliente crear(ComandoSolicitudCrearCliente comandoSolicitudCrearCliente){
        return Cliente.crear(comandoSolicitudCrearCliente.getName(), comandoSolicitudCrearCliente.getEmail(), comandoSolicitudCrearCliente.getDocument(),
                comandoSolicitudCrearCliente.getAddress(), comandoSolicitudCrearCliente.getPhoneNumber(), comandoSolicitudCrearCliente.getPassword());
    }
}
