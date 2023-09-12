package ecommerce.cliente.comando;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ComandoSolicitudActualizarCliente {
    private String name;
    private String email;
    private String document;
    private String address;
    private String phoneNumber;
}
