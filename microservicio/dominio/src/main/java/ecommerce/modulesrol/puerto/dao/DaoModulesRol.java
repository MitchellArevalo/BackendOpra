package ecommerce.modulesrol.puerto.dao;

import ecommerce.modules.modelo.entidad.Modulo;
import ecommerce.modulesrol.modelo.dto.DTOModulosPorRol;
import ecommerce.modulesrol.modelo.entidad.ModulesRol;

import java.util.List;

public interface DaoModulesRol {
    ModulesRol getModuleRol(Long id);
    List<ModulesRol> getAllModulesByRol();

    List<Modulo> getModulesByIDRol(Long id);

    DTOModulosPorRol getModulosPorRol(Long id);
}
