package ecommerce.roles.consulta;

import ecommerce.roles.modelo.entidad.Rol;
import ecommerce.roles.puerto.dao.DaoRol;
import org.springframework.stereotype.Component;

@Component
public class ManejadorObtenerRol {
    private final DaoRol daoRol;

    public ManejadorObtenerRol(DaoRol daoRol) {
        this.daoRol = daoRol;
    }

    public Rol ejecutar(Long id){
        return this.daoRol.obtenerPorID(id);
    }
}
