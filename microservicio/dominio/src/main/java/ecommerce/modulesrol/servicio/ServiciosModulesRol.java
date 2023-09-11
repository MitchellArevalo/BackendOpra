package ecommerce.modulesrol.servicio;

import ecommerce.modulesrol.modelo.entidad.ModulesRol;
import ecommerce.modulesrol.puerto.repositorio.RepositorioModulesRol;

public class ServiciosModulesRol {
    private final RepositorioModulesRol repositorioModulesRol;

    public ServiciosModulesRol(RepositorioModulesRol repositorioModulesRol) {
        this.repositorioModulesRol = repositorioModulesRol;
    }

    public Long crear(ModulesRol modulesRol){
        return this.repositorioModulesRol.crear(modulesRol);
    }

    public void eliminar(Long idRol, Long idModulo){
        this.repositorioModulesRol.delete(idRol, idModulo);
    }
}
