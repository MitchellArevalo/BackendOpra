package ecommerce.employees.puerto.dao;

import ecommerce.employees.modelo.entidad.Employee;

import java.util.List;

public interface DaoEmployee {
    Employee getEmployee(Long id);
    ecommerce.employees.modelo.dto.DataDTOEmployee getDTOEmployee(Long id);
    List<Employee> getListEmployees();

}
