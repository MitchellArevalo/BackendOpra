package ecommerce.configuracion;
import ecommerce.cliente.puerto.repositorio.RepositorioCliente;
import ecommerce.cliente.servicio.ServicioCrearCliente;
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
}
