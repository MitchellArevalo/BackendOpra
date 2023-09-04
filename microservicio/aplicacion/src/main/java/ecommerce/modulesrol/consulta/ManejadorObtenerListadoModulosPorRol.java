package ecommerce.modulesrol.consulta;

import ecommerce.modulesrol.modelo.entidad.ModulesRol;
import ecommerce.modulesrol.puerto.dao.DaoModulesRol;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ManejadorObtenerListadoModulosPorRol {
    private final DaoModulesRol daoModulesRol;

    public ManejadorObtenerListadoModulosPorRol(DaoModulesRol daoModulesRol) {
        this.daoModulesRol = daoModulesRol;
    }

    public List<ModulesRol> ejecutar(Long id){
        return this.daoModulesRol.getModulesByIDRol(id);
    }
}
