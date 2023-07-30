package ecommerce.personas.consulta;

import ecommerce.personas.modelo.entidad.Persona;
import ecommerce.personas.puerto.dao.DaoPersona;
import org.springframework.stereotype.Component;

@Component
public class ManejadorObtenerPersona {
    private final DaoPersona daoPersona;

    public ManejadorObtenerPersona(DaoPersona daoPersona) {
        this.daoPersona = daoPersona;
    }

    public Persona ejecutar(Long id){
        return daoPersona.obtenerPersonaPorID(id);
    }
}
