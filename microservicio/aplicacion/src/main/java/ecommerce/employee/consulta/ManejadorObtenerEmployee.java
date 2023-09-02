package ecommerce.employee.consulta;

import ecommerce.employees.modelo.entidad.Employee;
import ecommerce.employees.puerto.dao.DaoEmployee;
import org.springframework.stereotype.Component;

@Component
public class ManejadorObtenerEmployee {
    private final DaoEmployee daoEmployee;

    public ManejadorObtenerEmployee(DaoEmployee daoEmployee) {
        this.daoEmployee = daoEmployee;
    }

    public Employee ejecutar(Long id){
        return this.daoEmployee.getEmployee(id);
    }
}
