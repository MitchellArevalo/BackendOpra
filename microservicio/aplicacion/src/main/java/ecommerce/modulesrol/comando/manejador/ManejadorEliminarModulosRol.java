package ecommerce.modulesrol.comando.manejador;

import ecommerce.modulesrol.servicio.ServiciosModulesRol;
import org.springframework.stereotype.Component;

@Component
public class ManejadorEliminarModulosRol {
    private final ServiciosModulesRol serviciosModulesRol;

    public ManejadorEliminarModulosRol(ServiciosModulesRol serviciosModulesRol) {
        this.serviciosModulesRol = serviciosModulesRol;
    }



}
