package ecommerce.modulesrol.adaptador.repositorio;

import ecommerce.modules.modelo.entidad.Modulo;
import ecommerce.modules.puerto.dao.DaoModule;
import ecommerce.modulesrol.modelo.dto.DTOModulosPorRol;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class MapeoDTOModulosRol implements RowMapper<DTOModulosPorRol> {
    private final DaoModule daoModule;

    public MapeoDTOModulosRol(DaoModule daoModule) {
        this.daoModule = daoModule;
    }


    @Override
    public DTOModulosPorRol mapRow(ResultSet rs, int rowNum) throws SQLException {
        Long idModulo = rs.getLong("module_id");
        return null;
    }
}
