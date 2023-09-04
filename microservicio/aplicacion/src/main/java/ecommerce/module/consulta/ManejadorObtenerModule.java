package ecommerce.module.consulta;

import ecommerce.modules.modelo.entidad.Modulo;
import ecommerce.modules.puerto.dao.DaoModule;
import org.springframework.stereotype.Component;

@Component
public class ManejadorObtenerModule {
    private final DaoModule daoModule;

    public ManejadorObtenerModule(DaoModule daoModule) {
        this.daoModule = daoModule;
    }

    public Modulo obtener(Long id){
        return daoModule.getByID(id);
    }
}
