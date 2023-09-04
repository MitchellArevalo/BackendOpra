package ecommerce.modulesrol.consulta;

import ecommerce.modulesrol.modelo.entidad.ModulesRol;
import ecommerce.modulesrol.puerto.dao.DaoModulesRol;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ManejadorObtenerModulosRol {
    private final DaoModulesRol daoModulesRol;

    public ManejadorObtenerModulosRol(DaoModulesRol daoModulesRol) {
        this.daoModulesRol = daoModulesRol;
    }
    public List<ModulesRol> ejecutar(){
        return this.daoModulesRol.getAllModulesByRol();
    }
}
