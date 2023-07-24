package ecommerce.cliente.comando;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ComandoSolicitudCrearCliente {
    private String nombre;
    private String email;
    private String documento;
    private String direccion;
    private String numeroTelefonico;
    private String username;
    private String contrasena;
}
