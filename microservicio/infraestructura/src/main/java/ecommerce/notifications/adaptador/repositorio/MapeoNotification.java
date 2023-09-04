package ecommerce.notifications.adaptador.repositorio;

import ecommerce.employees.modelo.dto.DataDTOEmployee;
import ecommerce.employees.modelo.entidad.Employee;
import ecommerce.employees.puerto.dao.DaoEmployee;
import ecommerce.infraestructura.jdbc.MapperResult;
import ecommerce.notifications.modelo.entidad.Notification;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import java.sql.ResultSet;
import java.sql.SQLException;

@Component
public class MapeoNotification implements RowMapper<Notification>, MapperResult {

    private final DaoEmployee daoEmployee;

    public MapeoNotification(DaoEmployee daoEmployee) {
        this.daoEmployee = daoEmployee;
    }
    private Employee getEmployee(Long id){
        return daoEmployee.getEmployee(id);
    }

    @Override
    public Notification mapRow(ResultSet rs, int rowNum) throws SQLException {
        Long id = rs.getLong("id");
        Long idEmployee = rs.getLong("employee_id");
        String subject = rs.getString("notification_subject");
        String message = rs.getString("notification_message");
        boolean readed = rs.getBoolean("notification_readed");
        return Notification.reconstruir(id, getEmployee(idEmployee), subject, message, readed);
    }

}
