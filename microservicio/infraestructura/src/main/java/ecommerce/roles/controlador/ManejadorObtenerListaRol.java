package ecommerce.roles.controlador;

import ecommerce.roles.modelo.entidad.Rol;
import ecommerce.roles.puerto.dao.DaoRol;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ManejadorObtenerListaRol {
    private final DaoRol daoRol;

    public ManejadorObtenerListaRol(DaoRol daoRol) {
        this.daoRol = daoRol;
    }

    public List<Rol> ejecutar(){
        return this.daoRol.obtenerListaDeRoles();
    }
}
