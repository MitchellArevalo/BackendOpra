package ecommerce.notifications.adaptador.repositorio;

import ecommerce.infraestructura.jdbc.CustomNamedParameterJdbcTemplate;
import ecommerce.infraestructura.jdbc.sqlstatement.SqlStatement;
import ecommerce.notifications.modelo.entidad.Notification;
import ecommerce.notifications.puerto.repositorio.RepositorioNotification;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.stereotype.Repository;

@Repository
public class RepositorioNotificationPostgres implements RepositorioNotification {

    private final CustomNamedParameterJdbcTemplate customNamedParameterJdbcTemplate;

    public RepositorioNotificationPostgres(CustomNamedParameterJdbcTemplate customNamedParameterJdbcTemplate) {
        this.customNamedParameterJdbcTemplate = customNamedParameterJdbcTemplate;
    }

    @SqlStatement(namespace = "notification", value = "createNotification")
    private static String sqlCrearNotification;

    @SqlStatement(namespace = "notification", value = "updateNotification")
    private static String sqlActualizarNotification;

    @Override
    public Long create(Notification notification) {
        MapSqlParameterSource parameterSource = new MapSqlParameterSource();
        parameterSource.addValue("employee_id", notification.getEmployee().getIdEmployee());
        parameterSource.addValue("notification_subject", notification.getSubject());
        parameterSource.addValue("notification_message", notification.getMessage());
        return this.customNamedParameterJdbcTemplate.crear(parameterSource, sqlCrearNotification);
    }

    @Override
    public void update(Notification notification, Long id) {
        MapSqlParameterSource parameterSource = new MapSqlParameterSource();
        parameterSource.addValue("id", id);
        parameterSource.addValue("employee_id", notification.getEmployee().getIdEmployee());
        parameterSource.addValue("notification_subject", notification.getSubject());
        parameterSource.addValue("notification_message", notification.getMessage());
        parameterSource.addValue("notification_readed", notification.isReaded());
        this.customNamedParameterJdbcTemplate.crear(parameterSource, sqlActualizarNotification);
    }

}
