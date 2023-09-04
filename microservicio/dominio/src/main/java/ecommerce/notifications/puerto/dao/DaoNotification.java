package ecommerce.notifications.puerto.dao;

import ecommerce.notifications.modelo.dto.NotificationDTO;
import ecommerce.notifications.modelo.entidad.Notification;

import java.util.List;

public interface DaoNotification {
    List<Notification> getNotificationsByEmployee(Long id);

    NotificationDTO getNotificationsList(Long id);
    Notification getNotification(Long id);
}
