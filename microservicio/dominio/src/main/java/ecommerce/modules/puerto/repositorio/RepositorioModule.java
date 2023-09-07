package ecommerce.modules.puerto.repositorio;

import ecommerce.modules.modelo.entidad.Modulo;

public interface RepositorioModule {
    Long crear(Modulo module);
    void update(Modulo modulo, Long id);
    void delete(Long id);
}
