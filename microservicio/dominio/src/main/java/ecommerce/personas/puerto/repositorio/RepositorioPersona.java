package ecommerce.personas.puerto.repositorio;

import ecommerce.personas.modelo.entidad.Persona;

public interface RepositorioPersona {
    Long crear(Persona persona);

    Persona obtener(Long id);

}
