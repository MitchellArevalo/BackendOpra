package ecommerce.modulos.puerto.dao;

import ecommerce.modulos.modelo.entidad.Modulo;

import java.util.List;

public interface DaoModule {
    List<Modulo> getAllModules();
    Modulo getByID(Long id);
}
