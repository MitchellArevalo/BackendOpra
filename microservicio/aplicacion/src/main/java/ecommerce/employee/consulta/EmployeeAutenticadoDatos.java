package ecommerce.employee.consulta;

import ecommerce.roles.modelo.entidad.Rol;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class EmployeeAutenticadoDatos {
    private String token;
    private Long idEmployee;
    private String name;
    private String email;
    private String password;
    private String document;
    private String address;
    private String phoneNumber;
}
