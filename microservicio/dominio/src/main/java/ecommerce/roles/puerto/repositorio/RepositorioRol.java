package ecommerce.roles.puerto.repositorio;

import ecommerce.roles.modelo.entidad.Rol;

public interface RepositorioRol {
    Long crear(Rol rol);
    Rol obtener(Long id);
}
