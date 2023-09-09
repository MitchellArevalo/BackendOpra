package ecommerce.modulesrol.adaptador.repositorio;

import ecommerce.modules.modelo.entidad.Modulo;
import ecommerce.modules.puerto.dao.DaoModule;
import ecommerce.modulesrol.modelo.dto.DTOModulosPorRol;
import ecommerce.modulesrol.puerto.dao.DaoModulesRol;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class MapeoDTOModulosRol implements RowMapper<DTOModulosPorRol> {
    private final DaoModulesRol daoModulesRol;


    public MapeoDTOModulosRol(DaoModulesRol daoModulesRol) {
        this.daoModulesRol = daoModulesRol;
    }

    private List<Modulo> obtenerModulos(Long id){
        return this.daoModulesRol.getModulesByIDRol(id);
    }

    @Override
    public DTOModulosPorRol mapRow(ResultSet rs, int rowNum) throws SQLException {
        Long idModulo = rs.getLong("module_id");
        return new DTOModulosPorRol(obtenerModulos(idModulo));
    }
}
