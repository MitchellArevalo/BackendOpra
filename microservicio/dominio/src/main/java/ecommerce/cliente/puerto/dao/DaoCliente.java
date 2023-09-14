package ecommerce.cliente.puerto.dao;

import ecommerce.cliente.modelo.entidad.Cliente;

import java.util.List;

public interface DaoCliente {
    List<Cliente> getAllClients();
    Cliente getClienteById(Long id);
}
