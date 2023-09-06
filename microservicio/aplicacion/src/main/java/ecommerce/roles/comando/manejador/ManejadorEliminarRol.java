package ecommerce.roles.comando.manejador;

import ecommerce.roles.puerto.repositorio.RepositorioRol;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

@Component
public class ManejadorEliminarRol {
    private final RepositorioRol repositorioRol;

    public ManejadorEliminarRol(RepositorioRol repositorioRol) {
        this.repositorioRol = repositorioRol;
    }

    public ResponseEntity<String> ejecutar(Long id){
        try{
            repositorioRol.delete(id);
            return new ResponseEntity<>("Rol eliminado con exito", HttpStatus.OK);
        }catch (RuntimeException e){
            return new ResponseEntity<>("Error al eliminar el rol"  + e, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
