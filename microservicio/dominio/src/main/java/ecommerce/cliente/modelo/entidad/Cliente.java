package ecommerce.cliente.modelo.entidad;

import ecommerce.dominio.ValidadorArgumento;

public class Cliente {
    private Long idCliente;
    private String nombre;
    private String documento;
    private String numeroTelefonico;
    private String direccion;
    private String email;
    private String contrasena;

    public Cliente(Long idCliente, String nombre, String email, String documento, String direccion, String numeroTelefonico, String contrasena) {
        this.idCliente = idCliente;
        this.nombre = nombre;
        this.email = email;
        this.documento = documento;
        this.direccion = direccion;
        this.numeroTelefonico = numeroTelefonico;
        this.contrasena = contrasena;
    }
    public static Cliente reconstruir(Long idCliente, String nombre, String email, String documento, String direccion, String numeroTelefonico, String contrasena) {
        ValidadorArgumento.validarObligatorio(idCliente, "Debes ingresar un id para la reconstruccion del usuario");
        ValidadorArgumento.validarObligatorio(nombre, "Debes ingresar un nombre para la reconstruccion del usuario");
        ValidadorArgumento.validarObligatorio(email, "Debes ingresar un email para la reconstruccion del usuario");
        ValidadorArgumento.validarObligatorio(documento, "Debes ingresar un documento de identidad para la reconstruccion del usuario");
        ValidadorArgumento.validarObligatorio(direccion, "Debes ingresar una direccion para la reconstruccion del usuario");
        ValidadorArgumento.validarObligatorio(numeroTelefonico, "Debes ingresar un numero telefonico para la reconstruccion del usuario");
        ValidadorArgumento.validarObligatorio(contrasena, "Debes ingresar una contrasena para la reconstruccion del usuario");
        return new Cliente(idCliente, nombre, email, documento, direccion, numeroTelefonico, contrasena);
    }

    public Cliente(String nombre, String email, String documento, String direccion, String numeroTelefonico, String contrasena) {
        this.nombre = nombre;
        this.email = email;
        this.documento = documento;
        this.direccion = direccion;
        this.numeroTelefonico = numeroTelefonico;
        this.contrasena = contrasena;
    }

    public Cliente(String nombre, String documento, String numeroTelefonico, String direccion, String email) {
        this.nombre = nombre;
        this.documento = documento;
        this.numeroTelefonico = numeroTelefonico;
        this.direccion = direccion;
        this.email = email;
    }

    public static Cliente crear(String nombre, String email, String documento, String direccion, String numeroTelefonico, String contrasena) {
        ValidadorArgumento.validarObligatorio(nombre, "Debes ingresar un nombre para la creacion del usuario");
        ValidadorArgumento.validarObligatorio(email, "Debes ingresar un email para la creacion del usuario");
        ValidadorArgumento.validarObligatorio(documento, "Debes ingresar un documento de identidad para la creacion del usuario");
        ValidadorArgumento.validarObligatorio(direccion, "Debes ingresar una direccion para la creacion del usuario");
        ValidadorArgumento.validarObligatorio(numeroTelefonico, "Debes ingresar un numero telefonico para la creacion del usuario");
        ValidadorArgumento.validarObligatorio(contrasena, "Debes ingresar una contrasena para la creacion del usuario");
        return new Cliente(nombre, email, documento, direccion, numeroTelefonico, contrasena);
    }
    public static Cliente actualizar(String nombre, String email, String documento, String direccion, String numeroTelefonico) {
        ValidadorArgumento.validarObligatorio(nombre, "Debes ingresar un nombre para la actualización del usuario");
        ValidadorArgumento.validarObligatorio(email, "Debes ingresar un email para la actualización del usuario");
        ValidadorArgumento.validarObligatorio(documento, "Debes ingresar un documento de identidad para la actualización del usuario");
        ValidadorArgumento.validarObligatorio(direccion, "Debes ingresar una direccion para la actualización del usuario");
        ValidadorArgumento.validarObligatorio(numeroTelefonico, "Debes ingresar un numero telefonico para la actualización del usuario");
        return new Cliente(nombre, email, documento, direccion, numeroTelefonico);
    }


    public Long getIdCliente() {
        return idCliente;
    }

    public String getNombre() {
        return nombre;
    }

    public String getEmail() {
        return email;
    }

    public String getDocumento() {
        return documento;
    }

    public String getDireccion() {
        return direccion;
    }

    public String getNumeroTelefonico() {
        return numeroTelefonico;
    }

    public String getContrasena() {
        return contrasena;
    }
}
