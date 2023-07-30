package ecommerce.personas.comando.fabrica;

import ecommerce.personas.comando.ComandoSolicitudCrearPersona;
import ecommerce.personas.modelo.entidad.Persona;
import ecommerce.roles.modelo.entidad.Rol;
import ecommerce.roles.puerto.repositorio.RepositorioRol;
import org.springframework.stereotype.Component;

@Component
public class GenerarSolicitudCrearPersona {
    private final RepositorioRol repositorioRol;

    public GenerarSolicitudCrearPersona(RepositorioRol repositorioRol) {
        this.repositorioRol = repositorioRol;
    }

    private Rol obtenerRol(Long id){
        return this.repositorioRol.obtener(id);
    }

    public Persona crear (ComandoSolicitudCrearPersona comandoSolicitudCrearPersona){
        return Persona.crear(comandoSolicitudCrearPersona.getAvatar(),
                comandoSolicitudCrearPersona.getUsername(),
                comandoSolicitudCrearPersona.getContrasena(),
                comandoSolicitudCrearPersona.getDocumento(),
                comandoSolicitudCrearPersona.getNombre(),
                comandoSolicitudCrearPersona.getEmail(),
                comandoSolicitudCrearPersona.getNumeroTelefonico(),
                obtenerRol(comandoSolicitudCrearPersona.getIdRol())
                );
    }

}
