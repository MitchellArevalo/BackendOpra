package ecommerce.modulesrol.adaptador.repositorio;

import ecommerce.infraestructura.jdbc.MapperResult;
import ecommerce.modules.modelo.entidad.Modulo;
import ecommerce.modules.puerto.dao.DaoModule;
import ecommerce.modulesrol.modelo.entidad.ModulesRol;
import ecommerce.roles.modelo.entidad.Rol;
import ecommerce.roles.puerto.dao.DaoRol;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import java.sql.ResultSet;
import java.sql.SQLException;

@Component
public class MapeoModulosRol implements RowMapper<ModulesRol>, MapperResult {
    private final DaoModule daoModule;
    private final DaoRol daoRol;

    public MapeoModulosRol(DaoModule daoModule, DaoRol daoRol) {
        this.daoModule = daoModule;
        this.daoRol = daoRol;
    }

    private Modulo obtenerModulo(Long id){
        return this.daoModule.getByID(id);
    }
    private Rol obtenerRol(Long id){
        return this.daoRol.obtenerPorID(id);
    }

    @Override
    public ModulesRol mapRow(ResultSet rs, int rowNum) throws SQLException {
        Long id = rs.getLong("id");
        Long modulo_id = rs.getLong("module_id");
        Long rol_id = rs.getLong("rol_id");
        return ModulesRol.reconstruir(id, obtenerModulo(modulo_id), obtenerRol(rol_id));
    }
}
