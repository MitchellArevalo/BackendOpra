package ecommerce.roles.adaptador.dao;

import ecommerce.infraestructura.jdbc.CustomNamedParameterJdbcTemplate;
import ecommerce.infraestructura.jdbc.EjecucionBaseDeDatos;
import ecommerce.infraestructura.jdbc.sqlstatement.SqlStatement;
import ecommerce.roles.adaptador.repositorio.MapeoRol;
import ecommerce.roles.modelo.entidad.Rol;
import ecommerce.roles.puerto.dao.DaoRol;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class DaoRolPostgres implements DaoRol {
    private final CustomNamedParameterJdbcTemplate customNamedParameterJdbcTemplate;
    private final MapeoRol mapeoRol;

    public DaoRolPostgres(CustomNamedParameterJdbcTemplate customNamedParameterJdbcTemplate, MapeoRol mapeoRol) {
        this.customNamedParameterJdbcTemplate = customNamedParameterJdbcTemplate;
        this.mapeoRol = mapeoRol;
    }
    @SqlStatement(namespace = "roles", value = "obtenerlistaroles")
    private static String sqlObtenerListaRoles;

    @SqlStatement(namespace = "roles", value = "obtenerporid")
    private static String sqlObtenerRol;

    @Override
    public List<Rol> obtenerListaDeRoles() {
        return this.customNamedParameterJdbcTemplate.getNamedParameterJdbcTemplate().query(sqlObtenerListaRoles, mapeoRol);
    }

    @Override
    public Rol obtenerPorID(Long id) {
        MapSqlParameterSource parameterSource = new MapSqlParameterSource();
        parameterSource.addValue("id", id);
        return EjecucionBaseDeDatos.obtenerUnObjetoONull(()-> this.customNamedParameterJdbcTemplate.
                getNamedParameterJdbcTemplate().queryForObject(sqlObtenerRol, parameterSource, mapeoRol));
    }
}
