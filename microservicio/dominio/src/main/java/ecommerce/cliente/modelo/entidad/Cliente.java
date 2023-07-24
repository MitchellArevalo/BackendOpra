package ecommerce.cliente.modelo.entidad;

import ecommerce.dominio.ValidadorArgumento;

public class Cliente {
    private Long idCliente;
    private String nombre;
    private String email;
    private String documento;
    private String direccion;
    private String numeroTelefonico;
    private String username;
    private String contrasena;

    public Cliente(Long idCliente, String nombre, String email, String documento, String direccion, String numeroTelefonico, String username, String contrasena) {
        this.idCliente = idCliente;
        this.nombre = nombre;
        this.email = email;
        this.documento = documento;
        this.direccion = direccion;
        this.numeroTelefonico = numeroTelefonico;
        this.username = username;
        this.contrasena = contrasena;
    }

    public Cliente(String nombre, String email, String documento, String direccion, String numeroTelefonico, String username, String contrasena) {
        this.nombre = nombre;
        this.email = email;
        this.documento = documento;
        this.direccion = direccion;
        this.numeroTelefonico = numeroTelefonico;
        this.username = username;
        this.contrasena = contrasena;
    }

    public static Cliente crear(String nombre, String email, String documento, String direccion, String numeroTelefonico, String username, String contrasena) {
        ValidadorArgumento.validarObligatorio(nombre, "Debes ingresar un nombre para la creacion del usuario");
        ValidadorArgumento.validarObligatorio(email, "Debes ingresar un email para la creacion del usuario");
        ValidadorArgumento.validarObligatorio(documento, "Debes ingresar un documento de identidad para la creacion del usuario");
        ValidadorArgumento.validarObligatorio(direccion, "Debes ingresar una direccion para la creacion del usuario");
        ValidadorArgumento.validarObligatorio(numeroTelefonico, "Debes ingresar un numero telefonico para la creacion del usuario");
        ValidadorArgumento.validarObligatorio(username, "Debes ingresar un username para la creacion del usuario");
        ValidadorArgumento.validarObligatorio(contrasena, "Debes ingresar una contrasena para la creacion del usuario");
        return new Cliente(nombre, email, documento, direccion, numeroTelefonico, username, contrasena);
    }


    public Long getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(Long idCliente) {
        this.idCliente = idCliente;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getDocumento() {
        return documento;
    }

    public void setDocumento(String documento) {
        this.documento = documento;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getNumeroTelefonico() {
        return numeroTelefonico;
    }

    public void setNumeroTelefonico(String numeroTelefonico) {
        this.numeroTelefonico = numeroTelefonico;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getContrasena() {
        return contrasena;
    }

    public void setContrasena(String contrasena) {
        this.contrasena = contrasena;
    }
}
