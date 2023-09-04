package ecommerce.notifications.adaptador.dao;

import ecommerce.infraestructura.jdbc.CustomNamedParameterJdbcTemplate;
import ecommerce.infraestructura.jdbc.EjecucionBaseDeDatos;
import ecommerce.infraestructura.jdbc.sqlstatement.SqlStatement;
import ecommerce.notifications.adaptador.repositorio.MapeoNotification;
import ecommerce.notifications.adaptador.repositorio.MapeoNotificationDTO;
import ecommerce.notifications.modelo.dto.NotificationDTO;
import ecommerce.notifications.modelo.entidad.Notification;
import ecommerce.notifications.puerto.dao.DaoNotification;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class DaoNotificationPostgres implements DaoNotification {

    private final CustomNamedParameterJdbcTemplate customNamedParameterJdbcTemplate;
    private final MapeoNotification mapeoNotification;

    public DaoNotificationPostgres(CustomNamedParameterJdbcTemplate customNamedParameterJdbcTemplate, MapeoNotification mapeoNotification) {
        this.customNamedParameterJdbcTemplate = customNamedParameterJdbcTemplate;
        this.mapeoNotification = mapeoNotification;
    }
    @SqlStatement(namespace = "notification", value = "getNotificationByID")
    private static String sqlObtenerPorID;

    @SqlStatement(namespace = "notification", value = "getNotificationByEmployee")
    private static String sqlObtenerPorEmployee;


    @Override
    public List<Notification> getNotificationsByEmployee(Long id) {
        MapSqlParameterSource parameterSource = new MapSqlParameterSource();
        parameterSource.addValue("employee_id", id);
        return customNamedParameterJdbcTemplate.getNamedParameterJdbcTemplate().query(sqlObtenerPorEmployee, parameterSource, mapeoNotification );
    }

    @Override
    public NotificationDTO getNotificationsList(Long id) {
        return null;
    }

    @Override
    public Notification getNotification(Long id) {
        MapSqlParameterSource parameterSource = new MapSqlParameterSource();
        parameterSource.addValue("id", id);
        return EjecucionBaseDeDatos.obtenerUnObjetoONull(() -> this.customNamedParameterJdbcTemplate
                .getNamedParameterJdbcTemplate().queryForObject(sqlObtenerPorID, parameterSource, mapeoNotification));
    }
}
