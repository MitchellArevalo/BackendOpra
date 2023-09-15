package ecommerce.employees.puerto.repositorio;

import ecommerce.employees.modelo.entidad.Employee;

public interface RepositorioEmployee {
    Long crear(Employee employee);

    void update(Employee employee, Long id);

    Employee autenticar(String email);

    void delete(Long id);
}
