package ecommerce.configuracion;
import ecommerce.cliente.puerto.repositorio.RepositorioCliente;
import ecommerce.cliente.servicio.ServicioCrearCliente;
import ecommerce.employees.puerto.repositorio.RepositorioEmployee;
import ecommerce.employees.servicios.ServicioActualizarEmployee;
import ecommerce.employees.servicios.ServicioCrearEmployee;
import ecommerce.modulos.puerto.repositorio.RepositorioModule;
import ecommerce.modulos.servicios.ServiciosModule;
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
    public ServiciosModule serviciosModule(RepositorioModule repositorioModule){
        return new ServiciosModule(repositorioModule);
    }
}
