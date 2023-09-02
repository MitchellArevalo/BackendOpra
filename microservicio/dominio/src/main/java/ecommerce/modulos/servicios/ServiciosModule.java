package ecommerce.modulos.servicios;

import ecommerce.modulos.modelo.entidad.Modulo;
import ecommerce.modulos.puerto.repositorio.RepositorioModule;

public class ServiciosModule {
    private final RepositorioModule repositorioModule;

    public ServiciosModule(RepositorioModule repositorioModule) {
        this.repositorioModule = repositorioModule;
    }

    public Long crear(Modulo module){
        return repositorioModule.crear(module);
    }
}
