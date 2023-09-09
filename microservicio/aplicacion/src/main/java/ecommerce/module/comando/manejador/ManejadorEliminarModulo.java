package ecommerce.module.comando.manejador;

import ecommerce.modules.servicios.ServiciosModulo;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

@Component
public class ManejadorEliminarModulo {
    private final ServiciosModulo serviciosModulo;
    public ManejadorEliminarModulo(ServiciosModulo serviciosModulo) {
        this.serviciosModulo = serviciosModulo;
    }

    public ResponseEntity<String> ejecutar(Long id){
        try {
            this.serviciosModulo.eliminar(id);
            return ResponseEntity.ok("Module was removed succesfully");
        }catch (Exception e){
            return new ResponseEntity<>("Error removing the module \n" + e, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

}
