package ecommerce.modulesrol.comando.fabrica;

import ecommerce.modules.modelo.entidad.Modulo;
import ecommerce.modules.puerto.dao.DaoModule;
import ecommerce.modulesrol.comando.ComandoSolicitudCrearModuloRol;
import ecommerce.modulesrol.modelo.entidad.ModulesRol;
import ecommerce.roles.modelo.entidad.Rol;
import ecommerce.roles.puerto.dao.DaoRol;
import org.springframework.stereotype.Component;

@Component
public class GenerarSolicitudCrearModuloRol {
    private final DaoModule daoModule;
    private final DaoRol daoRol;

    public GenerarSolicitudCrearModuloRol(DaoModule daoModule, DaoRol daoRol) {
        this.daoModule = daoModule;
        this.daoRol = daoRol;
    }

    private Modulo obtenerModulo(Long id){
        return this.daoModule.getByID(id);
    }
    private Rol obtenerRol(Long id){
        return this.daoRol.obtenerPorID(id);
    }

    public ModulesRol crear(ComandoSolicitudCrearModuloRol comandoSolicitudCrearModuloRol){
        return ModulesRol.crear(obtenerModulo(comandoSolicitudCrearModuloRol.getIdModulo()),
                obtenerRol(comandoSolicitudCrearModuloRol.getIdRol()));
    }
}
