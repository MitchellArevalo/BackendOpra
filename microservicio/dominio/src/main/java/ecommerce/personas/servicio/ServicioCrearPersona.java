package ecommerce.personas.servicio;

import ecommerce.personas.modelo.entidad.Persona;
import ecommerce.personas.puerto.repositorio.RepositorioPersona;

public class ServicioCrearPersona {
    private final RepositorioPersona repositorioPersona;
    public ServicioCrearPersona(RepositorioPersona repositorioPersona) {
        this.repositorioPersona = repositorioPersona;
    }
    public Long ejecutar(Persona persona){
        return this.repositorioPersona.crear(persona);
    }
}
