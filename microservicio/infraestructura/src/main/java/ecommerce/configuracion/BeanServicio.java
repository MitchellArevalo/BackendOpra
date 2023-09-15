package ecommerce.configuracion;
import ecommerce.category.puerto.repositorio.RepositorioCategory;
import ecommerce.category.servicio.ServiciosCategory;
import ecommerce.cliente.puerto.repositorio.RepositorioCliente;
import ecommerce.cliente.servicio.ServiciosCliente;
import ecommerce.employees.puerto.repositorio.RepositorioEmployee;
import ecommerce.employees.servicios.ServicioActualizarEmployee;
import ecommerce.employees.servicios.ServicioCrearEmployee;
import ecommerce.inputs.puerto.repositorio.RepositorioInputProduct;
import ecommerce.inputs.servicio.ServiciosInputProduct;
import ecommerce.modules.puerto.repositorio.RepositorioModule;
import ecommerce.modules.servicios.ServicioCrearModulo;
import ecommerce.modules.servicios.ServiciosModulo;
import ecommerce.modulesrol.puerto.repositorio.RepositorioModulesRol;
import ecommerce.modulesrol.servicio.ServiciosModulesRol;
import ecommerce.notifications.puerto.repositorio.RepositorioNotification;
import ecommerce.notifications.servicio.ServiciosNotifications;
import ecommerce.outputproducts.puerto.repositorio.RepositorioOutputProduct;
import ecommerce.outputproducts.servicio.ServiciosOutputProduct;
import ecommerce.payment.puerto.repositorio.RepositorioPayment;
import ecommerce.payment.servicio.ServiciosPayment;
import ecommerce.productos.puerto.repositorio.RepositorioProduct;
import ecommerce.productos.servicio.ServiciosProduct;
import ecommerce.roles.puerto.repositorio.RepositorioRol;
import ecommerce.roles.servicio.ServicioCrearRol;
import ecommerce.sales.puerto.repositorio.RepositorioSale;
import ecommerce.sales.servicio.ServiciosSales;
import ecommerce.salesproducts.puerto.dao.DaoSaleProduct;
import ecommerce.salesproducts.puerto.repositorio.RepositorioSaleProduct;
import ecommerce.salesproducts.servicio.ServiciosSaleProducts;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BeanServicio {
    //region Cliente
    @Bean
    public ServiciosCliente servicioCrearCliente (RepositorioCliente repositorioCliente){
        return new ServiciosCliente(repositorioCliente);
    }
    //endregion

    @Bean
    public ServicioCrearRol servicioCrearRol(RepositorioRol repositorioRol){
        return new ServicioCrearRol(repositorioRol);
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

    @Bean
    public ServiciosInputProduct serviciosInputProduct(RepositorioInputProduct repositorioInputProduct, RepositorioProduct repositorioProduct){
        return new ServiciosInputProduct(repositorioInputProduct, repositorioProduct);
    }
    @Bean
    public ServiciosOutputProduct serviciosOutputProduct(RepositorioOutputProduct repositorioOutputProduct, RepositorioProduct repositorioProduct){
        return new ServiciosOutputProduct(repositorioOutputProduct, repositorioProduct);
    }
    @Bean
    public ServiciosSales serviciosSales(RepositorioSale repositorioSale){
        return new ServiciosSales(repositorioSale);
    }

    @Bean
    public ServiciosSaleProducts serviciosSaleProducts(RepositorioSaleProduct repositorioSaleProduct, RepositorioSale repositorioSale){
        return new ServiciosSaleProducts(repositorioSaleProduct, repositorioSale);
    }

    @Bean
    public ServiciosPayment serviciosPayment(RepositorioPayment repositorioPayment, RepositorioSale repositorioSale, DaoSaleProduct daoSaleProduct, RepositorioProduct repositorioProduct){
        return new ServiciosPayment(repositorioPayment, repositorioSale, daoSaleProduct, repositorioProduct);
    }

}
