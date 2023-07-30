package ecommerce.modulos.modelo.entidad;

import ecommerce.dominio.ValidadorArgumento;

public class Modulo {
    private Long idModulo;
    private String nombre;
    private boolean permiso;

    public Modulo(Long idModulo, String nombre, boolean permiso) {
        this.idModulo = idModulo;
        this.nombre = nombre;
        this.permiso = permiso;
    }
    public Modulo reconstruir(Long idModulo, String nombre, boolean permiso) {
        ValidadorArgumento.validarObligatorio(idModulo, "Debes ingresar un id del modulo");
        ValidadorArgumento.validarObligatorio(nombre, "Debes ingresar un nombre");
        ValidadorArgumento.validarObligatorio(permiso, "Debes ingresar true o false");
        return new Modulo(idModulo, nombre, permiso);
    }
    public Modulo(String nombre, boolean permiso) {
        this.nombre = nombre;
        this.permiso = permiso;
    }

    public Modulo crear(String nombre, boolean permiso) {
        ValidadorArgumento.validarObligatorio(nombre, "Debes ingresar un nombre");
        ValidadorArgumento.validarObligatorio(permiso, "Debes ingresar true o false");
        return new Modulo(nombre, permiso);
    }

    public Long getIdModulo() {
        return idModulo;
    }

    public String getNombre() {
        return nombre;
    }

    public boolean isPermiso() {
        return permiso;
    }
}
