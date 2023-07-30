package ecommerce.roles.adaptador.repositorio;

import ecommerce.infraestructura.jdbc.CustomNamedParameterJdbcTemplate;
import ecommerce.infraestructura.jdbc.EjecucionBaseDeDatos;
import ecommerce.infraestructura.jdbc.sqlstatement.SqlStatement;
import ecommerce.roles.modelo.entidad.Rol;
import ecommerce.roles.puerto.repositorio.RepositorioRol;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.stereotype.Repository;

@Repository
public class RepositorioRolPostgres implements RepositorioRol {
    private final CustomNamedParameterJdbcTemplate customNamedParameterJdbcTemplate;

    private final MapeoRol mapeoRol;

    public RepositorioRolPostgres(CustomNamedParameterJdbcTemplate customNamedParameterJdbcTemplate, MapeoRol mapeoRol) {
        this.customNamedParameterJdbcTemplate = customNamedParameterJdbcTemplate;
        this.mapeoRol = mapeoRol;
    }

    @SqlStatement(namespace = "roles", value="obtenerporid.sql")
    private static String sqlObtenerRol;
    @SqlStatement(namespace = "roles", value="crearrol")
    private static String sqlCrearRol;

    @Override
    public Long crear(Rol rol) {
        MapSqlParameterSource parameterSource = new MapSqlParameterSource();
        parameterSource.addValue("rol_name",rol.getNombre());
        return this.customNamedParameterJdbcTemplate.crear(parameterSource, sqlCrearRol);
    }

    @Override
    public Rol obtener(Long id) {
        MapSqlParameterSource parameterSource = new MapSqlParameterSource();
        parameterSource.addValue("id", id);
        return EjecucionBaseDeDatos.obtenerUnObjetoONull(()-> this.customNamedParameterJdbcTemplate.
                        getNamedParameterJdbcTemplate().queryForObject(sqlObtenerRol, parameterSource, mapeoRol));
    }
}
