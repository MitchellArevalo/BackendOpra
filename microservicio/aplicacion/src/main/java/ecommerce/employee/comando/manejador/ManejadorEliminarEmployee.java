package ecommerce.employee.comando.manejador;

import ecommerce.employees.puerto.repositorio.RepositorioEmployee;
import org.springframework.stereotype.Component;

@Component
public class ManejadorEliminarEmployee {
    private final RepositorioEmployee repositorioEmployee;

    public ManejadorEliminarEmployee(RepositorioEmployee repositorioEmployee) {
        this.repositorioEmployee = repositorioEmployee;
    }

    public void eliminar(Long id){
        repositorioEmployee.delete(id);
    }
}
