package ecommerce.cliente.consulta;

import ecommerce.cliente.modelo.entidad.Cliente;
import ecommerce.cliente.puerto.dao.DaoCliente;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ManejadorObtenerListaClientes {
    private final DaoCliente daoCliente;

    public ManejadorObtenerListaClientes(DaoCliente daoCliente) {
        this.daoCliente = daoCliente;
    }

    public List<Cliente> getAllClients(){
        return this.daoCliente.getAllClients();
    }
}
