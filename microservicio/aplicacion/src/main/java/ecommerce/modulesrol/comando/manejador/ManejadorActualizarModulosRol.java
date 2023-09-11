package ecommerce.modulesrol.comando.manejador;

import ecommerce.module.comando.ComandoSolicitudActualizarModulo;
import ecommerce.modulesrol.comando.ComandoSolicitudActualizarModulosRol;
import ecommerce.modulesrol.comando.fabrica.GenerarSolicitudActualizarModulosRol;
import ecommerce.modulesrol.servicio.ServiciosModulesRol;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

@Component
public class ManejadorActualizarModulosRol {
    private final ServiciosModulesRol serviciosModulesRol;
    private final GenerarSolicitudActualizarModulosRol actualizarModulosRol;

    public ManejadorActualizarModulosRol(ServiciosModulesRol serviciosModulesRol, GenerarSolicitudActualizarModulosRol actualizarModulosRol) {
        this.serviciosModulesRol = serviciosModulesRol;
        this.actualizarModulosRol = actualizarModulosRol;
    }

    public ResponseEntity<String> actualizar(ComandoSolicitudActualizarModulosRol comandoSolicitudActualizarModulo){
        try {
            this.serviciosModulesRol.actualizar(comandoSolicitudActualizarModulo.getIdRol(), comandoSolicitudActualizarModulo.getIdModulo());
            return ResponseEntity.ok("Module from id rol " + comandoSolicitudActualizarModulo.getIdRol() + " was updated succesfully");
        }catch (Exception e){
            return new ResponseEntity<>("Error updating the module \n" + e, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
