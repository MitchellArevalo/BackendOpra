package ecommerce.modulesrol.puerto.repositorio;

import ecommerce.modulesrol.modelo.entidad.ModulesRol;

public interface RepositorioModulesRol {
    Long crear(ModulesRol modulesRol);
    void update(Long idRol, Long idModulo);

    void delete(Long idRol, Long idModulo);
}
