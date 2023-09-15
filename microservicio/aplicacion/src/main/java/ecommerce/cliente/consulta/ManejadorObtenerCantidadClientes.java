package ecommerce.cliente.consulta;

import ecommerce.cliente.puerto.dao.DaoCliente;
import org.springframework.stereotype.Component;

@Component
public class ManejadorObtenerCantidadClientes {
    private final DaoCliente daoCliente;

    public ManejadorObtenerCantidadClientes(DaoCliente daoCliente) {
        this.daoCliente = daoCliente;
    }

    public Long ejecutar(){
        return this.daoCliente.getTotalClients();
    }
}
