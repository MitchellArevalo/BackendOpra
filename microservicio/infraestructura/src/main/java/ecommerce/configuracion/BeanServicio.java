package ecommerce.configuracion;
import ecommerce.cliente.puerto.repositorio.RepositorioCliente;
import ecommerce.cliente.servicio.ServicioCrearCliente;
import ecommerce.employees.puerto.repositorio.RepositorioEmployee;
import ecommerce.employees.servicios.ServicioActualizarEmployee;
import ecommerce.employees.servicios.ServicioCrearEmployee;
import ecommerce.modules.puerto.repositorio.RepositorioModule;
import ecommerce.modules.servicios.ServicioCrearModulo;
import ecommerce.modulesrol.puerto.repositorio.RepositorioModulesRol;
import ecommerce.modulesrol.servicio.ServiciosModulesRol;
import ecommerce.notifications.puerto.repositorio.RepositorioNotification;
import ecommerce.notifications.servicio.ServiciosNotifications;
import ecommerce.personas.puerto.repositorio.RepositorioPersona;
import ecommerce.personas.servicio.ServicioCrearPersona;
import ecommerce.roles.puerto.repositorio.RepositorioRol;
import ecommerce.roles.servicio.ServicioCrearRol;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BeanServicio {
    //region Cliente
    @Bean
    public ServicioCrearCliente servicioCrearCliente (RepositorioCliente repositorioCliente){
        return new ServicioCrearCliente(repositorioCliente);
    }
    //endregion

    @Bean
    public ServicioCrearRol servicioCrearRol(RepositorioRol repositorioRol){
        return new ServicioCrearRol(repositorioRol);
    }

    @Bean
    public ServicioCrearPersona servicioCrearPersona(RepositorioPersona repositorioPersona){
        return new ServicioCrearPersona(repositorioPersona);
    }
    @Bean
    public ServicioCrearEmployee servicioCrearEmployee(RepositorioEmployee repositorioEmployee){
        return new ServicioCrearEmployee(repositorioEmployee);
    }

    @Bean
    public ServicioActualizarEmployee servicioActualizarEmployee(RepositorioEmployee repositorioEmployee){
        return new ServicioActualizarEmployee(repositorioEmployee);
    }

    @Bean
    public ServicioCrearModulo servicioCrearModulo(RepositorioModule repositorioModule){
        return new ServicioCrearModulo(repositorioModule);
    }
    @Bean
    public ServiciosNotifications serviciosNotifications(RepositorioNotification repositorioNotification){
        return new ServiciosNotifications(repositorioNotification);
    }
    @Bean
    public ServiciosModulesRol serviciosModulesRol(RepositorioModulesRol repositorioModulesRol){
        return new ServiciosModulesRol(repositorioModulesRol);
    }
}
