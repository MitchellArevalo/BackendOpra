package ecommerce.notifications.puerto.repositorio;

import ecommerce.notifications.modelo.entidad.Notification;


public interface RepositorioNotification {
    Long create(Notification notification);

    void update(Notification notification, Long id);
}
