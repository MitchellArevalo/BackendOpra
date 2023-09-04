package ecommerce.module.consulta;

import ecommerce.modules.modelo.entidad.Modulo;
import ecommerce.modules.puerto.dao.DaoModule;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ManejadorListadoModules {
    private final DaoModule daoModule;

    public ManejadorListadoModules(DaoModule daoModule) {
        this.daoModule = daoModule;
    }
    public List<Modulo> obtener(){
        return daoModule.getAllModules();
    }
}
