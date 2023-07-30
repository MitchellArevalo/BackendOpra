package ecommerce.personas.comando;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ComandoSolicitudCrearPersona {
    private String avatar;
    private String username;
    private String contrasena;
    private String documento;
    private String nombre;
    private String email;
    private String numeroTelefonico;
    private Long idRol;
}
