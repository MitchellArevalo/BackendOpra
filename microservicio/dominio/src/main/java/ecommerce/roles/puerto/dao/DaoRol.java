package ecommerce.roles.puerto.dao;

import ecommerce.roles.modelo.entidad.Rol;

import java.util.List;

public interface DaoRol {
    List<Rol> obtenerListaDeRoles();

    Rol obtenerPorID(Long id);
}
