package ecommerce.cliente.modelo.dto;

import ecommerce.dominio.ValidadorArgumento;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class ClienteDTO {
    private Long idCliente;
    private String nombre;
    private String documento;
    private String direccion;
    private String email;

    public ClienteDTO(Long idCliente, String nombre, String documento, String direccion, String email) {
        this.idCliente = idCliente;
        this.nombre = nombre;
        this.documento = documento;
        this.direccion = direccion;
        this.email = email;
    }

    public ClienteDTO reconstruir(Long idCliente, String nombre, String documento, String direccion, String email) {
        ValidadorArgumento.validarObligatorio(idCliente, "Debes ingresar un id para la reconstruccion del usuario");
        ValidadorArgumento.validarObligatorio(nombre, "Debes ingresar un nombre para la reconstruccion del usuario");
        ValidadorArgumento.validarObligatorio(email, "Debes ingresar un email para la reconstruccion del usuario");
        ValidadorArgumento.validarObligatorio(documento, "Debes ingresar un documento de identidad para la reconstruccion del usuario");
        ValidadorArgumento.validarObligatorio(direccion, "Debes ingresar una direccion para la reconstruccion del usuario");
        return new ClienteDTO(idCliente, nombre, email, documento, direccion);
    }
}
