package ecommerce.cliente.servicio;

import ecommerce.cliente.modelo.entidad.Cliente;
import ecommerce.cliente.puerto.repositorio.RepositorioCliente;

public class ServicioCrearCliente {
    private final RepositorioCliente repositorioCliente;

    public ServicioCrearCliente(RepositorioCliente repositorioCliente) {
        this.repositorioCliente = repositorioCliente;
    }

    public Long ejecutar(Cliente cliente){
        return this.repositorioCliente.crear(cliente);
    }
}
