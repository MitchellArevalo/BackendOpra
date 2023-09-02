package ecommerce.module.consulta;

import ecommerce.modulos.modelo.entidad.Modulo;
import ecommerce.modulos.puerto.dao.DaoModule;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ManejadorListadoModules {
    private final DaoModule daoModule;

    public ManejadorListadoModules(DaoModule daoModule) {
        this.daoModule = daoModule;
    }
    public List<Modulo> obtener(Long id){
        return daoModule.getAllModules();
    }
}
