package ecommerce.employee.comando.fabrica;

import ecommerce.employee.comando.ComandoSolicitudCrearEmployee;
import ecommerce.employees.modelo.entidad.Employee;
import ecommerce.roles.modelo.entidad.Rol;
import ecommerce.roles.puerto.repositorio.RepositorioRol;
import org.springframework.stereotype.Component;

@Component
public class GenerarSolicitudCrearEmployee {
    private final RepositorioRol repositorioRol;

    public GenerarSolicitudCrearEmployee(RepositorioRol repositorioRol) {
        this.repositorioRol = repositorioRol;
    }

    private Rol obtenerRol(Long id){
        return repositorioRol.obtener(id);
    }

    public Employee crear(ComandoSolicitudCrearEmployee comandoSolicitudCrearEmployee){
        return Employee.crear(
                obtenerRol(comandoSolicitudCrearEmployee.getIdRol()),
                comandoSolicitudCrearEmployee.getName(),
                comandoSolicitudCrearEmployee.getEmail(),
                comandoSolicitudCrearEmployee.getContrasena(),
                comandoSolicitudCrearEmployee.getDocumento(),
                comandoSolicitudCrearEmployee.getDireccion(),
                comandoSolicitudCrearEmployee.getNumeroTelefonico(),
                comandoSolicitudCrearEmployee.getAvatar()
        );
    }
}
