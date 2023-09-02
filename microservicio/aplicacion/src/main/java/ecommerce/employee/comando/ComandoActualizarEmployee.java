package ecommerce.employee.comando;

import ecommerce.roles.modelo.entidad.Rol;
import org.springframework.stereotype.Component;

@Component
public class ComandoActualizarEmployee {
    Long idRol;
    String name;
    String email;
    String password;
    String document;
    String address;
    String phoneNumber;
    String avatar;
    boolean active;
    boolean notificationsEmail;
}
