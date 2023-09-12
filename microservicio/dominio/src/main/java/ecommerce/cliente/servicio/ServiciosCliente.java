package ecommerce.cliente.servicio;

import ecommerce.cliente.modelo.entidad.Cliente;
import ecommerce.cliente.puerto.repositorio.RepositorioCliente;

public class ServiciosCliente {
    private final RepositorioCliente repositorioCliente;

    public ServiciosCliente(RepositorioCliente repositorioCliente) {
        this.repositorioCliente = repositorioCliente;
    }

    public Long crear(Cliente cliente){
        return this.repositorioCliente.crear(cliente);
    }
    public void update(Cliente cliente, Long id){
        this.repositorioCliente.update(cliente, id);
    }
    public void delete(Long id){
        this.repositorioCliente.delete(id);
    }
    public Cliente autenticar(String email, String password){
        return this.repositorioCliente.autenticar(email, password);
    }
}
