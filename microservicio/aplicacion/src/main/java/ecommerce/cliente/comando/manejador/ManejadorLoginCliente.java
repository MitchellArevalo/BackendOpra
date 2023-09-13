package ecommerce.cliente.comando.manejador;

import ecommerce.cliente.comando.ComandoSolicitudAutenticarCliente;
import ecommerce.cliente.modelo.entidad.Cliente;
import ecommerce.cliente.servicio.ServiciosCliente;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

@Component
public class ManejadorLoginCliente {
    private final ServiciosCliente serviciosCliente;

    public ManejadorLoginCliente(ServiciosCliente serviciosCliente) {
        this.serviciosCliente = serviciosCliente;
    }

    public ResponseEntity<Cliente> ejecutar(ComandoSolicitudAutenticarCliente cliente){
        try{
            Cliente clienteValor = this.serviciosCliente.autenticar(cliente.getEmail(), cliente.getPassword());
            if (clienteValor != null){
                return new ResponseEntity<>(clienteValor, HttpStatus.ACCEPTED);
            }
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }catch (RuntimeException e){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }
}
