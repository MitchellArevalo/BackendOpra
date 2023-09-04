package ecommerce.notifications.consulta;

import ecommerce.notifications.modelo.entidad.Notification;
import ecommerce.notifications.puerto.dao.DaoNotification;
import org.springframework.stereotype.Component;

@Component
public class ManejadorObtenerNotification {
    private final DaoNotification daoNotification;

    public ManejadorObtenerNotification(DaoNotification daoNotification) {
        this.daoNotification = daoNotification;
    }

    public Notification ejecutar(Long id){
        return daoNotification.getNotification(id);
    }
}
