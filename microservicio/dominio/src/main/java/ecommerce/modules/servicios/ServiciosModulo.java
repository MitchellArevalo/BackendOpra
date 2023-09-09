package ecommerce.modules.servicios;

import ecommerce.modules.modelo.entidad.Modulo;
import ecommerce.modules.puerto.repositorio.RepositorioModule;

public class ServiciosModulo {
    private final RepositorioModule repositorioModule;
    public ServiciosModulo(RepositorioModule repositorioModule) {
        this.repositorioModule = repositorioModule;
    }

    public void actualizar(Modulo modulo, Long id){
        this.repositorioModule.update(modulo, id);
    }

    public void eliminar(Long id){
        this.repositorioModule.delete(id);
    }


}
