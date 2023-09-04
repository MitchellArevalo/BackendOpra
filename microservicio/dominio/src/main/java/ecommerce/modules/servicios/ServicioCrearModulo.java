package ecommerce.modules.servicios;

import ecommerce.modules.modelo.entidad.Modulo;
import ecommerce.modules.puerto.repositorio.RepositorioModule;

public class ServicioCrearModulo {
    private final RepositorioModule repositorioModule;

    public ServicioCrearModulo(RepositorioModule repositorioModule) {
        this.repositorioModule = repositorioModule;
    }

    public Long ejecutar(Modulo module){
        return this.repositorioModule.crear(module);
    }
}
