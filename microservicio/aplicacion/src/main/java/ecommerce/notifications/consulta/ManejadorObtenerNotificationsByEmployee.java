package ecommerce.notifications.consulta;

import ecommerce.notifications.modelo.entidad.Notification;
import ecommerce.notifications.puerto.dao.DaoNotification;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ManejadorObtenerNotificationsByEmployee {
    private final DaoNotification daoNotification;

    public ManejadorObtenerNotificationsByEmployee(DaoNotification daoNotification) {
        this.daoNotification = daoNotification;
    }

    public List<Notification> ejecutar(Long id){
        return daoNotification.getNotificationsByEmployee(id);
    };
}
