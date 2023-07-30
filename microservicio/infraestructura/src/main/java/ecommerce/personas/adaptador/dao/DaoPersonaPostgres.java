package ecommerce.personas.adaptador.dao;

import ecommerce.infraestructura.jdbc.CustomNamedParameterJdbcTemplate;
import ecommerce.infraestructura.jdbc.EjecucionBaseDeDatos;
import ecommerce.infraestructura.jdbc.sqlstatement.SqlStatement;
import ecommerce.personas.adaptador.repositorio.MapeoPersona;
import ecommerce.personas.modelo.entidad.Persona;
import ecommerce.personas.puerto.dao.DaoPersona;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class DaoPersonaPostgres implements DaoPersona {
    private final CustomNamedParameterJdbcTemplate customNamedParameterJdbcTemplate;
    private final MapeoPersona mapeoPersona;

    public DaoPersonaPostgres(CustomNamedParameterJdbcTemplate customNamedParameterJdbcTemplate, MapeoPersona mapeoPersona) {
        this.customNamedParameterJdbcTemplate = customNamedParameterJdbcTemplate;
        this.mapeoPersona = mapeoPersona;
    }
    //region SQLSTATEMENTS
    @SqlStatement(namespace = "personas", value = "obtenerlistapersona")
    private static String sqlObtenerListaPersonas;
    @SqlStatement(namespace = "personas", value = "obtenerporid")
    private static String sqlObtenerPersona;
    //endregion



    @Override
    public Persona obtenerPersonaPorID(Long id) {
        MapSqlParameterSource parameterSource = new MapSqlParameterSource();
        parameterSource.addValue("id", id);
        return EjecucionBaseDeDatos.obtenerUnObjetoONull(() -> this.customNamedParameterJdbcTemplate
                .getNamedParameterJdbcTemplate().queryForObject(sqlObtenerPersona, parameterSource, mapeoPersona));
    }

    @Override
    public List<Persona> obtenerListaPersonas() {
        return this.customNamedParameterJdbcTemplate.getNamedParameterJdbcTemplate().query(sqlObtenerListaPersonas, mapeoPersona);
    }
}
