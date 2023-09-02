package ecommerce.employee.comando;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ComandoActualizarEmployee {
    Long idRol;
    String name;
    String email;
    String document;
    String address;
    String phoneNumber;
    String avatar;
    boolean active;
    boolean notificationsEmail;
}
