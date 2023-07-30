package ecommerce.roles.servicio;

import ecommerce.roles.modelo.entidad.Rol;
import ecommerce.roles.puerto.repositorio.RepositorioRol;

public class ServicioCrearRol {
    private final RepositorioRol repositorioRol;

    public ServicioCrearRol(RepositorioRol repositorioRol) {
        this.repositorioRol = repositorioRol;
    }

    public Long ejecutar(Rol rol){
        return this.repositorioRol.crear(rol);
    }
}
