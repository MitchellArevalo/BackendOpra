package ecommerce.cliente.puerto.repositorio;

import ecommerce.cliente.modelo.entidad.Cliente;

public interface RepositorioCliente {
    Long crear(Cliente cliente);
    void delete(Long id);

    void update(Cliente cliente, Long idCliente);
}
