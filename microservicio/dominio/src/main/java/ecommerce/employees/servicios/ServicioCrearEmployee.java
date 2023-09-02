package ecommerce.employees.servicios;

import ecommerce.employees.modelo.entidad.Employee;
import ecommerce.employees.puerto.repositorio.RepositorioEmployee;

public class ServicioCrearEmployee {
    private final RepositorioEmployee repositorioEmployee;

    public ServicioCrearEmployee(RepositorioEmployee repositorioEmployee) {
        this.repositorioEmployee = repositorioEmployee;
    }

    public Long ejecutar(Employee employee){
        return this.repositorioEmployee.crear(employee);
    }
}
