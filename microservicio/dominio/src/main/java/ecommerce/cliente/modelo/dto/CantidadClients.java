package ecommerce.cliente.modelo.dto;

public class CantidadClients {
    private Long cantidadTotalClientes;

    public CantidadClients(Long cantidadTotalClientes) {
        this.cantidadTotalClientes = cantidadTotalClientes;
    }

    public Long getCantidadTotalClientes() {
        return cantidadTotalClientes;
    }
}
