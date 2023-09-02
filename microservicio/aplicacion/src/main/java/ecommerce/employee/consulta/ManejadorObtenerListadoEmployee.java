package ecommerce.employee.consulta;

import ecommerce.employees.modelo.entidad.Employee;
import ecommerce.employees.puerto.dao.DaoEmployee;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ManejadorObtenerListadoEmployee {
    private final DaoEmployee daoEmployee;

    public ManejadorObtenerListadoEmployee(DaoEmployee daoEmployee) {
        this.daoEmployee = daoEmployee;
    }

    public List<Employee> ejecutar(){
        return daoEmployee.getListEmployees();
    }
}
