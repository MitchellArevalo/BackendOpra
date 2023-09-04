package ecommerce.modulesrol.consulta;

import ecommerce.modulesrol.modelo.entidad.ModulesRol;
import ecommerce.modulesrol.puerto.dao.DaoModulesRol;
import org.springframework.stereotype.Component;

@Component
public class ManejadorObtenerModuloRol {
    private final DaoModulesRol daoModulesRol;

    public ManejadorObtenerModuloRol(DaoModulesRol daoModulesRol) {
        this.daoModulesRol = daoModulesRol;
    }

    public ModulesRol ejecutar(Long id){
        return this.daoModulesRol.getModuleRol(id);
    }
}
