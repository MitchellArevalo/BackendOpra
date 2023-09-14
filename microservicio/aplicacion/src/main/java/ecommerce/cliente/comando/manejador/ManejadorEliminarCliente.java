package ecommerce.cliente.comando.manejador;

import ecommerce.cliente.servicio.ServiciosCliente;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

@Component
public class ManejadorEliminarCliente {
    private final ServiciosCliente serviciosCliente;

    public ManejadorEliminarCliente(ServiciosCliente serviciosCliente) {
        this.serviciosCliente = serviciosCliente;
    }

    public ResponseEntity<String> ejecutar(Long id){
        try {
            this.serviciosCliente.delete(id);
            return ResponseEntity.ok("Client was removed succesfully");
        }catch (Exception e){
            return new ResponseEntity<>("Error deleting the client \n" + e, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
