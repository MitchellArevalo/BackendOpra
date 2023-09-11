package ecommerce.modulesrol.comando.manejador;

import ecommerce.module.comando.ComandoSolicitudActualizarModulo;
import ecommerce.modulesrol.servicio.ServiciosModulesRol;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

@Component
public class ManejadorEliminarModulosRol {
    private final ServiciosModulesRol serviciosModulesRol;

    public ManejadorEliminarModulosRol(ServiciosModulesRol serviciosModulesRol) {
        this.serviciosModulesRol = serviciosModulesRol;
    }

    public ResponseEntity<String> ejecutar(Long idRol, Long idModulo){
        try {
            this.serviciosModulesRol.eliminar(idRol, idModulo);
            return ResponseEntity.ok("Modulo with the id rol " + idRol + " was removed succesfully");
        }catch (Exception e){
            return new ResponseEntity<>("Error removing the module \n" + e, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }


}
