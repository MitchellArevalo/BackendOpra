package ecommerce.modulesrol.puerto.repositorio;

import ecommerce.modulesrol.modelo.entidad.ModulesRol;

public interface RepositorioModulesRol {
    Long crear(ModulesRol modulesRol);
    void update(ModulesRol modulesRol, Long id);

    void delete(Long id);
}
