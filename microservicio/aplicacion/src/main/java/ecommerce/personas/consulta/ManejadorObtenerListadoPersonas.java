package ecommerce.personas.consulta;

import ecommerce.personas.modelo.entidad.Persona;
import ecommerce.personas.puerto.dao.DaoPersona;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ManejadorObtenerListadoPersonas {
    private final DaoPersona daoPersona;

    public ManejadorObtenerListadoPersonas(DaoPersona daoPersona) {
        this.daoPersona = daoPersona;
    }

    public List<Persona> ejecutar(){
        return daoPersona.obtenerListaPersonas();
    }
}
