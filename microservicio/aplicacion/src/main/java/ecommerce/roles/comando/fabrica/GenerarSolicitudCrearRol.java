package ecommerce.roles.comando.fabrica;

import ecommerce.roles.comando.ComandoSolicitudCrearRol;
import ecommerce.roles.modelo.entidad.Rol;
import ecommerce.roles.puerto.repositorio.RepositorioRol;
import org.springframework.stereotype.Component;

@Component
public class GenerarSolicitudCrearRol {
    private  final RepositorioRol repositorioRol;

    public GenerarSolicitudCrearRol(RepositorioRol repositorioRol) {
        this.repositorioRol = repositorioRol;
    }

    public Rol crear(ComandoSolicitudCrearRol comandoSolicitudCrearRol){
        return Rol.crear(comandoSolicitudCrearRol.getNombre());
    }

}
