package ecommerce.notifications.servicio;

import ecommerce.notifications.modelo.entidad.Notification;
import ecommerce.notifications.puerto.repositorio.RepositorioNotification;

public class ServiciosNotifications {

    private final RepositorioNotification repositorioNotification;


    public ServiciosNotifications(RepositorioNotification repositorioNotification) {
        this.repositorioNotification = repositorioNotification;
    }

    public Long crear(Notification notification){
        return this.repositorioNotification.create(notification);
    }

    public void update(Notification notification, Long id){
        this.repositorioNotification.update(notification, id);
    }

}
