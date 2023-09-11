package ecommerce.configuracion;
import ecommerce.category.puerto.repositorio.RepositorioCategory;
import ecommerce.category.servicio.ServiciosCategory;
import ecommerce.cliente.puerto.repositorio.RepositorioCliente;
import ecommerce.cliente.servicio.ServicioCrearCliente;
import ecommerce.employees.puerto.repositorio.RepositorioEmployee;
import ecommerce.employees.servicios.ServicioActualizarEmployee;
import ecommerce.employees.servicios.ServicioCrearEmployee;
import ecommerce.modules.puerto.repositorio.RepositorioModule;
import ecommerce.modules.servicios.ServicioCrearModulo;
import ecommerce.modules.servicios.ServiciosModulo;
import ecommerce.modulesrol.puerto.repositorio.RepositorioModulesRol;
import ecommerce.modulesrol.servicio.ServiciosModulesRol;
import ecommerce.notifications.puerto.repositorio.RepositorioNotification;
import ecommerce.notifications.servicio.ServiciosNotifications;
import ecommerce.personas.puerto.repositorio.RepositorioPersona;
import ecommerce.personas.servicio.ServicioCrearPersona;
import ecommerce.productos.puerto.repositorio.RepositorioProduct;
import ecommerce.productos.servicio.ServiciosProduct;
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

    @Bean
    public ServiciosCategory serviciosCategory(RepositorioCategory repositorioCategory){
        return new ServiciosCategory(repositorioCategory);
    }

    @Bean
    public ServiciosProduct serviciosProduct(RepositorioProduct repositorioProduct){
        return new ServiciosProduct(repositorioProduct);
    }

    @Bean
    public ServiciosModulo serviciosModulo(RepositorioModule repositorioModule){
        return new ServiciosModulo(repositorioModule);
    }
}
