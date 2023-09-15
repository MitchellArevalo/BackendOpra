package ecommerce.sales.comando.fabrica;

import ecommerce.cliente.modelo.entidad.Cliente;
import ecommerce.cliente.puerto.dao.DaoCliente;
import ecommerce.employees.modelo.dto.DataDTOEmployee;
import ecommerce.employees.modelo.entidad.Employee;
import ecommerce.employees.puerto.dao.DaoEmployee;
import ecommerce.sales.comando.ComandoSolicitudCrearSale;
import ecommerce.sales.modelo.entidad.Sale;
import org.springframework.stereotype.Component;

@Component
public class GenerarSolicitudCrearSale {
    private final DaoCliente daoCliente;
    private final DaoEmployee daoEmployee;

    public GenerarSolicitudCrearSale(DaoCliente daoCliente, DaoEmployee daoEmployee) {
        this.daoCliente = daoCliente;
        this.daoEmployee = daoEmployee;
    }

    private Cliente obtenerCliente(Long id){
        return this.daoCliente.getClienteById(id);
    }

    private DataDTOEmployee obtenerEmpleado(Long id){
        return this.daoEmployee.getDTOEmployee(id);
    }

    public Sale generar(ComandoSolicitudCrearSale comandoSolicitudCrearSale){
        return Sale.crear(obtenerEmpleado(comandoSolicitudCrearSale.getIdEmployee()), obtenerCliente(comandoSolicitudCrearSale.getIdCliente()),
                comandoSolicitudCrearSale.getTipoVenta());
    }

}
