package ecommerce.employee.comando.fabrica;

import ecommerce.employee.comando.ComandoActualizarEmployee;
import ecommerce.employees.modelo.entidad.Employee;
import ecommerce.roles.modelo.entidad.Rol;
import ecommerce.roles.puerto.repositorio.RepositorioRol;
import org.springframework.stereotype.Component;

@Component
public class GenerarSolicitudActualizarEmployee {
    private final RepositorioRol repositorioRol;

    public GenerarSolicitudActualizarEmployee(RepositorioRol repositorioRol) {
        this.repositorioRol = repositorioRol;
    }

    private Rol obtenerRol(Long id){
        return repositorioRol.obtener(id);
    }

    public Employee actualizar(ComandoActualizarEmployee comandoActualizarEmployee
    ){
        return Employee.actualizar(
                obtenerRol(comandoActualizarEmployee.getIdRol()),
                comandoActualizarEmployee.getName(),
                comandoActualizarEmployee.getEmail(),
                comandoActualizarEmployee.getDocument(),
                comandoActualizarEmployee.getAddress(),
                comandoActualizarEmployee.getPhoneNumber(),
                comandoActualizarEmployee.getAvatar(),
                comandoActualizarEmployee.isActive(),
                comandoActualizarEmployee.isNotificationsEmail()
        );
    }
}
