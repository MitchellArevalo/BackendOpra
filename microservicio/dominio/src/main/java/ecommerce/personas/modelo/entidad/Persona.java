package ecommerce.personas.modelo.entidad;

import ecommerce.dominio.ValidadorArgumento;
import ecommerce.roles.modelo.entidad.Rol;

public class Persona {
    private Long idPersona;
    private String avatar;
    private String username;
    private String contrasena;
    private String documento;
    private String nombre;
    private String email;
    private String numeroTelefonico;
    private Rol rol;

    public Persona(Long idPersona,String avatar, String username, String contrasena, String documento, String nombre, String email, String numeroTelefonico, Rol rol) {
        this.idPersona = idPersona;
        this.avatar = avatar;
        this.username = username;
        this.contrasena = contrasena;
        this.documento = documento;
        this.nombre = nombre;
        this.email = email;
        this.numeroTelefonico = numeroTelefonico;
        this.rol = rol;
    }

    public static Persona reconstruir (Long idPersona, String avatar, String username, String contrasena, String documento, String nombre, String email, String numeroTelefonico, Rol rol) {
        ValidadorArgumento.validarObligatorio(idPersona,"Debe ingresar el valor de id de la persona");
        ValidadorArgumento.validarObligatorio(avatar,"Debe ingresar el valor del avatar");
        ValidadorArgumento.validarObligatorio(username,"Debe ingresar el valor de username");
        ValidadorArgumento.validarObligatorio(contrasena,"Debe ingresar el valor de contrasena");
        ValidadorArgumento.validarObligatorio(documento,"Debe ingresar el valor de documento");
        ValidadorArgumento.validarObligatorio(nombre,"Debe ingresar el valor de nombre");
        ValidadorArgumento.validarObligatorio(email,"Debe ingresar el valor de email");
        ValidadorArgumento.validarObligatorio(numeroTelefonico,"Debe ingresar el valor de numero telefonico ");
        ValidadorArgumento.validarObligatorio(rol,"Debe ingresar el valor de rol");
        return new Persona(idPersona, avatar, username, contrasena, documento, nombre, email, numeroTelefonico, rol);
    }

    public Persona(String avatar, String username, String contrasena, String documento, String nombre, String email, String numeroTelefonico, Rol rol) {
        this.avatar = avatar;
        this.username = username;
        this.contrasena = contrasena;
        this.documento = documento;
        this.nombre = nombre;
        this.email = email;
        this.numeroTelefonico = numeroTelefonico;
        this.rol = rol;
    }

    public static Persona crear(String avatar, String username, String contrasena, String documento, String nombre, String email, String numeroTelefonico, Rol rol) {
        ValidadorArgumento.validarObligatorio(avatar,"Debe ingresar el valor del avatar");
        ValidadorArgumento.validarObligatorio(username,"Debe ingresar el valor de username");
        ValidadorArgumento.validarObligatorio(contrasena,"Debe ingresar el valor de contrasena");
        ValidadorArgumento.validarObligatorio(documento,"Debe ingresar el valor de documento");
        ValidadorArgumento.validarObligatorio(nombre,"Debe ingresar el valor de nombre");
        ValidadorArgumento.validarObligatorio(email,"Debe ingresar el valor de email");
        ValidadorArgumento.validarObligatorio(numeroTelefonico,"Debe ingresar el valor de numero telefonico ");
        ValidadorArgumento.validarObligatorio(rol,"Debe ingresar el valor de rol");
        return new Persona(avatar, username, contrasena, documento, nombre, email, numeroTelefonico, rol);
    }

    public Long getIdPersona() {
        return idPersona;
    }

    public String getUsername() {
        return username;
    }

    public String getContrasena() {
        return contrasena;
    }

    public String getDocumento() {
        return documento;
    }

    public String getNombre() {
        return nombre;
    }

    public String getAvatar() {
        return avatar;
    }

    public String getEmail() {
        return email;
    }

    public String getNumeroTelefonico() {
        return numeroTelefonico;
    }

    public Rol getRol() {
        return rol;
    }
}
