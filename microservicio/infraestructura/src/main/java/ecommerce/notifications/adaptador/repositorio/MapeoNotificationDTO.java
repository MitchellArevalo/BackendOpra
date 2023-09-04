package ecommerce.notifications.adaptador.repositorio;

import ecommerce.notifications.modelo.dto.NotificationDTO;
import ecommerce.notifications.modelo.entidad.Notification;
import ecommerce.notifications.puerto.dao.DaoNotification;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Component
public class MapeoNotificationDTO implements RowMapper<NotificationDTO> {
    private final DaoNotification daoNotification;

    public MapeoNotificationDTO(DaoNotification daoNotification) {
        this.daoNotification = daoNotification;
    }

    @Override
    public NotificationDTO mapRow(ResultSet rs, int rowNum) throws SQLException {
        Long idCliente = rs.getLong("employee_id");
        List<Notification> listaNotifications = daoNotification.getNotificationsByEmployee(idCliente);
        return new NotificationDTO(idCliente, listaNotifications);
    }
}
