package ecommerce.roles.modelo.entidad;

import ecommerce.dominio.ValidadorArgumento;

public class Rol {
    private Long idRol;
    private String nombre;

    public Rol(Long idRol, String nombre) {
        this.idRol = idRol;
        this.nombre = nombre;
    }
    public static Rol reconstruir(Long idRol, String nombre) {
        ValidadorArgumento.validarObligatorio(idRol, "Debes ingresar un id del rol");
        ValidadorArgumento.validarObligatorio(nombre, "Debes ingresar un nombre");
        return new Rol(idRol, nombre);
    }

    public Rol(String nombre) {
        this.nombre = nombre;
    }

    public static Rol crear(String nombre) {
        ValidadorArgumento.validarObligatorio(nombre, "Debes ingresar un nombre");
        return new Rol(nombre);
    }

    public Long getIdRol() {
        return idRol;
    }

    public String getNombre() {
        return nombre;
    }
}
