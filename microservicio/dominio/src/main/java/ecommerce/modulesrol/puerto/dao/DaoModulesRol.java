package ecommerce.modulesrol.puerto.dao;

import ecommerce.modulesrol.modelo.entidad.ModulesRol;

import java.util.List;

public interface DaoModulesRol {
    ModulesRol getModuleRol(Long id);
    List<ModulesRol> getAllModulesByRol();

    List<ModulesRol> getModulesByIDRol(Long id);
}
