package ecommerce.employees.modelo.dto;

import ecommerce.dominio.ValidadorArgumento;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;

public class DataDTOEmployee implements UserDetails {
    private Long idEmployee;
    private String name;
    private String email;
    private String document;
    private String address;

    public DataDTOEmployee(Long idEmployee, String name, String email, String document, String address) {
        this.idEmployee = idEmployee;
        this.name = name;
        this.email = email;
        this.document = document;
        this.address = address;
    }

    public static DataDTOEmployee reconstruir(Long idEmployee, String name, String email, String document, String address){
        ValidadorArgumento.validarObligatorio(idEmployee, "Debes ingresar el id del empleado para reconstruir");
        ValidadorArgumento.validarObligatorio(name, "Debes ingresar el name del empleado para reconstruir");
        ValidadorArgumento.validarObligatorio(email, "Debes ingresar el email del empleado para reconstruir");
        ValidadorArgumento.validarObligatorio(document, "Debes ingresar el document del empleado para reconstruir");
        ValidadorArgumento.validarObligatorio(address, "Debes ingresar el address del empleado para reconstruir");
        return new DataDTOEmployee(idEmployee, name, email, document, address);
    }


    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return null;
    }

    @Override
    public String getPassword() {
        return null;
    }

    @Override
    public String getUsername() {
        return email;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}
