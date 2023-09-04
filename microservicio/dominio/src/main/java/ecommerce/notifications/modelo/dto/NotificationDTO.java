package ecommerce.notifications.modelo.dto;

import ecommerce.notifications.modelo.entidad.Notification;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.List;

@AllArgsConstructor
@Getter
public class NotificationDTO {
    private Long idCliente;
    private List<Notification> notificationList;
}
