package ecommerce.modulos.puerto.repositorio;

import ecommerce.modulos.modelo.entidad.Modulo;

public interface RepositorioModule {
    Long crear(Modulo module);
    void update(Modulo modulo);
}
