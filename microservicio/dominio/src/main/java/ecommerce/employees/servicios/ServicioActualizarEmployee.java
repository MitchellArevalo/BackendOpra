package ecommerce.employees.servicios;

import ecommerce.employees.modelo.entidad.Employee;
import ecommerce.employees.puerto.repositorio.RepositorioEmployee;

public class ServicioActualizarEmployee {
    private final RepositorioEmployee repositorioEmployee;

    public ServicioActualizarEmployee(RepositorioEmployee repositorioEmployee) {
        this.repositorioEmployee = repositorioEmployee;
    }

    public void ejecutar(Employee employee, Long id){
        this.repositorioEmployee.update(employee, id);
    }
}
