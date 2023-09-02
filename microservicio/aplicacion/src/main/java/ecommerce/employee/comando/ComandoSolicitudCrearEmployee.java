package ecommerce.employee.comando;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ComandoSolicitudCrearEmployee {
    private String avatar;
    private String name;
    private String email;
    private String contrasena;
    private String documento;
    private String direccion;
    private String numeroTelefonico;
    private Long idRol;
}
