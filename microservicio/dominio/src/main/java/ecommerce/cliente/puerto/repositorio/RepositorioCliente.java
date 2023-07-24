package ecommerce.cliente.puerto.repositorio;

import ecommerce.cliente.modelo.entidad.Cliente;

public interface RepositorioCliente {
    Long crear(Cliente cliente);
}
