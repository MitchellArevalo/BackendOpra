package ecommerce.modulesrol.comando.fabrica;

import ecommerce.modules.modelo.entidad.Modulo;
import ecommerce.modules.puerto.dao.DaoModule;
import ecommerce.modulesrol.comando.ComandoSolicitudActualizarModulosRol;
import ecommerce.modulesrol.modelo.entidad.ModulesRol;
import ecommerce.roles.modelo.entidad.Rol;
import ecommerce.roles.puerto.dao.DaoRol;
import org.springframework.stereotype.Component;

@Component
public class GenerarSolicitudActualizarModulosRol {
    private final DaoModule daoModule;
    private final DaoRol daoRol;

    public GenerarSolicitudActualizarModulosRol(DaoModule daoModule, DaoRol daoRol) {
        this.daoModule = daoModule;
        this.daoRol = daoRol;
    }

    private Modulo obtenerModulo(Long id){
        return this.daoModule.getByID(id);
    }
    private Rol obtenerRol(Long id){
        return this.daoRol.obtenerPorID(id);
    }

    public ModulesRol generar(ComandoSolicitudActualizarModulosRol actualizarModulosRol){
        return ModulesRol.crear(obtenerModulo(actualizarModulosRol.getIdModulo()),
                obtenerRol(actualizarModulosRol.getIdRol()));
    }
}
