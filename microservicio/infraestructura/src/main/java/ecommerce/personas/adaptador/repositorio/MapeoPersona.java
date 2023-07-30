package ecommerce.personas.adaptador.repositorio;

import ecommerce.infraestructura.jdbc.MapperResult;
import ecommerce.personas.modelo.entidad.Persona;
import ecommerce.roles.modelo.entidad.Rol;
import ecommerce.roles.puerto.repositorio.RepositorioRol;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import java.sql.ResultSet;
import java.sql.SQLException;


@Component
public class MapeoPersona implements RowMapper<Persona>, MapperResult {
    private final RepositorioRol repositorioRol;

    public MapeoPersona(RepositorioRol repositorioRol) {
        this.repositorioRol = repositorioRol;
    }
    private Rol obtenerRol(Long id){
        return this.repositorioRol.obtener(id);
    }

    @Override
    public Persona mapRow(ResultSet rs, int rowNum) throws SQLException {
        Long id = rs.getLong("id");
        String avatar = rs.getString("persona_avatar");
        String username = rs.getString("persona_username");
        String password = rs.getString("persona_password");
        String document = rs.getString("persona_document");
        String name = rs.getString("persona_name");
        String email = rs.getString("persona_email");
        String numeroTelefonico = rs.getString("persona_phone_number");
        Long rolId = rs.getLong("rol_id");
        return Persona.reconstruir(id,avatar, username,password,document,name,email,numeroTelefonico,obtenerRol(rolId));
    }
}
