package ecommerce.modules.puerto.dao;

import ecommerce.modules.modelo.entidad.Modulo;

import java.util.List;

public interface DaoModule {
    List<Modulo> getAllModules();
    Modulo getByID(Long id);
}
