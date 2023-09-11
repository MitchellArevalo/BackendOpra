package ecommerce.modulesrol.modelo.entidad;

import ecommerce.dominio.ValidadorArgumento;
import ecommerce.modules.modelo.entidad.Modulo;
import ecommerce.roles.modelo.entidad.Rol;

public class ModulesRol {


    private Long idModulosRol;
    private final Modulo modulo;
    private final Rol rol;

    public ModulesRol(Long idModulosRol, Modulo modulo, Rol rol) {
        this.idModulosRol = idModulosRol;
        this.modulo = modulo;
        this.rol = rol;
    }

    public static ModulesRol reconstruir(Long idModulo, Modulo modulo, Rol rol) {
        ValidadorArgumento.validarObligatorio(idModulo, "Debes ingresar el Modulo para reconstruir");
        ValidadorArgumento.validarObligatorio(modulo, "Debes ingresar el Rol para reconstruir");
        ValidadorArgumento.validarObligatorio(rol, "Debes ingresar el Rol para reconstruir");
        return new ModulesRol(idModulo, modulo, rol);
    }

    public ModulesRol(Modulo modulo, Rol rol) {
        this.modulo = modulo;
        this.rol = rol;
    }
    public static ModulesRol crear(Modulo modulo, Rol rol) {
        ValidadorArgumento.validarObligatorio(modulo, "No se encuentra el id del modulo a agregar");
        ValidadorArgumento.validarObligatorio(rol, "No se encuentra el id del rol");
        return new ModulesRol(modulo, rol);
    }

    public Long getIdModulosRol() {
        return idModulosRol;
    }


    public Modulo getModulo() {
        return modulo;
    }

    public Rol getRol() {
        return rol;
    }
}
