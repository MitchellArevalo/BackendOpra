package ecommerce.personas.adaptador.repositorio;

import ecommerce.infraestructura.jdbc.CustomNamedParameterJdbcTemplate;
import ecommerce.infraestructura.jdbc.EjecucionBaseDeDatos;
import ecommerce.infraestructura.jdbc.sqlstatement.SqlStatement;
import ecommerce.personas.modelo.entidad.Persona;
import ecommerce.personas.puerto.repositorio.RepositorioPersona;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.stereotype.Repository;

@Repository
public class RepositorioPersonaPostgres implements RepositorioPersona {

    private final CustomNamedParameterJdbcTemplate customNamedParameterJdbcTemplate;
    private final MapeoPersona mapeoPersona;

    public RepositorioPersonaPostgres(CustomNamedParameterJdbcTemplate customNamedParameterJdbcTemplate, MapeoPersona mapeoPersona) {
        this.customNamedParameterJdbcTemplate = customNamedParameterJdbcTemplate;
        this.mapeoPersona = mapeoPersona;
    }
    @SqlStatement(namespace = "personas", value = "obtenerporid")
    private static String sqlObtenerPorID;
    @SqlStatement(namespace = "personas", value = "crearpersona")
    private static String sqlCrearPersona;


    @Override
    public Long crear(Persona persona) {
        MapSqlParameterSource parameterSource = new MapSqlParameterSource();
        parameterSource.addValue("persona_avatar", persona.getAvatar());
        parameterSource.addValue("persona_username", persona.getUsername());
        parameterSource.addValue("persona_password", persona.getContrasena());
        parameterSource.addValue("persona_document", persona.getDocumento());
        parameterSource.addValue("persona_name", persona.getNombre());
        parameterSource.addValue("persona_email", persona.getEmail());
        parameterSource.addValue("persona_phone_number", persona.getNumeroTelefonico());
        parameterSource.addValue("rol_id", persona.getRol().getIdRol());
        return this.customNamedParameterJdbcTemplate.crear(parameterSource, sqlCrearPersona);
    }

    @Override
    public Persona obtener(Long id) {
        MapSqlParameterSource parameterSource = new MapSqlParameterSource();
        parameterSource.addValue("id", id);
        return EjecucionBaseDeDatos.obtenerUnObjetoONull(() -> this.customNamedParameterJdbcTemplate
                .getNamedParameterJdbcTemplate().queryForObject(sqlObtenerPorID, parameterSource, mapeoPersona));
    }
}
