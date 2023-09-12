package ecommerce.cliente.consulta;

import ecommerce.cliente.modelo.entidad.Cliente;
import ecommerce.cliente.puerto.dao.DaoCliente;
import org.springframework.stereotype.Component;

@Component
public class ManejadorObtenerCliente {
    private final DaoCliente daoCliente;

    public ManejadorObtenerCliente(DaoCliente daoCliente) {
        this.daoCliente = daoCliente;
    }
    public Cliente getClientById(Long id){
        return this.daoCliente.getClienteById(id);
    }
}
