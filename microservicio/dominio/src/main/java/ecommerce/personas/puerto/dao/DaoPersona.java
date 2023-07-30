package ecommerce.personas.puerto.dao;

import ecommerce.personas.modelo.entidad.Persona;

import java.util.List;

public interface DaoPersona {
    Persona obtenerPersonaPorID(Long id);
    List<Persona> obtenerListaPersonas();
}
