package ecommerce.module.comando.manejador;

import ecommerce.module.comando.ComandoSolicitudActualizarModulo;
import ecommerce.module.comando.fabrica.GenerarSolicitudActualizarModulo;
import ecommerce.modules.servicios.ServiciosModulo;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

@Component
public class ManejadorActualizarModulo {

    private final ServiciosModulo serviciosModulo;
    private final GenerarSolicitudActualizarModulo actualizarModulo;

    public ManejadorActualizarModulo(ServiciosModulo serviciosModulo, GenerarSolicitudActualizarModulo actualizarModulo) {
        this.serviciosModulo = serviciosModulo;
        this.actualizarModulo = actualizarModulo;
    }

    public ResponseEntity<String> actualizar(ComandoSolicitudActualizarModulo comandoSolicitudActualizarModulo, Long id){
        try {
            this.serviciosModulo.actualizar(actualizarModulo.generar(comandoSolicitudActualizarModulo), id);
            return ResponseEntity.ok("Module was updated succesfully");
        }catch (Exception e){
            return new ResponseEntity<>("Error updating the module \n" + e, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

}
